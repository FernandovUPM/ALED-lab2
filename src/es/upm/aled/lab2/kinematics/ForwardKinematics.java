package es.upm.aled.lab2.kinematics;

import es.upm.aled.lab2.gui.Node;

/**
 * This class implements a forward kinematics algorithm using recursion. It
 * expects a tree of Segments (defined by its length and angle with respect to
 * the previous Segment in the tree) and returns a tree of Nodes (defined by
 * their absolute coordinates in a 2-dimensional space).
 * 
 * @author rgarciacarmona
 */
public class ForwardKinematics {
	double originX, originY;
	Segment root = new Segment(originX, originY);
	
	double baseX, baseY;
	Segment link = new Segment(baseX, baseY);
	
	double accumulatedAngle = 0.0;
	
	/**
	 * Returns a tree of Nodes to be used by SkeletonPanel to draw the position of
	 * an exoskeleton. This method is the public facade to a recursive method that
	 * builds the result from a tree of Segments defined by their angle and length,
	 * and the relationship between them (which Segment is children of which).
	 * 
	 * @param root    The root of the tree of Segments.
	 * @param originX The X coordinate for the origin point of the tree.
	 * @param originY The Y coordinate for the origin point of the tree.
	 * @return The tree of Nodes that represent the exoskeleton position in absolute
	 *         coordinates.
	 */
	// Public method: returns the root of the position tree
	public static Node computePositions(Segment root, double originX, double originY) {
		return computePositions(root, originX, originY, 0);
	}

	// Private helper method that implements the recursive algorithm
	private static Node computePositions(Segment link, double baseX, double baseY, double accumulatedAngle) {
		
		accumulatedAngle += link.getAngle();
		double X = 0.0;
		double Y = 0.0;
		
		X = baseX + link.getLength()*Math.cos(accumulatedAngle);
		Y = baseY + link.getLength()*Math.sin(accumulatedAngle);
		
		Node nodoActual = new Node(X,Y);
		
		if(link.getChildren().size()== 0) {
			return nodoActual;
		}
		
		for(Segment s : link.getChildren()) {
			Node childNode = computePositions(s, X, Y, accumulatedAngle);
			nodoActual.addChild(childNode);
		}
		return nodoActual;
	}
}
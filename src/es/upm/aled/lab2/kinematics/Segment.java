package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

import es.upm.aled.lab2.gui.Node;

public class Segment {
	private double length, angle;
	private List<Segment> children = new ArrayList<>();

	/**
	 * Builds a new Segment from its absolute position.
	 * 
	 * @param length The length coordinate.
	 * @param angle The angle coordinate.
	 */
	public Segment(double length, double angle) {
		this.length = length;
		this.angle = angle;
		this.children = new ArrayList<>();
		
	}
	/**
	 * Returns the length coordinate.
	 * 
	 * @return The length coordinate.
	 */
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	/**
	 * Returns the angle coordinate.
	 * 
	 * @return The angle coordinate.
	 */
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	/**
	 * Returns the Segments this one is connected to. The children Segments don't have a
	 * reference to the parent Segment, so the connection is one-way.
	 * 
	 * @return A List of all the children Segments.
	 */
	public List<Segment> getChildren() {
		return children;
	}
	/**
	 * Adds a new Node to the List of Segments this one is connected to. Each Segment can
	 * only appear as a child once.
	 * 
	 * @param measurement The Segment to be added.
	 */
	public void addChild(Segment child) {
		if (!children.contains(child))
			children.add(child);
	}


}

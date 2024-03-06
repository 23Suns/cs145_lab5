package fractalgui.practice;

import java.awt.*;
import java.awt.geom.Point2D;

public class KochLine {

	private Point2D.Double start;
	private Point2D.Double end;

	public KochLine(Point2D.Double start, Point2D.Double end) {
		this.start = start;
		this.end = end;
	}

	public Point2D.Double start() {
		return start;
	}

	public Point2D.Double end() {
		return end;
	}

	public void display(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());
	}

	// Calculates the point 1/3 of the way from the start to the end
	public Point2D.Double kochLeft(Point2D.Double a, Point2D.Double b) {
		Point2D.Double v = new Point2D.Double(b.getX() - a.getX(), b.getY() - a.getY());
		v.setLocation(v.getX() / 3, v.getY() / 3);
		v.setLocation(v.getX() + a.getX(), v.getY() + a.getY());
		return v;
	}

	// Calculates the middle point using vector subtraction and rotation
	public Point2D.Double kochMiddle(Point2D.Double a, Point2D.Double b) {
		Point2D.Double v = new Point2D.Double(b.getX() - a.getX(), b.getY() - a.getY());
		v.setLocation(v.getX() / 3, v.getY() / 3);

		Point2D.Double p = new Point2D.Double(a.getX(), a.getY());
		p.setLocation(p.getX() + v.getX(), p.getY() + v.getY());

		rotate(v, Math.toRadians(-60));
		p.setLocation(p.getX() + v.getX(), p.getY() + v.getY());

		return p;
	}

	// Calculates the point 2/3 of the way from the start to the end
	public Point2D.Double kochRight(Point2D.Double a, Point2D.Double b) {
		Point2D.Double v = new Point2D.Double(b.getX() - a.getX(), b.getY() - a.getY());
		v.setLocation(v.getX() / 3, v.getY() / 3);
		v.setLocation(v.getX() + b.getX(), v.getY() + b.getY());
		return v;
	}

	// Rotates a vector by a given angle in radians
	private void rotate(Point2D.Double v, double theta) {
		double xTemp = v.getX();
		// Might need to check for rounding errors like with angleBetween function?
		v.setLocation(v.getX() * Math.cos(theta) - v.getY() * Math.sin(theta),
				xTemp * Math.sin(theta) + v.getY() * Math.cos(theta));
	}
}

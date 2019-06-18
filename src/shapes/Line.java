package shapes;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Point;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;

	public Line() {

	}

	public Line(Point start, Point end) {
		this.startPoint = start;
		this.endPoint = end;
	}

	public Line(Point start, Point end, Color color) {
		super(color);
		this.startPoint = start;
		this.endPoint = end;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point start) {
		this.startPoint = start;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point end) {
		this.endPoint = end;
	}

	public void moveTo(int x, int y) {
		startPoint.moveTo(x, y);
		endPoint.moveTo(x, y);
	}

	public void moveFor(int poX, int poY) {
		startPoint.moveFor(poX, poY);
		endPoint.moveFor(poX, poY);
	}

	public String toString() {
		return "Line:("+startPoint.getX()+"-"+startPoint.getY() + ")->(" + endPoint.getX()+"-"+endPoint.getY()+")->"+getColor().toString();
	}

	public Point middleOfTheLine() {
		int xMiddle = (endPoint.getX() + startPoint.getX()) / 2;
		int yMiddle = (endPoint.getY() + startPoint.getY()) / 2;
		Point middle = new Point(xMiddle, yMiddle);
		return middle;
	}

	public double length() {
		return startPoint.distance(endPoint);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line forwarded = (Line) obj;
			if (startPoint.equals(forwarded.startPoint) && endPoint.equals(forwarded.endPoint)) {
				return true;
			} else
				return false;
		}
		return false;
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());

		if (isSelected()) {
			selected(g);
		}
	}

	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		startPoint.selected(g);
		endPoint.selected(g);
		middleOfTheLine().selected(g);
	}

	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int) (this.length() - ((Line) o).length());
		}
		return 0;
	}

	public boolean contains(int x, int y) {
		Point p = new Point(x, y);
		if ((startPoint.distance(p) + endPoint.distance(p)) - length() <= 1)
			return true;
		else
			return false;
	}

	@Override
	public Shape clone() {
		Line l = new Line();

		l.setStartPoint(new Point(this.getStartPoint().getX(), this.getStartPoint().getY()));

		l.setEndPoint(new Point(this.getEndPoint().getX(), this.getEndPoint().getY()));

		l.setColor(this.getColor());

		return l;
	}
}

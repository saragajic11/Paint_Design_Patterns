package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends SurfaceShape {
	protected Point upperLeft;
	protected int page;

	public Square() {

	}

	public Square(Point upperLeft, int page) {
		this.upperLeft = upperLeft;
		this.page = page;
	}

	public Square(Point upperLeft, int page, Color color) {
		this(upperLeft, page);
		setColor(color);
	}

	public Square(Point upperLeft, int page, Color color, Color colorInside) {
		this(upperLeft, page, color);
		setColorInside(colorInside);
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
	}

	public void moveFor(int poX, int poY) {
		upperLeft.moveFor(poX, poY);
	}

	public double area() {
		return page * page;
	}

	public double perimeter() {
		return 4 * page;
	}

	public String toString() {
		return "Square:UpperLeft(" + upperLeft.getX()+","+upperLeft.getY() + ") Page(" + page + ") "+getColor()+" "+getColorInside();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Square) {
			Square forwarded = (Square) obj;
			if (upperLeft.equals(forwarded.getUpperLeft()) && page == forwarded.getPage()) {
				return true;
			} else
				return false;
		}
		return false;
	}

	public Line diagonal() {
		Point downRight = new Point(upperLeft.getX() + page, upperLeft.getY() + page);
		return new Line(upperLeft, downRight);
	}

	public Point middleOfDiagonal() {
		return diagonal().middleOfTheLine();
	}

	public void draw(Graphics g) {
		fill(g);
		g.setColor(getColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), page, page);
		if (isSelected())
			selected(g);
	}

	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX() + page, getUpperLeft().getY())).selected(g);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX(), getUpperLeft().getY() + page)).selected(g);
		new Line(new Point(getUpperLeft().getX() + page, getUpperLeft().getY()), diagonal().getEndPoint()).selected(g);
		new Line(new Point(getUpperLeft().getX(), getUpperLeft().getY() + page), diagonal().getEndPoint()).selected(g);
	}

	public int compareTo(Object o) {
		if (o instanceof Square) {
			return (int) (-this.area() + ((Square) o).area());
		} else
			return 0;
	}

	public void fill(Graphics g) {
		g.setColor(getColorInside());
		g.fillRect(upperLeft.getX() + 1, upperLeft.getY() + 1, page - 1, page - 1);
	}

	public boolean contains(int x, int y) {
		if (this.getUpperLeft().getX() <= x && x <= (this.getUpperLeft().getX() + page)
				&& this.getUpperLeft().getY() <= y && y <= (this.getUpperLeft().getY() + page))
			return true;
		else
			return false;
	}

	@Override
	public Shape clone() {
		Square s = new Square();
		s.setUpperLeft(new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY()));
		s.setPage(this.getPage());
		return s;
	}

}

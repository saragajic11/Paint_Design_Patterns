package adapter;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;
import shapes.Point;
import shapes.SurfaceShape;

public class HexagonAdapter extends SurfaceShape {

	private Hexagon hexagon;

	public HexagonAdapter(Hexagon hexagon) {
		this.hexagon = hexagon;
	}

	public HexagonAdapter(Hexagon hexagon, Color edgeColor, Color areaColor) {
		this(hexagon);
		hexagon.setBorderColor(edgeColor);
		hexagon.setAreaColor(areaColor);
	}

	public HexagonAdapter(Point startP, int radius) {
		this.hexagon = new Hexagon(startP.getX(), startP.getY(), radius);
	}

	public HexagonAdapter(Point startPoint, int radius, Color color) {
		this(startPoint, radius);
		setEdgeColor(color);
	}

	public HexagonAdapter(Point startPoint, int radius, Color color, Color innerColor) {
		this(startPoint, radius, color);
		setAreaColor(innerColor);
	}

	@Override
	public void moveTo(int x, int y) {
		hexagon.setX(x);
		hexagon.setY(y);

	}

	@Override
	public void moveFor(int poX, int poY) {
		hexagon.setX(hexagon.getX() + poX);
		hexagon.setY(hexagon.getY() + poY);

	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof HexagonAdapter)
			return hexagon.getR() - ((HexagonAdapter) o).getR();
		return 0;
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		return 0;
	}

	@Override
	public void fill(Graphics g) {
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
		hexagon.setSelected(isSelected());

	}

	@Override
	public void selected(Graphics g) {
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HexagonAdapter) {
			Hexagon hex = ((HexagonAdapter) obj).hexagon;
			return hexagon.getX() == hex.getX() && hexagon.getY() == hex.getY() && hexagon.getR() == hex.getR();
		}
		return false;
	}

	@Override
	public void setSelected(boolean selected) {
		hexagon.setSelected(selected);
		super.setSelected(selected);
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return hexagon.isSelected();
	}
	
	public HexagonAdapter clone() {
		Hexagon hexagon = new Hexagon(getXCoordinate(), getYCoordinate(), getR());
		hexagon.setBorderColor(getEdgeColor());
		hexagon.setAreaColor(getAreaColor());
		return new HexagonAdapter(hexagon);
	}

	public int getR() {
		return hexagon.getR();
	}

	public void setR(int r) {
		hexagon.setR(r);
	}

	public int getXCoordinate() {
		return hexagon.getX();
	}

	public int getYCoordinate() {
		return hexagon.getY();
	}

	public Color getEdgeColor() {
		return hexagon.getBorderColor();
	}

	public void setEdgeColor(Color color) {
		hexagon.setBorderColor(color);
	}

	public Color getAreaColor() {
		return hexagon.getAreaColor();
	}

	public void setAreaColor(Color color) {
		hexagon.setAreaColor(color);
	}

	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	public String toString() {
		return "Hexagon:Center(" + hexagon.getX() + ","+hexagon.getY() + ") Radius(" + hexagon.getR() + ") "+hexagon.getBorderColor()+" "+hexagon.getAreaColor();
	}
	
}

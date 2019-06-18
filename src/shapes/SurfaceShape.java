package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class SurfaceShape extends Shape{

	private Color colorInside=Color.WHITE;
	
	public abstract double area();
	public abstract double perimeter();
	public abstract void fill(Graphics g);
	
	public Color getColorInside() {
		return colorInside;
	}
	public void setColorInside(Color colorInside) {
		this.colorInside=colorInside;
	}
}

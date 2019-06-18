package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
public abstract class Shape implements Movable,Comparable, Cloneable, Serializable{

	private Color color=Color.black;
	private boolean selected;
	public Shape() {
		
	}
	public Shape(Color color) {
		this.color=color;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color=color;
	}
	public static Color findColor(String color) {
		if(color.equalsIgnoreCase("white")) {
			return Color.WHITE;
		}
		else if(color.equalsIgnoreCase("green")) {
			return Color.GREEN;
		}
		else if(color.equalsIgnoreCase("red")) {
			return Color.RED;
		}
		else if(color.equalsIgnoreCase("blue")) {
			return Color.BLUE;
		}
		else if(color.equalsIgnoreCase("yellow"))
			return Color.YELLOW;
		else if(color.equalsIgnoreCase("pink"))
			return Color.PINK;
		else
			return Color.BLACK;
	}
	public abstract void draw(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean contains(int x, int y);
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected=selected;
	}
	public abstract Shape clone();
	
}

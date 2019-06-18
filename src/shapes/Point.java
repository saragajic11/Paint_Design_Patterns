package shapes;

import java.awt.Color;
import java.awt.Graphics;


public class Point extends Shape {

	private int x;
	private int y;
	public Point() {
		
	}
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public Point(int x,int y,Color color) {
		//super(boja);
		this(x,y);
		setColor(color);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x=x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void moveTo(int x,int y) {
		this.x=x;
		setY(y);
	}
	public void moveFor(int poX,int poY) {
		this.x+=poX;
		this.y+=poY;
	}
	public double distance(Point t) {
		int dx=x-t.x;
		int dy=y-t.y;
		double distance=Math.sqrt(dx*dx+dy*dy);
		return distance;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point forwarded=(Point)obj;
			if(forwarded.getX()==this.x && forwarded.getY()==this.y) {
				return true;
			}
			else
				return false;
		}
		return false;
	}
	public String toString() {
		return "Point:"+"(" + x + "-" + y + ") "+getColor().toString();
	}
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y+2 , x , y-2);
		
		if(isSelected())
			selected(g);
	}
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x-3, y-3, 6, 6);
	}
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point start=new Point(0,0);
			return (int) (this.distance(start)-((Point)o).distance(start));
		}
		else
			return 0;
	}

	public boolean contains(int x, int y) {
		if(this.distance(new Point(x, y))<=2)
			return true;
		return false;
	}
	@Override
	public Shape clone() {
		Point point = new Point();
		point.setX(this.getX());
		point.setY(this.getY());
		point.setColor(this.getColor());
		return point;
	}

}

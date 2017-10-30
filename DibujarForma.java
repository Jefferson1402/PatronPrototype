package DrawingTools;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

public abstract class DibujarForma {
	
	protected Shape mShape;
	
	public Shape getShape() { return mShape; }
	public void setShape(Shape shape) { this.mShape = shape; }
	
	public abstract DibujarForma clone();
	public abstract void draw(Graphics2D g2D);	
	public abstract Rectangle getBounds();
	
	public abstract void inicioDibujo(Point point);
	public abstract void dibujando(Point point);
	public abstract void terminarDibujo(Point point);
}
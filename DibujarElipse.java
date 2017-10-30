package DrawingTools;

import DrawingTools.DibujarForma;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class DibujarElipse extends DibujarForma {
	
	public DibujarElipse() {
		super();
		mShape = new Ellipse2D.Double();
	}
	
	@Override
	public DibujarForma clone() {
		return new DibujarElipse();
	}
	
	@Override
	public void draw(Graphics2D g2D) {
		g2D.draw(mShape);
	}
	
	@Override
	public Rectangle getBounds() {
		return mShape.getBounds();
	}

	public void inicioDibujo(Point point) {
		Ellipse2D.Double ellipse = (Ellipse2D.Double) mShape;
		ellipse.setFrame(point.x, point.y, 0, 0);
	}

	@Override
	public void dibujando(Point point) {
		Ellipse2D.Double ellipse = (Ellipse2D.Double) mShape;
		ellipse.setFrame(ellipse.x, ellipse.y, point.x - ellipse.x, point.y - ellipse.y);
	}

	@Override
	public void terminarDibujo(Point p) {
	}


   

  
}
package DrawingTools;


import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public  class DibujarLinea extends DibujarForma {
	
	public DibujarLinea() {
		super();
		mShape = new Line2D.Double();
	}
	
	@Override
	public DibujarForma clone() {
		return new DibujarLinea();
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
		Line2D.Double line = (Line2D.Double) mShape;
		line.setLine(point, point);
	}

	@Override
	public void dibujando(Point point) {
		Line2D.Double line = (Line2D.Double) mShape;
		line.setLine(line.getP1(), point);
	}

	@Override
	public void terminarDibujo(Point p) {
	}


 
}

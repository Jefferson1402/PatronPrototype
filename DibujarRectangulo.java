package DrawingTools;


import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class DibujarRectangulo extends DibujarForma {
	
	public DibujarRectangulo() {
		super();
		mShape = new Rectangle();
	}
	
	@Override
	public DibujarForma clone() {
		return new DibujarRectangulo();
	}
	
	@Override
	public void draw(Graphics2D g2D) {
		g2D.draw(mShape);
          
	}
	
	@Override
	public Rectangle getBounds() {
		return mShape.getBounds();
	}
        
          
        @Override
	public void inicioDibujo(Point point) {
		Rectangle rectangle = (Rectangle)mShape;
		rectangle.setLocation(point.x, point.y);
	}

        @Override
	public void dibujando(Point point) {
		Rectangle rectangle = (Rectangle)mShape;
		rectangle.setSize(point.x - rectangle.x, point.y - rectangle.y);
	}

	@Override
	public void terminarDibujo(Point p) {
	}

   

 
}
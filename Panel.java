
import Factory.PrototypeFactory;
import DrawingTools.*;
import Constante.Constantes;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;

    
public class Panel extends JPanel {
	
	
	
	private Constantes.DRAWING_STATE EstadoDibujo;

	
	private ArrayList<DibujarForma> Formas;
	private MouseEventHandler mouseEventHandler;
	
	
	private PrototypeFactory mPrototypeFactory;
	private DibujarRectangulo PrototypeRectangulo;
	private DibujarElipse PrototypeElipse;
	private DibujarLinea mPrototypeLinea;
	
	
	private DibujarForma FormaActual;
	
	
	public Panel() {
           
		
		EstadoDibujo = Constantes.DRAWING_STATE.idle;
		
		
		Formas = new ArrayList<DibujarForma>();
		
		mouseEventHandler = new MouseEventHandler();
		addMouseListener(mouseEventHandler);
		addMouseMotionListener(mouseEventHandler);
		
		mPrototypeFactory = new PrototypeFactory();
		PrototypeRectangulo = new DibujarRectangulo();
		PrototypeElipse = new DibujarElipse();
		mPrototypeLinea = new DibujarLinea();
		
		setBackground(Color.WHITE);
	}
	
	public void init() {
	}
	
	// Getters and Setters
	public ArrayList<DibujarForma> getFormas() {
		return Formas;
	}
	
	public void setFormas(ArrayList<DibujarForma> formas) {
		if(formas == null) {
			Formas.clear();
		} else {
			Formas = formas;
		}
		
		repaint();
	}
	
	public void setAccionDibujar(String comandoaccion) {
		if(comandoaccion.equals(Constantes.TOOLBAR_BUTTONNAMES.rectangulo.toString())) {
			mPrototypeFactory.setPrototype(PrototypeRectangulo);
		} else if(comandoaccion.equals(Constantes.TOOLBAR_BUTTONNAMES.elipse.toString())) {
			mPrototypeFactory.setPrototype(PrototypeElipse);
		} else if(comandoaccion.equals(Constantes.TOOLBAR_BUTTONNAMES.linea.toString())) {
			mPrototypeFactory.setPrototype(mPrototypeLinea);
		}
	}

	public void inicioDibujo(Point puntoInicio) {
		FormaActual = mPrototypeFactory.makeShape();
		Graphics2D g2D = (Graphics2D) getGraphics();
		FormaActual.inicioDibujo(puntoInicio);
		FormaActual.draw(g2D);
	}

	public void dibujando(Point currentPoint) {
		Graphics2D g2D = (Graphics2D) getGraphics();
		g2D.setXORMode(getBackground());
		float[] dashes = { 4 };
		g2D.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, dashes, 1));
		FormaActual.draw(g2D);
		FormaActual.dibujando(currentPoint);
		FormaActual.draw(g2D);
	}
	
	public void terminarDibujo(Point p) {
		if(!(FormaActual.getBounds().width == 0 && FormaActual.getBounds().height == 0)) {
			Formas.add(FormaActual);
				
			Graphics2D g2D = (Graphics2D) getGraphics();
			FormaActual.draw(g2D);
			repaint();
		}
	}
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		for(DibujarForma s : Formas) {
			s.draw(g2D);
		}
	}
	
	private class MouseEventHandler implements MouseListener, MouseMotionListener {

		
		public void mouseClicked(MouseEvent e) {
		}
		
	
		public void mouseMoved(MouseEvent e) {
		}		
		
		
		public void mousePressed(MouseEvent e) {
			Point point = e.getPoint();
			if(EstadoDibujo == Constantes.DRAWING_STATE.idle) {
				inicioDibujo(point);
				EstadoDibujo = Constantes.DRAWING_STATE.dibujando;
			}
		}
		
		
		public void mouseDragged(MouseEvent e) {
			Point point = e.getPoint();
			if(EstadoDibujo == Constantes.DRAWING_STATE.dibujando) {
				dibujando(point);	
			}
		}
		
	
		public void mouseReleased(MouseEvent e) {
			Point point = e.getPoint();
			if(EstadoDibujo == Constantes.DRAWING_STATE.dibujando) {
				terminarDibujo(point);
				EstadoDibujo = Constantes.DRAWING_STATE.idle;
			}
		}
		
		
		public void mouseEntered(MouseEvent e) {
		}
		
		
		public void mouseExited(MouseEvent e) {
		}
	}

}
	
	

import java.awt.BorderLayout;
import javax.swing.JFrame;



public class Frame extends JFrame{
	
	
	
	// componentes
	private BarraHerramientas BarraHerramientas;
	private Panel mPanel;
	
	public Frame() {
           
		
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Patron Prototype");
		 this.setLocationRelativeTo(null);
		// componentes		
		BarraHerramientas = new BarraHerramientas();
		this.add(BorderLayout.NORTH, BarraHerramientas);
		BarraHerramientas.setSize(800,860);
		
		mPanel = new Panel();
		this.add(mPanel);
	}

	public void init() {
		// associations
		BarraHerramientas.setPanel(mPanel);
		
		// component initialize
		BarraHerramientas.init();
		mPanel.init();
		
	}
}
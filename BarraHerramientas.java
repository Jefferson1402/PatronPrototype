
import Constante.Constantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BarraHerramientas extends JToolBar {

	
	
	// componentes
	private ButtonGroup mButtonGroup;
        //ActionListener se usa para detectar y manejar eventos 
	private ToolBarActionListener mToolBarActionListener;
	
	// association
	private Panel mPanel;
	
	public BarraHerramientas() {
		
		// componentes
		mToolBarActionListener = new ToolBarActionListener();
		mButtonGroup = new ButtonGroup();
                     
		for (int i = 0; i <3; i++) {
			
                        JRadioButton button = new JRadioButton(); 
			
                        button.setText(Constantes.TOOLBAR_BUTTONNAMES.values()[i].toString());
			button.addActionListener(mToolBarActionListener);
			mButtonGroup.add(button);
			this.add(button);
		}
	}
	
	public void init() {
		JRadioButton button = (JRadioButton) this.getComponent(Constantes.TOOLBAR_BUTTONNAMES.rectangulo.ordinal());
		button.doClick();
	}
	
	public void setPanel(Panel panel) {
		mPanel = panel;
	}
	
	private class ToolBarActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton button = (JRadioButton) e.getSource();
			mPanel.setAccionDibujar(button.getActionCommand());
		}
	}
}
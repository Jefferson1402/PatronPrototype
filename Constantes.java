package Constante;


import java.awt.Color;

public class Constantes {	
	

	public static enum TOOLBAR_BUTTONNAMES {
		rectangulo,
		elipse,
		linea
	};
	
	
	public final static String TOOLBAR_BUTTONICON_FOLDER = "icon/";
	public final static String TOOLBAR_BUTTONICON_TYPE = ".PNG";
	public final static String TOOLBAR_BUTTONICON_SLT = "SLT";
	
	public static enum DRAWING_STATE{
		dibujando,
		idle,
	};
	
	public static final Color FOREGROUND_COLOR = Color.BLACK;
	public static final Color BACKGROUND_COLOR = Color.WHITE;
	
}
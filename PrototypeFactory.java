package Factory;


import DrawingTools.DibujarForma;


public class PrototypeFactory extends ShapeFactory {

	private DibujarForma mPrototype;
	
	public void setPrototype(DibujarForma prototype) {
		mPrototype = prototype;
	}
	
	@Override
	public DibujarForma makeShape() {
		return mPrototype.clone();
	}
}

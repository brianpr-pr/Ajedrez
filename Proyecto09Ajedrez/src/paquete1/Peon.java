package paquete1;

public final class Peon extends Piezas {
	private boolean primerMovimiento; 
	public Peon(String nombre, int posiciony, int posicionx,String color) {
		super(nombre, posiciony, posicionx, color);
		primerMovimiento = true;
	}
	
	public boolean isPrimerMovimiento() {
		return primerMovimiento;
	}
	
	public static boolean primerMovimiento(Piezas x) {
		
		if(x instanceof Peon) {
			Peon temporal = (Peon)x;
			if(temporal.isPrimerMovimiento()) {
				return true;
				
			}
			
		}
		
		return false;
	}
	
	
	public void setPrimerMovimiento() {
		this.primerMovimiento = false;
	}
	
	
	
	
	
	

}

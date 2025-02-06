package paquete1;

public final class Peon extends Piezas {
	boolean primerMovimiento; 
	public Peon(String nombre, int posiciony, int posicionx,String color) {
		super(nombre, posiciony, posicionx, color);
		primerMovimiento = true;
	}
	
	
	public void avanzar() {//Metodo que comprueba color de la pieza peon en caso de ser negra solo podemos modificar el eje de y a valores menores de 1 en 1
		if(this.getColor().equals("negra")) {
			
			if(this.getPosiciony() > 0) {
				this.setPosiciony(this.getPosiciony()-1);
			}
			else{
				System.out.println("No puedes avanzar mas con tu peon de color negro. Esta pieza se encuentra en el borde.");
			}
		}
		
		else if (this.getColor().equals("blanca")){
			if(this.getPosiciony() < 7) {
				this.setPosiciony(this.getPosiciony()+1);
			}
			else{
				System.out.println("No puedes avanzar mas con tu peon de color blanco. Esta pieza se encuentra en el borde.");
			}
		}
	}
	
	
	

}

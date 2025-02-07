package paquete1;

public  sealed class Piezas permits Peon, Torre, Caballo, Alfil, Rey, Reyna{
	
	private String nombre;
	private int posiciony;
	private int posicionx;
	private String color; 
	
	public Piezas(String nombre, int posiciony, int posicionx, String color) {
		this.nombre = nombre;
		setPosiciony(posiciony);
		setPosicionx(posicionx);
		this.color = color;
	}
	
	
	
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPosiciony() {
		return posiciony;
	}

	public void setPosiciony(int posiciony) {
		if(posiciony >= 0 && posiciony < 8) {
			this.posiciony = posiciony;
		}
	}

	public int getPosicionx() {
		return posicionx;
	}

	
	
	public void setPosicionx(int posicionx) {
		
		if(posiciony >= 0 && posiciony < 8) {
			this.posicionx = posicionx;
		}
		
	}

	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Piezas [nombre=" + getNombre()+ ", posiciony=" + getPosiciony() + ", posicionx=" + getPosicionx() + ", color=" + color
				+ "]";
	}
	
	
	public boolean moverFicha(int y, int x) {
		return true;
	}
	
	
	

}

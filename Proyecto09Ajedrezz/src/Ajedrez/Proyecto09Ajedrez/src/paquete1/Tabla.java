package paquete1;
import java.util.*;
public class Tabla {
	private Piezas[] negras = new Piezas[16];
	private Piezas[] blancas = new Piezas[16];
	private Piezas[][] tablero = new Piezas[8][8];
	private Scanner sc;
	public Tabla() {
		setPiezas("negras");
		setPiezas("blancas");
		setTablero();
		sc = new Scanner(System.in);
	}
	
	private void setPiezas(String color) {
		if(color.equals("negras")) {
			negras[0] = new Torre("Torre1", 0, 0,"negra");
			negras[7] = new Torre("Torre2", 0, 7,"negra");
			negras[1] = new Caballo("Caballo1", 0, 1,"negra");
			negras[6] = new Caballo("Caballo2", 0, 6,"negra");
			negras[2] = new Alfil("Alfil1", 0, 2,"negra");
			negras[5] = new Alfil("Alfil2", 0, 5,"negra");
			negras[3] = new Rey("Rey", 0, 3,"negra");
			negras[4] = new Reyna("Reyna", 0, 4,"negra");
			
			
			for(int index = 8,i = 0 ; i < 8 ; i++, index++) { //loop iterates 8 times creating the 8 peons 
				String nombrePeon = "Peon" + (i+1);
				negras[index] = new Peon(nombrePeon, 1,i, "negra");
			}	
		}
		else{
			
			blancas[0] = new Torre("Torre1", 6, 0,"blanca");
			blancas[7] = new Torre("Torre2", 6, 7,"blanca");
			blancas[1] = new Caballo("Caballo1", 6, 1,"blanca");
			blancas[6] = new Caballo("Caballo2", 6, 6,"blanca");
			blancas[2] = new Alfil("Alfil1", 6, 2,"blanca");
			blancas[5] = new Alfil("Alfil2", 6, 5,"blanca");
			blancas[3] = new Rey("Rey", 6, 3,"blanca");
			blancas[4] = new Reyna("Reyna", 6, 4,"blanca");
			
			for(int index = 8,i = 0 ; i < 8 ; i++, index++) { //loop iterates 8 times creating the 8 peons 
				String nombrePeon = "Peon" + (i+1);
				blancas[index] = new Peon(nombrePeon, 7,i, "blanca");
			}
		}
	}
	
	
	public Piezas[] getNegras() {
		return negras;
	}

	

	public Piezas[] getBlancas() {
		return blancas;
	}
	
	
	//Completar array con posiciones de fichas en tablero;
	public void mostrarPosiciones() {
		String imagenTablero = "";
		for(int i = 0; i < 8 ; i++) {
			for(int ii = 0; ii < 8 ; ii++) {	
				imagenTablero += "["+tablero[i][ii].getNombre() + " " +tablero[i][ii].getColor()+"]";
			}
			imagenTablero += "\n";	
		}	
		System.out.println(imagenTablero);	
	}
	
	

	public void verFichas(Piezas[] x) {
		for(int i = 0 ; i < 16 ; i++) {
			System.out.println(x[i]);
		}
	}
/////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
////////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
////////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
////////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
///METODOS PARA MOVERMER
	
	public void empezarPartida() {
		boolean opcion = true; 
		boolean turnoColor = true;
		boolean turnoNoModificar = false;
		String accion = "";
		do{
			if(turnoColor == true) {
				System.out.println("Turno de blancas");
			}
			else {
				System.out.println("Turno de negras");
				
				
			}
			System.out.println("Opciones: Jugar Ver Salir");
			String buffed = sc.nextLine(); //crear scanner
			accion = sc.nextLine();
			
			switch(accion) {
				case "Jugar": // en caso de elegir esta opcion dos arrays de tipo int 1º casilla y 2º x
					System.out.println("Ingrese las coordenadas y, x de la ficha a mover");
					int[] fichaOrigen = new int[2];
					fichaOrigen[1] = sc.nextInt();
					fichaOrigen[2] = sc.nextInt();	
					
					System.out.println("Ingrese las coordenadas y, x de destino");
					int[] fichaDestino = new int[2];
					fichaOrigen[1] = sc.nextInt();
					fichaOrigen[2] = sc.nextInt();
					
					
					
					if(tablero[fichaOrigen[1]][fichaOrigen[2]].getNombre().equals("Casilla") == false) {
						if() {// Falta comprobacion de que esa ficha que el user quiere mover es mia...... 
							
							
						}
						else {
							
							
							
						}
						
						
					}
					
					else {
						System.out.println("No hay ficha en esa posicion de origen, movimiento irrealizable.");
						turnoNoModificar = true;
					}
					
					
					
					
					
					
					//cambio de turno automatico recordar true es turno de blancas false de negras.
					
					if(turnoColor == true && turnoNoModificar == false) {
						turnoColor = false;
						
						
					}
					
					else if(turnoNoModificar == true) {
						turnoNoModificar = false; 
						
					}
					else if(turnoColor == false && turnoNoModificar == false){
						turnoColor = true;
						
						
					}
					
					break;
					
				case "Ver":
					this.mostrarPosiciones();
					break;
					
				case "Salir":
					System.out.print("Hasta la proxima");
					if(turnoColor == true) {
						System.out.println("Ganan Negras.");
						
					}
					else {
						System.out.println("Ganan Blancas.");
					}
					break;
					
				default:
					System.out.println("Eliga una opcion correcta.");
			
			
			
			
			}
			
			
			
			
			
			
			
		}
		while(opcion == true);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
////////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
////////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
////////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
////////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
////////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
///V/////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
////////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
///V/////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
///V/////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	
	
	
	
	
	
	
	
	//setTablero metodo que inicializa el array de 64 huecos de tipo pieza que usaremos para llevar registro y operar con las piezas
	public void setTablero() {
		
			
		for(int i = 0 ; i < 8; i++) { //for loop para rellenar celdas del array bidimensional, este loop es para rellenar piezas de la primera fila
			switch(i) { //switch para dependiendo de i rellenar en posicion cambiante de x [y][x] con pieza correspondiente
				case 0, 7: //para torre
					tablero[0][i] = new Torre(negras[i].getNombre(), 
							negras[i].getPosiciony(),
							negras[i].getPosicionx(),
							negras[i].getColor());
					break;
				
				case 1, 6: //para alfil
					tablero[0][i] = new Alfil(negras[i].getNombre(), 
							negras[i].getPosiciony(),
							negras[i].getPosicionx(),
							negras[i].getColor());
					break;
				
				case 2, 5: //para caballo
					tablero[0][i] = new Caballo(negras[i].getNombre(), 
							negras[i].getPosiciony(),
							negras[i].getPosicionx(),
							negras[i].getColor());
					break;
				
				case 3, 4: //para rey reyna
					if( i == 3) { //añadimos if else statement ya que rey y reyna son clases distintas....
						tablero[0][i] = new Rey(negras[i].getNombre(), 
								negras[i].getPosiciony(),
								negras[i].getPosicionx(),
								negras[i].getColor());
					}
					else {
						tablero[0][i] = new Reyna(negras[i].getNombre(), 
								negras[i].getPosiciony(),
								negras[i].getPosicionx(),
								negras[i].getColor());
						
						
					}
					break;
			}
				
				
		}	
			
			
		for(int i = 0 ; i < 8; i++) { //loop que inicializa peones negras line y 1 con datos de array de piezas negras todo peones
			tablero[1][i] = new Peon(negras[i + 8].getNombre(), 
					negras[i + 8].getPosiciony(),
					negras[i + 8].getPosicionx(),
					negras[i + 8].getColor());
		}
		
		
		//
		for(int i=2; i < 6 ;i++) { //inicializa espacios vacios con nombre espacio en blanco y la posicion en el eje respectiva
			for(int ii =0; ii < 8;ii++) {
				tablero[i][ii] = new Piezas("Casilla", i, ii, "Null");
			}
		}
		
		
		
		
		//Blancas
		
		for(int i = 0 ; i < 8; i++) { //loop que inicializa peones negras line y 1 con datos de array de piezas negras todo peones
			tablero[6][i] = new Peon(blancas[i + 8].getNombre(), 
					blancas[i + 8].getPosiciony(),
					blancas[i + 8].getPosicionx(),
					blancas[i + 8].getColor());
		}
		
		
		for(int i = 0 ; i < 8; i++) { //for loop para rellenar celdas del array bidimensional, este loop es para rellenar piezas de la primera fila
			switch(i) { //switch para dependiendo de i rellenar en posicion cambiante de x [y][x] con pieza correspondiente
				case 0, 7: //para torre
					tablero[7][i] = new Torre(blancas[i].getNombre(), 
							blancas[i].getPosiciony(),
							blancas[i].getPosicionx(),
							blancas[i].getColor());
					break;
				
				case 1, 6: //para alfil
					tablero[7][i] = new Alfil(blancas[i].getNombre(), 
							blancas[i].getPosiciony(),
							blancas[i].getPosicionx(),
							blancas[i].getColor());
					break;
				
				case 2, 5: //para caballo
					tablero[7][i] = new Caballo(blancas[i].getNombre(), 
							blancas[i].getPosiciony(),
							blancas[i].getPosicionx(),
							blancas[i].getColor());
					break;
				
				case 3, 4: //para rey reyna
					if( i == 3) { //añadimos if else statement ya que rey y reyna son clases distintas....
						tablero[7][i] = new Rey(blancas[i].getNombre(), 
								blancas[i].getPosiciony(),
								blancas[i].getPosicionx(),
								blancas[i].getColor());
					}
					else {
						tablero[7][i] = new Reyna(blancas[i].getNombre(), 
								blancas[i].getPosiciony(),
								blancas[i].getPosicionx(),
								blancas[i].getColor());	
					}
					break;
			}	
		}

	}
		
}

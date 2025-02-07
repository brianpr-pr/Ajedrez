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
			negras[0] = new Torre("Torre", 0, 0,"negra");
			negras[7] = new Torre("Torre", 0, 7,"negra");
			negras[1] = new Caballo("Caballo", 0, 1,"negra");
			negras[6] = new Caballo("Caballo", 0, 6,"negra");
			negras[2] = new Alfil("Alfil", 0, 2,"negra");
			negras[5] = new Alfil("Alfil", 0, 5,"negra");
			negras[3] = new Rey("Rey", 0, 3,"negra");
			negras[4] = new Reyna("Reyna", 0, 4,"negra");
			
			
			for(int index = 8,i = 0 ; i < 8 ; i++, index++) { //loop iterates 8 times creating the 8 peons 
				String nombrePeon = "Peon";
				negras[index] = new Peon(nombrePeon, 1,i, "negra");
			}	
		}
		else{
			
			blancas[0] = new Torre("Torre", 6, 0,"blanca");
			blancas[7] = new Torre("Torre", 6, 7,"blanca");
			blancas[1] = new Caballo("Caballo", 6, 1,"blanca");
			blancas[6] = new Caballo("Caballo", 6, 6,"blanca");
			blancas[2] = new Alfil("Alfil", 6, 2,"blanca");
			blancas[5] = new Alfil("Alfil", 6, 5,"blanca");
			blancas[3] = new Rey("Rey", 6, 3,"blanca");
			blancas[4] = new Reyna("Reyna", 6, 4,"blanca");
			
			for(int index = 8,i = 0 ; i < 8 ; i++, index++) { //loop iterates 8 times creating the 8 peons 
				String nombrePeon = "Peon";
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
		String buffer =" ";
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
			//String buffed = sc.nextLine(); //crear scanner
			accion = sc.nextLine();
			
			switch(accion) {
				case "Jugar": // en caso de elegir esta opcion dos arrays de tipo int 1º casilla y 2º x
					System.out.println("Ingrese las coordenadas del origen; y, x de la ficha a mover");
					int[] fichaOrigen = new int[2];
					fichaOrigen[0] = sc.nextInt();
					fichaOrigen[1] = sc.nextInt();	
					
					if(fichaOrigen[0] >= 0 && fichaOrigen[0] < 8 && fichaOrigen[1] >= 0 &&fichaOrigen[1] < 8) { //if statement que comprube coordenadas de origen dentro de limites
						System.out.println("Ingrese las coordenadas y, x de destino");
						int[] fichaDestino = new int[2];
						fichaDestino[0] = sc.nextInt();
						fichaDestino[1] = sc.nextInt();
						
						
						if (fichaDestino[0] >= 0 && fichaDestino[0] < 8   && fichaDestino[1] >= 0  && fichaDestino[1] < 8) { // if statement que comprueba coordenadas de destino que esten dentro de los limites.
							
							//IMPLEMENTAR METODO PARA COMPROBAR DESTINO Y PARA LLAMAR A METODO ESPECIFICO DE FICHA
							
							if(tablero[fichaOrigen[0]][fichaOrigen[1]].getNombre().equals("Casilla") == false) {
								
								
								
								//en caso de que movimientos se puedan realizar segun la tabla 
								//llamada a metodos para ver si los movimientos se pueden realizar segun la ficha especifica que se quiere mover.
								
								System.out.println("En las coordenadas de origen se encuantra una ficha.");
								
								
								
								
								
								
								
								//FALTA ESTA PARTE:
							////***********************************************************************************************************************************************************************************************
								////***********************************************************************************************************************************************************************************************
							////***********************************************************************************************************************************************************************************************
								if(turnoColor == true && tablero[fichaOrigen[0]][fichaOrigen[1]].getColor().equals("blanca" )  || turnoColor == false && tablero[fichaOrigen[0]][fichaOrigen[1]].getColor().equals("negra") )  { // Comprobacion de que efectivamente el color de la ficha y el del turno coinciden
									
									if(turnoColor == true && tablero[fichaOrigen[0]][fichaOrigen[1]].getColor().equals("blanca" )) {
										System.out.println("Movimiento en turno de blancas de ficha blanca");
									}
									else {
										System.out.println("Movimiento en turno de negras de ficha negra");
										
									}
									if(poderMover(fichaDestino, turnoColor)){//metodo que devuelve si se puede realizar el movimiento desde el punto de vista de la tabla (la casilla de destino existe y esta vacia u la ficha es del tipo contrario...)
										System.out.println("Desde el punto de vista de la tabla si se puede realizar el movimiento.");
										
										
										if(movimiento(fichaOrigen[0] ,fichaOrigen[1], fichaDestino[0], fichaDestino[1], tablero[fichaOrigen[0]][fichaOrigen[1]].getNombre())) { //metodo que es llamado por la pieza que se encuentra en el origen con coordenadas de destino como argumento...
											System.out.println("Movimiento realizado correctamente");
										
										
										
										
										buffer = sc.nextLine();
										
										}
										else {
											System.out.println("Algun error con la ejecucion de la condicion final...");
											turnoNoModificar = true;
											buffer = sc.nextLine();
										}
						
										
									} 
									
									else {
										System.out.println("Movimiento no se puede realizar desde el punto de vista de la tabla.");
										turnoNoModificar = true;
										buffer = sc.nextLine();
										
										
										
									}
									
									
									
									
									
									
									
									
								}
								
								
								
								
							////***********************************************************************************************************************************************************************************************
								///////////
							////***********************************************************************************************************************************************************************************************
							////***********************************************************************************************************************************************************************************************
							////***********************************************************************************************************************************************************************************************
								
								
								
								else { //else statement se ejecuta si la ficha en el origen no coincide con el turno de esa persona if boolean true solo blancas , flase solo negras
									if(turnoColor == true) {
										System.out.println("No se pueden mover fichas negras en el turno de blancas.");
										buffer = sc.nextLine();
										//buffer = sc.nextLine();
										turnoNoModificar = true;
									}
									else {
										System.out.println("No se pueden mover fichas blancas en el turno de negra.");
										buffer = sc.nextLine();
										// buffer = sc.nextLine();
										turnoNoModificar = true;
									}
									
									
									
								}
								
								
							}
							
							else {
								System.out.println("No hay ficha en esa posicion de origen, movimiento irrealizable.");
								buffer = sc.nextLine();
								turnoNoModificar = true;
							}	
							
							
							
							
						}
						
						
						
						else{
							System.out.println("Porfavor ingrese unas coordenadas de destino que se encuentren dentro de los limites de la tabla.");
							buffer = sc.nextLine();
							turnoNoModificar = true;
							
						}
					}
					
					else {
						System.out.println("Porfavor ingrese unas coordenadas de origen que se encuentren dentro de los limites de la tabla.");
						buffer = sc.nextLine();
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
					System.out.println("Hasta la proxima");
					if(turnoColor == true) {
						System.out.println("Ganan Negras.");
						opcion= false;
						
					}
					else {
						System.out.println("Ganan Blancas.");
						opcion= false;
					}
					break;
					
				default:
					System.out.println("Eliga una opcion correcta.");
			
			
			
			
			}
			
			
			
			
			
			
			
		}
		while(opcion == true);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	///metodo que compruba si la casilla de destino then si la casilla vacia true || casilla de pieza enemiga, true, else false movimiento se repite true
	
	
	public boolean poderMover(int[] destino, boolean turno) {
		
		
		if(destino[0] >= 0  && destino[0] < 8 && destino[1] >= 0 && destino[1] < 8) { //casilla de destino esta dentro de los limites del  tablero de ajedrez
			
			if(tablero[destino[0]][destino[1]].getNombre().equals("Casilla" ) == true) { //comprobacion de si es una casilla vacia el destino
				return true;
			}
			
			else if(tablero[destino[0]][destino[1]].getNombre().equals("Casilla" ) == false) { //comprobacion de si es una pieza del mismo tipo
				if(tablero[destino[0]][destino[1]].getColor().equals("blanca" ) && !turno) { //if destino ficha blanca y turno de negra
					return true;
					
				}
				else if (tablero[destino[0]][destino[1]].getColor().equals("negra" ) && turno) { //if destino ficha negra y turno de blanca
					return true;
				}
				
				else {
					
					return false;
				}
			}
		}
		
		return false;
		
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
	
	
	
	//Metododos para realizar los movimientos:
	
	
	public boolean movimiento(int yOrigen, int xOrigen, int yDestino, int xDestino, String nombre){
		boolean resultado = false;
		int yO = yOrigen, xO = xOrigen, yD = yDestino, xD = xDestino;
		
		
		
	
		switch(nombre){
			case "Torre":
				if(movimientoLineal(yOrigen, xOrigen, yDestino, xDestino, nombre)) {
					resultado = true;
				}
				break;
				
			case "Caballo":
				resultado = false;
				break;
				
			case "Alfil":
				if(movimientoDiagonal(yOrigen, xOrigen, yDestino, xDestino, nombre)) {
					resultado = true;
				}
				break;
				
			case "Rey":
				if(movimientoLineal(yOrigen, xOrigen, yDestino, xDestino, nombre) || movimientoDiagonal(yOrigen, xOrigen, yDestino, xDestino, nombre)) {
					resultado = true;
				}
				
				break;
				
			case "Reyna":
				resultado = false;
				break;
				
			case "Peon":
				if(movimientoLineal(yOrigen, xOrigen, yDestino, xDestino, nombre)) {
					resultado = true;
				}
				break;
				
				
			default:
				resultado = false;
				break;
				
		
		}
		
		
		return resultado;
	
	
	
	}
	
	
	
	//metodo para movimiento lineal
	public  boolean movimientoLineal(int yOrigen, int xOrigen, int yDestino, int xDestino, String nombre){
		if(yOrigen != yDestino && xOrigen == xDestino) { // 1º if else statement se comprueba en movimient lineal que solo se modifica eje de x || y
			if(yOrigen > yDestino) { //if statement una vez comprobado que solo se modifica un eje vemos si el eje y es mayor o menor que la coordenada y de destino en caso de origen > destino se compruenba en posicion origen - 1  
				while(yOrigen > yDestino) { // si el nombre de esa coordenada es Casilla en caso de no serlo sabremos que hay una ficha contraria u nuestra, devolveremos false en ese caso
					if(tablero[yOrigen - 1][xOrigen].getNombre().equals("Casilla") == false) {
						return false;
						
						
					}
				yOrigen--; // por cada iteracion se le resta 1 a la coordena de origen hasta que las dos sean iguales en ese caso se devuelve true porque solo se han encontrado espacios en blanco
	
				}
				return true;
				
	
			}
			else { //lo mismo que antes pero el 'algoritmo a la inversa leer aputnes del if statement para ++ info.'
				while(yDestino > yOrigen) {
					if(tablero[yOrigen + 1][xOrigen].getNombre().equals("Casilla") == false) {
						return false;
						
						
					}
				yOrigen++;	
				}
				return true;
				
				
			}
			
			
		}
		
		
		
		
		else if(yOrigen == yDestino && xOrigen != xDestino) { 
			
			if(xOrigen > xDestino) {
				while(xOrigen > xDestino) {
					if(tablero[yOrigen][xOrigen - 1].getNombre().equals("Casilla") == false) {
						return false;
						
						
					}
					xOrigen--; 
				}
				return true;
				
	
			}
			else {
				while(xDestino > xOrigen) {
					if(tablero[yOrigen ][xOrigen + 1].getNombre().equals("Casilla") == false) {
						return false;
					}
					xOrigen++;	
				}
				return true;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean movimientoDiagonal(int yOrigen, int xOrigen, int yDestino, int xDestino, String nombre){
    	int nY = 0, nX = 0;
    	
    	if(yDestino > yOrigen && xDestino > xOrigen) { // abajo derecha
    		nY = yDestino - yOrigen;
    		nX = xDestino - xOrigen;
    		if(nX == nY) {
    			return true;
    			
    		}
    		else {
    			return true;
    			
    			
    		}
    		
    	}
    	
    	else if(yDestino < yOrigen && xDestino < xOrigen) { // arriba izquierda
    		nY =  yOrigen - yDestino;
    		nX = xOrigen - xDestino;
    		if(nX == nY) {
    			return true;
    			
    		}
    		else {
    			return true;
    			
    			
    		}
    	}
    	
		else if(yDestino > yOrigen && xDestino < xOrigen) { // abajo izquierda
			nY = yDestino - yOrigen;
			nX = xOrigen - xDestino;	
			if(nX == nY) {
    			return true;
    			
    		}
    		else {
    			return true;
    			
    			
    		}
		    	}
		    	
		else if(yDestino < yOrigen && xDestino > xOrigen) { // arriba derecha
			nY =  yOrigen - yDestino;
			nX = xDestino - xOrigen;
			if(nX == nY) {
    			return true;
    			
    		}
    		else {
    			return true;
	
    		}
			
		}
    	
		else {
			
			return false;
		}
    	
    	
    	
    	
    	
    	
    }
	
	
	
}
	
	
	//metodo para movimient diagonal
    
	
	//metodo para movimiento en L
//public static boolean movimientoLineal(int yOrigen, int xOrigen, int yDestino, int xDestino, String nombre){}
	
	
	//metodo para mover peon
//public static boolean movimientoLineal(int yOrigen, int xOrigen, int yDestino, int xDestino, String nombre){}
	
	
	//metodo para mover Reyna
//public static boolean movimientoLineal(int yOrigen, int xOrigen, int yDestino, int xDestino, String nombre){}
	
	
	
	
	
	
		


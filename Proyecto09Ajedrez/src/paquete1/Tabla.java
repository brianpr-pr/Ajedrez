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
			
			blancas[0] = new Torre("Torre", 7, 0,"blanca");
			blancas[7] = new Torre("Torre", 7, 7,"blanca");
			blancas[1] = new Caballo("Caballo", 7, 1,"blanca");
			blancas[6] = new Caballo("Caballo", 7, 6,"blanca");
			blancas[2] = new Alfil("Alfil", 7, 2,"blanca");
			blancas[5] = new Alfil("Alfil", 7, 5,"blanca");
			blancas[3] = new Rey("Rey", 7, 3,"blanca");
			blancas[4] = new Reyna("Reyna", 7, 4,"blanca");
			
			for(int index = 8,i = 0 ; i < 8 ; i++, index++) { //loop iterates 8 times creating the 8 peons 
				String nombrePeon = "Peon";
				blancas[index] = new Peon(nombrePeon, 6,i, "blanca");
			}
		}
	}
	
	
	public Piezas[] getNegras() {
		return negras;
	}

	public String getColorInicial(Piezas posyx) { 
		if(posyx.getColor() == "blanca" && posyx.getNombre().equals("Casilla") == false) {
			return "W";
		}
		else if (posyx.getColor() == "negra" && posyx.getNombre().equals("Casilla") == false) {
			return "B";
			
		}
		
		else {
			
			return "E";
			
		}
		
	}

	public Piezas[] getBlancas() {
		return blancas;
	}
	
	
	//Completar array con posiciones de fichas en tablero;
	public void mostrarPosiciones() {
		String imagenTablero = "";
		for(int i = 0; i < 8 ; i++) {
			for(int ii = 0; ii < 8 ; ii++) { //en la linea de texto central se esta recorriendo una de las fila pero vamos a modificar el lengh de la cadena de texto para que todos tenga la misma
				
				
				
				switch(tablero[i][ii].getNombre().length()) { // numero de characteres que tiene un nombre el nombre mas largo tiene 7 entonces todos los otros tendran que tener el mismo numero de characters.
					case 3:
						imagenTablero += "[    ("+tablero[i][ii].getNombre() + ") " +getColorInicial(tablero[i][ii]) +" Y(" +tablero[i][ii].getPosiciony()+") X("+tablero[i][ii].getPosicionx()+ ")]";
						break;
						

					case 4:
						imagenTablero += "[   ("+tablero[i][ii].getNombre() + ") " +getColorInicial(tablero[i][ii]) +" Y(" +tablero[i][ii].getPosiciony()+") X("+tablero[i][ii].getPosicionx()+ ")]";
						break;
					case 5:
						imagenTablero += "[  ("+tablero[i][ii].getNombre() + ") " +getColorInicial(tablero[i][ii]) +" Y(" +tablero[i][ii].getPosiciony()+") X("+tablero[i][ii].getPosicionx()+ ")]";
						break;
					case 6:
						imagenTablero += "[ ("+tablero[i][ii].getNombre() + ") " +getColorInicial(tablero[i][ii]) +" Y(" +tablero[i][ii].getPosiciony()+") X("+tablero[i][ii].getPosicionx()+ ")]";
						break;
					case 7:
						imagenTablero += "[("+tablero[i][ii].getNombre() + ") " +getColorInicial(tablero[i][ii]) +" Y(" +tablero[i][ii].getPosiciony()+") X("+tablero[i][ii].getPosicionx()+ ")]";
						break;
					
				
				
				
				
				
				
				} 
				
				
				//imagenTablero += "["+tablero[i][ii].getNombre() + " " +getColorInicial(tablero[i][ii]) +" Y(" +tablero[i][ii].getPosiciony()+") X("+tablero[i][ii].getPosicionx()+ ")]";
				
				
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
											fichaCambioLugar(tablero[fichaOrigen[0]][fichaOrigen[1]],  fichaDestino);
											//metodo para que cambie el lugar de origen de la ficha que he movido por una casilla con los datos comunes de casilla....
											borradorFichaOrigen(fichaOrigen);
											mostrarPosiciones();
	
										buffer = sc.nextLine();
										
										}
										
										else if(movimientoSoloPeon(fichaOrigen[0] ,fichaOrigen[1], fichaDestino[0], fichaDestino[1], tablero[fichaOrigen[0]][fichaOrigen[1]].getColor() , false, ((Peon) tablero[fichaOrigen[0]][fichaOrigen[1]]).isPrimerMovimiento() ))   { // en caso de comprobacio de posibilidad de movimient pero especificamente con PEON 
											System.out.println("Movimiento de Peon realizado correctamente");
											//faltaria sobreescribir el array tablero con el movimiento y ficha 
											// if else statement que compruena si la ficha que realiza un movimiento es un peon.
												fichaCambioLugarPeon(tablero[fichaOrigen[0]][fichaOrigen[1]],  fichaDestino);
												borradorFichaOrigen(fichaOrigen);
												mostrarPosiciones();	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	//metodo para sobreescribir array en caso de que todas las condiciones se cumplan;
	
	public void fichaCambioLugarPeon(Piezas fichaACambiar, int[] arrayDestino) {
		System.out.println("Empieza metodo fichaCambioLugar pero de Peon");
		tablero[arrayDestino[0]][arrayDestino[1]] = null; //destruimos el objeto guardado en el array
		//Ahora nos disponemos ah comprbar cual es la clase de la pieza
		// ****************************************************************************************************String colorPeon = fichaACambiar.getColor();
		//como ya sabemos que es un peon no hace falta hacer el switch case que se realiza en fichaCambioLugar 
		//Llamamos directamente al metodo movimientoPeon que realizara el movimiento...
		tablero[arrayDestino[0]][arrayDestino[1]] = new Peon(fichaACambiar.getNombre() , arrayDestino[0], arrayDestino[1],fichaACambiar.getColor() );
		System.out.println("Ahora ya habria creado el nuevo peon pero todavia no esta cambiando lo del primer movimiento");
		//set PrimerMovimiento atributo de peon a false.
		if(tablero[arrayDestino[0]][arrayDestino[1]] instanceof Peon) {
			Peon p = (Peon) tablero[arrayDestino[0]][arrayDestino[1]];
			p.setPrimerMovimiento();
			System.out.println("Es el primer movimiento de este Peon?? False significa que no " + p.isPrimerMovimiento()); // debuggin ver que se accede al objeto atravez de ref de sub clase a objeto de subclase qur forma parte de array de superclse....
		}
		
		 
		
	}
	
	
	
	
	
	
	
	public void fichaCambioLugar(Piezas fichaACambiar, int[] arrayDestino) {
		System.out.println("Empieza metodo fichaCambioLugar");
		tablero[arrayDestino[0]][arrayDestino[1]] = null; //destruimos el objeto guardado en el array
		//Ahora nos disponemos ah comprbar cual es la clase de la pieza
		String claseCreator = fichaACambiar.getNombre();
		
		switch(claseCreator) {
		
			case "Torre":
				tablero[arrayDestino[0]][arrayDestino[1]] = new Torre(fichaACambiar.getNombre() , arrayDestino[0], arrayDestino[1],fichaACambiar.getColor() );
				System.out.println("Torre");
				//una vez que hemos sobreescrito el array el metodo acaba y de vuelta al metodo 'empezarPartida': 
				break;
				
			case "Caballo":
				tablero[arrayDestino[0]][arrayDestino[1]] = new Caballo(fichaACambiar.getNombre() , arrayDestino[0], arrayDestino[1],fichaACambiar.getColor() );
				System.out.println("Caballo");
				break;
				
			case "Alfil":
				tablero[arrayDestino[0]][arrayDestino[1]] = new Alfil(fichaACambiar.getNombre() , arrayDestino[0], arrayDestino[1],fichaACambiar.getColor() );
				System.out.println("Alfil");
				break;
			case "Rey":
				tablero[arrayDestino[0]][arrayDestino[1]] = new Rey(fichaACambiar.getNombre() , arrayDestino[0], arrayDestino[1],fichaACambiar.getColor() );
				System.out.println("Rey");
				break;
			case "Reyna":
				tablero[arrayDestino[0]][arrayDestino[1]] = new Reyna(fichaACambiar.getNombre() , arrayDestino[0], arrayDestino[1],fichaACambiar.getColor() );
				System.out.println("Reyna");
				break;
				/*
			case "Peon":
				tablero[arrayDestino[0]][arrayDestino[1]] = new Peon(fichaACambiar.getNombre() , arrayDestino[0], arrayDestino[1],fichaACambiar.getColor() );
				System.out.println("Peon");
				break;
				
				*/
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	public void borradorFichaOrigen(int[] arraOrigen){
		int yOrigen = arraOrigen[0], xOrigen = arraOrigen[1];
		
		tablero[arraOrigen[0]][arraOrigen[1]] = null;
		tablero[arraOrigen[0]][arraOrigen[1]] = new Piezas("Casilla", yOrigen, xOrigen, "Null");
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
																												//Este boolean sera true en caso de que en posicione diagonal de peon blanco ej, fila -1 columna -1 || columna +1 se mueva.... Para matar.
	public boolean movimiento(int yOrigen, int xOrigen, int yDestino, int xDestino, String nombre){ //Implementacion de atributo color para realizar movimientos con peones
		boolean resultado = false;
		int yO = yOrigen, xO = xOrigen, yD = yDestino, xD = xDestino;
		
		
		
	
		switch(nombre){
			case "Torre":
				return true;
				/*
				 
				if(movimientoLineal(yOrigen, xOrigen, yDestino, xDestino)) {
					resultado = true;
				}
				*/
				//break;
				
			case "Caballo":
				if(movimientoEnL(yOrigen, xOrigen, yDestino, xDestino)) {
					resultado = true;
				}
				break;
				
			case "Alfil":
				if(movimientoDiagonal(yOrigen, xOrigen, yDestino, xDestino)) {
					resultado = true;
				}
				break;
				
			case "Rey":
				if(movimientoLineal(yOrigen, xOrigen, yDestino, xDestino) || movimientoDiagonal(yOrigen, xOrigen, yDestino, xDestino)) {
					resultado = true;
				}
				
				break;
				
			case "Reyna":
				if(movimientoReyna(yOrigen, xOrigen, yDestino, xDestino)) {
					resultado = true;
				}
				break;
				/*
			case "Peon":
				if(movimientoLineal(yOrigen, xOrigen, yDestino, xDestino)) {
					resultado = true;
				}
				break;
				*/
				
			default:
				resultado = false;
				break;
				
		
		}
		
		
		return resultado;
	
	
	
	}
	
	
	
	
	
	
	
	
	//metodo para movimiento lineal
	public  boolean movimientoLineal(int yOrigen, int xOrigen, int yDestino, int xDestino){
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
	
	public static boolean movimientoDiagonal(int yOrigen, int xOrigen, int yDestino, int xDestino){
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
	
	
	

	
	
    
	
	//metodo para movimiento en L
	public boolean movimientoEnL(int yOrigen, int xOrigen, int yDestino, int xDestino){ // para movimient de pieza caballo
		 int yO = yOrigen, yD = yDestino, xO = xOrigen , xD = xDestino; //solo pude moverse en una diferencia de +- 2 y +-1 x || +-1 y +-2x
		 int yR = 0, xR = 0;
		 
		 
		 if(yO > yD) {
			 yR = yO - yD;
			 
		 }
		 else {
			 yR = yD - yO;
		 }
		 
		 
		 if(xO > xD) {
			 xR = xO - xD;
		 }
		 else {
			xR = xD - xO;
			 
		 }
		
		 
		 if(yR == 2 && xR == 1 || xR == 2 && yR == 1) {
			 
			 return true;
			 
		 }

		return false;

	}
	
	


//Faltan los metodos de peon y reyna
//pensar como implementar el metodo de peon....
	//metodo para mover peon
//public static boolean movimientoLineal(int yOrigen, int xOrigen, int yDestino, int xDestino, String nombre){}
	
	
	//metodo para mover Reyna
  public static boolean movimientoReyna(int yOrigen, int xOrigen, int yDestino, int xDestino){
	  int yR = 0 , xR = 0, yO = yOrigen, yD = yDestino, xO = xOrigen, xD = xDestino;
	  
	  if(yO > yD) {
			 yR = yO - yD;
			 
		 }
		 else {
			 yR = yD - yO;
		 }
		 
		 
		 if(xO > xD) {
			 xR = xO - xD;
		 }
		 else {
			xR = xD - xO;
			 
		 }
		 
		 
		 if(xR <=1  && yR <= 1) {
			 return true; 
			 
		 }
		 
	  
	  
	  
	  return false;
  }
	
	
	
	
	
	//sobrecarga de metodo movimiento este es ejcutado solo desde un var ref a Peon 
  public static boolean movimientoSoloPeon(int yOrigen, int xOrigen, int yDestino, int xDestino, String color, boolean matarPeones, boolean primerMovimiento){
	  
	  int yO = yOrigen, yD = yDestino, xO = xOrigen, xD = xDestino;
	  int yR = 0, xR = 0;
	  
	  //yR xR guardan el resultado del movimiento 
	  
	  
	  yR = yD - yO;
	  xR = xD - xO;

	  
	  
	  
	  
	  if (matarPeones && xR == 1 || xR == -1) { // si mata peones comprbamos que se mueva 1 posicion en el eje de x
		  //comprbamos si es negra o blanca para ver si es 1 en el eje de y positivo o negativo
		  if(color.equals("blanca") && yR == -1) {
			  return true;    
		  }
		  
		  else if(color.equals("negra") && yR == 1) {
			  return true;
			    
		  }
  
	  }
	  
	  else 
	  
	  if(!matarPeones && xR == 0){
		  if(color.equals("blanca")) {
			  
			  if(primerMovimiento && yR == -1  || primerMovimiento && yR ==-2  || !primerMovimiento && yR == -1) {
				  return true;
			  }
			  
		  }
		  
		  else if(color.equals("negra")) {
			  if(primerMovimiento && yR == 1  || primerMovimiento && yR ==2  || !primerMovimiento && yR == 1) {
				  return true;
			  } 
		  }
  
	  } 
	  return false;  
  }
  
  
  
  
  
}		


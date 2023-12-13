package hundir.la.flota;

import java.util.Random;

public class Flota {
	// tamaño del tablero (podría modificarse)
	public static final int TAM_TABLERO = 10;

	String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// coordenada x de un barco
	static int xBarco;

	// coordenada y de un barco
	static int yBarco;

	// coordenada x del barco hundido en el turno anterior
	// se inicializa a 0 para que no salga en el tablero
	static int xBarcoHundido = 0;

	// coordenada y del barco hundido en el turno anterior
	// se inicializa a 0 para que no salga en el tablero
	static int yBarcoHundido = 0;

	// este atributo guardara la coordenada x del ultimo misil lanzado
	// se inicializa a 0 para que no salga en el tablero
	static int xUltimoMisil = 0;
	// este atributo guardara la coordenada x del ultimo misil lanzado
	// se inicializa a 0 para que no salga en el tablero
	static int yUltimoMisil = 0;

	// Entrada: Vacio
	// Salida: Vacio
	// Funcionalidad: genera unas coordenadas aleatorias en el tablero para un barco
	// teniendo en cuenta que no deben de ser las mismas que las del barco del turno
	// anterior
	static void generaCoordenadas() {
		// Creamos el objeto random para que nos ayude a generar las coordenadas de
		// forma aleatoria
		Random rand = new Random();
		xBarco = rand.nextInt(1, TAM_TABLERO + 1);
		yBarco = rand.nextInt(1, TAM_TABLERO + 1);

		while (xBarco == xBarcoHundido && yBarco == yBarcoHundido) {
			xBarco = rand.nextInt(1, TAM_TABLERO + 1);
			yBarco = rand.nextInt(1, TAM_TABLERO + 1);
		}
	}

	// Entrada: Vacio
	// Salida: Vacio
	// Funcionalidad: comprueba que en las coordenadas dadas haya un barco o no y si
	// esas coordenadas estan dentro del tablero
	int lanzarMisil(int x, int y) {
		int res = 0;
		// caso en el que las coordenadas se salen del tablero
		if (x < 1 || x > TAM_TABLERO || y < 1 || y > TAM_TABLERO) {
			res = -2;
			// caso en el que no acierta el usuario
		} else {
			if (x != xBarco || y != yBarco) {
				res = -1;
				// en caso de no acertar guardamos las coordenadas del misil
				xUltimoMisil = x;
				yUltimoMisil = y;
			}else {
				xBarcoHundido = xBarco;
				yBarcoHundido = yBarco;
			}
		}
		return res;
	}

	// Entrada: vacio
	// Salida: vacio
	// Funcionalidad: imprime el tablero junto al ultimo misil y ultimo barco
	// hundido
	void pintaTablero() {
		// se guarda la coordenada y más grande entre el ultimo misil lanzado y el ultimo barco hundido para cuando coincidan en la misma linea poder imprimir los dos
		int mayor;
		
		// Imprimimos el eje de coordenadas X
		for (int i = 1; i <= TAM_TABLERO; i++) {
			System.out.print("\t" + i);
		}
		// agregamos un salto de linea para que no se nos junten los ejes
		System.out.println();

		// mostramos el eje X de coordenadas con letras
		for (int i = 1; i <= TAM_TABLERO; i++) {
			System.out.print(alfabeto.charAt(i - 1));
			// comprobamos si el ultimo misil y el ultimo barco hundido estan en la misma fila
			// cogemos el maximo de las dos coordenadas Y e iteramos hacia el mayor comprobando  en cada caso si hay que imprimir algo
			// en caso de tener que imprimir la M o la H se le agregara tambien un tabulado porque si no, estaran juntas
			if(xUltimoMisil == i && xBarcoHundido == i) {
				// cogemos el maximo de los dos
				mayor = yUltimoMisil > yBarcoHundido ? yUltimoMisil : yBarcoHundido;
				// iteramos de 1 a la mayor de las dos coordenadas y
				for(int j = 1; j <= mayor; j++) {
					// estos dos primeros casos son para que al haber dos en la misma linea el mayor no se desplace
					if(j == yUltimoMisil && j == mayor) {
						System.out.print('M' + "\t");
					}else if(j == yBarcoHundido && j == mayor) {
						System.out.print('H' + "\t");
					}
					else if(j == yUltimoMisil) {
						System.out.print("\t" + 'M' + "\t");
					}else if(j == yBarcoHundido) {
						System.out.print("\t" + 'H' + "\t");
					}else {
						System.out.print("\t");
					}
				}
			// imprimimos tabuladores hasta la coordenada y del ultimo misil y luego ponemos
			// una M en su posicion
			}else if (xUltimoMisil == i) {
				for (int j = 1; j <= yUltimoMisil; j++) {
					System.out.print("\t");
				}
				System.out.print('M');
				// imprimimos tabuladores hasta la coordenada y del barco hundido y luego
				// ponemos una H en su posicion
			} else if (xBarcoHundido == i) {
				for (int j = 1; j <= yBarcoHundido; j++) {
					System.out.print("\t");
				}
				System.out.print('H');
			}
			// ponemos un salto de linea para que no se junte todo en la misma
			System.out.println();
		}
	}

}

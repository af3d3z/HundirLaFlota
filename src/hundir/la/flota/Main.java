package hundir.la.flota;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// almacena el numero de rondas a jugar
		int nRondas = 0;
		// almacena la coordenada x del misil a lanzar
		int xMisil = 0;
		// almacena la coordenada y del misil a lanzar
		int yMisil = 0;
		
		// almacena el resultado de lanzar un misil a unas coordenadas en especifico
		int resMisil = 1;
		
		// guarda las coordenadas introducidas por el usuario
		String misil = ""; 
		
		// crea un objeto que nos ayuda a recoger input del jugador
		Scanner sc = new Scanner(System.in);
		
		// generamos las coordenadas del barco
		Flota.generaCoordenadas();
		
		// creamos el objeto flota
		Flota flota = new Flota();
		
		try {
			System.out.println("/***HUNDIR LA FLOTA***\\");
			System.out.println("Introduzca el numero de rondas que quiere jugar: ");
			nRondas = sc.nextInt();
		}catch(InputMismatchException e) {
			System.err.println("Dato incorrecto.");
		}
		
		for(int i = 1; i <= nRondas; i++) {
			while(resMisil != 0) {
				flota.pintaTablero();
				System.out.println("Introduce un cuadrante: (LetraNumero Ej: A1)");
				misil = sc.next();
				xMisil = misil.toUpperCase().charAt(0) - 64;
				yMisil = Integer.parseInt(misil.substring(1));
				
				resMisil = flota.lanzarMisil(xMisil, yMisil);
			}
			Flota.generaCoordenadas();
			System.out.printf("Barco derribado en coordenadas %s\n", misil.toUpperCase());
			resMisil = 1;
		}
		
		System.out.println("Enhorabuena, has ganado el juego. :3");
		sc.close();
	}
}

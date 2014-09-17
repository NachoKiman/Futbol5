package negocio;

import java.util.Scanner;

public class Handicap implements Criterio{
	
	public double puntuar(Miembro miembro)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Puntuar a "+miembro.getApellido()+", "+miembro.getNombre()+"(del 1 al 10): ");
		double puntuacion = scanner.nextInt();
		
		return puntuacion;
	}

}

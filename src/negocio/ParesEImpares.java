package negocio;

import java.util.ArrayList;

public class ParesEImpares implements AlgortimoEquipo {
	
	public ArrayList<Aspirante> generarEquipo1(ArrayList<Aspirante> jugadores) {
		ArrayList<Aspirante> equipo = new ArrayList<Aspirante>();
		for(int i=1; i<=5; i++)
		{
			equipo.add(jugadores.get((i*2)-1));
		}
		return equipo;
	}
	
	public ArrayList<Aspirante> generarEquipo2(ArrayList<Aspirante> jugadores) {
		
		ArrayList<Aspirante> equipo = new ArrayList<Aspirante>();
		for(int i=1; i<=10; i++)
		{
			if((i%2)!=0)
			{
				equipo.add(jugadores.get(i-1));
			}
		}
		return equipo;
	}
}

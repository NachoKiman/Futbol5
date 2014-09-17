package negocio;

import java.util.ArrayList;

public class SegundoAlgoritmo implements AlgortimoEquipo {

	
	public ArrayList<Aspirante> generarEquipo1(ArrayList<Aspirante> jugadores) {
		ArrayList<Aspirante> equipo = new ArrayList<Aspirante>();
		equipo.add(jugadores.get(1));
		equipo.add(jugadores.get(4));
		equipo.add(jugadores.get(5));
		equipo.add(jugadores.get(8));
		equipo.add(jugadores.get(9));
		return equipo;
	}
	
	
	public ArrayList<Aspirante> generarEquipo2(ArrayList<Aspirante> jugadores) {
		ArrayList<Aspirante> equipo = new ArrayList<Aspirante>();
		equipo.add(jugadores.get(2));
		equipo.add(jugadores.get(3));
		equipo.add(jugadores.get(6));
		equipo.add(jugadores.get(7));
		equipo.add(jugadores.get(10));
		return equipo;
	}
}

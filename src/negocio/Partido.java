package negocio;
import java.util.*;



public class Partido {
	private static ArrayList<Aspirante> jugadores;
	private String lugar;
	private Date fecha;
	private CondicionPartido condicion;
	private static ArrayList<Aspirante> equipo1;
	private static ArrayList<Aspirante> equipo2;
	private Miembro administrador;
	
	
	public Partido(String l, Date f, CondicionPartido c, Miembro admin)
	{
		jugadores = new ArrayList<Aspirante>();
		lugar = l;
		fecha = f;
		condicion = c;
		administrador = admin;
	}
	
	public void inscribirJugador(Aspirante aspirante)
	{
		
		
		if(jugadores.size() !=0)
		{
			boolean fin= false;
			int i=0;
			while((!fin)&&(!aspirante.tieneMasPrioridad(jugadores.get(i))))
			{
				if(i+1==jugadores.size())
				{
					fin=true;
				}
				i++;
			}
			//corre todos para abajo
			jugadores.add(i,aspirante);
			if(jugadores.size() == 10)
			{
				//envia un mail al administrador
				Mock mockObject = new Mock();
				mockObject.enviarMail(administrador);
			}
			
		}	
		else
		{
			jugadores.add(aspirante);
		}
	}
	
	//Devuelve true en caso que el el nuevo aspirante tenga 
	//mas prioridad que el ultimo de la lista de jugadores
	public boolean permiteInscribir(Aspirante aspirante)
	{
		if(jugadores.size()==10)
		{
			if((aspirante.tieneMasPrioridad(jugadores.get(9)))
				&&(condicion.cumplidaPor(aspirante)))
			{
				jugadores.remove(9);
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
	public void reemplazoJugadores(Miembro reemplazado, Miembro reemplazante)
	{
		int i=jugadores.indexOf(reemplazado);
		
		
		jugadores.get(i).setMiembro(reemplazante);
		
	}
	
	public void ordenarJugadores(Criterio criterio)
	{
		calificarJugadores(criterio);
		//especifica que la comparacion debe hacerse por calificacion y luego
		// por fecha de inscripcion
		Comparator<Aspirante> comparator = new Comparator<Aspirante>() {
		    public int compare( Aspirante a, Aspirante b ) {

		        int resultado = Double.compare(a.getCalificacion(), b.getCalificacion());
		        if (resultado !=0){return resultado;}
		        
		        resultado = a.getFechaInscripcion().compareTo(b.getFechaInscripcion());

		        return resultado;

		    }
		};
		
		Collections.sort(jugadores, comparator);
		
	}
	
	public static void calificarJugadores(Criterio criterio)
	{
		for(int i=0; i<10; i++)
		{
			Aspirante jugador = jugadores.get(i);
			Miembro miembro = jugador.getMiembro();
			jugador.setCalificacion(criterio.puntuar(miembro));
		}
	}
	
	public void organizarEquipos(AlgortimoEquipo algoritmo)
	{
		equipo1 = algoritmo.generarEquipo1(jugadores);
		equipo2 = algoritmo.generarEquipo2(jugadores);
	}
	
	public void mostrarEquipos()
	{
		System.out.println("Equipo 1:");
		mostrar(equipo1);
		System.out.println("Equipo 2:");
		mostrar(equipo2);
	}
	
	public void mostrar(ArrayList<Aspirante> equipo)
	{
		for(int i=0; i<5; i++)
		{
			Miembro miembro = equipo.get(i).getMiembro();
			System.out.println(miembro.getApellido()+
						  ", "+miembro.getNombre());
			
		}
	}
	
	public Miembro getAdministrador() {
		return administrador;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public ArrayList<Aspirante> getJugadores()
	{
		return jugadores;
	}

	
	
	
	
	
}

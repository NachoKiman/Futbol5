package usuario;
import java.util.*;

import negocio.*;


public class Sistema 
{
	private static Partido partido;
	private static ArrayList<Miembro> miembros;
	private static ArrayList<Denegacion> denegaciones;
	private static Miembro nuevoMiembro;
	private static boolean partidoBloqueado;
	private static ArrayList<Criterio> criterios;
	private static ArrayList<AlgortimoEquipo> algoritmos;
	
	
	//No se usa en este contexto
        
	/*public static void main(String arg[])
	{
		inicializarCriterios();
		inicializarAlgoritmos();
		cargarMiembros();
		denegaciones = new ArrayList<Denegacion>();
		boolean fin = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido al Sistema de Partidos");
		while (!fin)
		{
			
			System.out.println("Seleccione una opci�n: ");
			System.out.println("1) Organizar Partido");
			if(!partidoBloqueado)
			{
				System.out.println("2) Inscribirse al partido");
				System.out.println("3) Darse de baja del partido");
				System.out.println("4) Incorporar nuevo jugador");
				System.out.println("5) Administrar nuevo jugador");
				System.out.println("6) Generar equipos tentativos");
			}
			
			System.out.println("7) Calificar jugadores");
			System.out.println("8) Cerrar programa");
			
			int opcion = scanner.nextInt();
			
			switch(opcion)
			{
				case 1:
					organizarPartido();
					break;
				case 2:
					inscribirJugador();
					break;
				case 3:
					darseBaja();
					break;
				case 4:
					incorporarNuevoJugador();
					break;
				case 5:
					administrarNuevoJugador();
					break;
				case 6:
					calificarJugadores();
					break;
				case 7:
					generarEquiposTentativos();
				case 8:
					fin = true;
					break;
				default:
					System.out.println("Opcion no valida");
					break;
			}
			
		}
		System.out.println("Gracias por usar nuestro programa!");
		
	
		
	}
        */
	
	//Pide los datos del partido y lo instancia
	private static void organizarPartido()
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese su id_miembro:");
		int idAdmin = scanner.nextInt();
		System.out.println("Ingrese el lugar:");
		String lugar = scanner.next();
		System.out.println("Ingrese la Fecha y hora");
		System.out.println("Ingrese el a�o:");
		int year = scanner.nextInt();
		System.out.println("Ingrese el mes:");
		int month = scanner.nextInt();
		System.out.println("Ingrese el dia:");
		int date = scanner.nextInt();
		System.out.println("Ingrese la hora(sin minutos):");
		int hrs = scanner.nextInt();
		System.out.println("Ingrese los minutos:");
		int min = scanner.nextInt();
		
		Miembro admin = buscarMiembro(idAdmin);
		
		Date fecha = new Date(year, month, date, hrs, min);

		CondicionPartido condicion = new SinCondicion();

		partido = new Partido(lugar, fecha, condicion, admin);
		System.out.println("Partido creado correctamente");
		partidoBloqueado = false;
	}
	
	//Pide numero de miembro y tipo de inscripcion e inscribe al jugador
	private static void inscribirJugador()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese su numero de miembro:");
		int idMiembro  = scanner.nextInt();
		
		Miembro miembro = buscarMiembro(idMiembro);

		System.out.println("De que forma quiere inscribirse?");
		System.out.println("1) Estandar");
		System.out.println("2) Solidario");
		System.out.println("3) Condicional");
		int opcion= scanner.nextInt();
		
		FormaInscripcion insc = seleccionFormaInscripcion(opcion);
		
		Date fechaIncripcion = new Date();
		
		Aspirante aspirante = new Aspirante(miembro,insc, fechaIncripcion);
		
		if(partido.permiteInscribir(aspirante))
		{
			partido.inscribirJugador(aspirante);
			System.out.println("Jugador Inscripto correctamente");
			miembro.notificarInscripcion();
		}
		else
		{
			System.out.println("No pudo inscribirse al partido");
		}

	}
	
	//Pide el numero del reemplazante, si no se da, se penaliza, sino lo incribe
	//En ambos casos da de baja al jugador que lo solicita-
	private static void darseBaja()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese su numero de miembro:");
		int idMiembroViejo  = scanner.nextInt();
		
		Miembro miembroViejo = buscarMiembro(idMiembroViejo);
		
		
		System.out.println("Ingrese el numero de miembro del reemplazante(o -1 para terminar):");
		int idMiembroNuevo  = scanner.nextInt();
		
		if(idMiembroNuevo != -1)
		{
			
			Miembro miembroNuevo = buscarMiembro(idMiembroNuevo);
			partido.reemplazoJugadores(miembroViejo, miembroNuevo);
			System.out.println("Reemplazo realizado satisfactoriamente");
			
		}
		else
		{
			Infraccion infraccion = new SinReemplazante();
			miembroViejo.getInfracciones().add(infraccion);
			System.out.println("Se lo ha sancionado");
			Mock mockObject = new Mock();
			mockObject.enviarMail(partido.getAdministrador());
		}
		
		
		
	}
	
	//Dado un idMiembro, se busca al miembro en la coleccion Miembros
	private static Miembro buscarMiembro(int idMiembro)
	{

		return miembros.get(idMiembro-1);
	}
	
	//Inicializa los cirterios existentes hasta el momento
	private static void inicializarCriterios()
	{
		criterios = new ArrayList<Criterio>();
		criterios.add(new Handicap());
		criterios.add(new PromedioUltimoPartido());
		criterios.add(new PromedioNPartidos());
		criterios.add(new Mix());
	}
	
	//Inicializa los algoritmos de eleccion de equipos
	//existentes hasta el momento
	private static void inicializarAlgoritmos()
	{
		algoritmos = new ArrayList<AlgortimoEquipo>();
		algoritmos.add(new ParesEImpares());
		algoritmos.add(new SegundoAlgoritmo());
		
	}
	
	//metodo utilitario para pruebas
	private static void cargarMiembros()
	{
		miembros = new ArrayList<Miembro>();
		
		Miembro miembro1 = new Miembro(1, "Juan", "Perez" , 15);
		Miembro miembro2 = new Miembro(2, "Pedro", "Quintana" , 20);
		Miembro miembro3 = new Miembro(3, "Damian", "Quinteros" , 27);
		Miembro miembro4 = new Miembro(4, "Santiago", "Fernandez" , 15);
		Miembro miembro5 = new Miembro(5, "Alberto", "Ramirez" , 18);
		Miembro miembro6 = new Miembro(6, "Leonardo", "Ortega" , 17);
		Miembro miembro7 = new Miembro(7, "Hernan", "Comar" , 18);
		Miembro miembro8 = new Miembro(8, "Facundo", "Saavedra" , 19);
		Miembro miembro9 = new Miembro(9, "Juan Pablo", "Quiroga" , 25);
		Miembro miembro10 = new Miembro(10, "Lautaro", "Reynoso" , 26);
		Miembro miembro11 = new Miembro(11, "Martin", "Piedrabuena" , 14);
		Miembro miembro12 = new Miembro(12, "Esteban", "Ala Triste" , 16);
		Miembro miembro13 = new Miembro(13, "Raul", "Pontmercy" , 18);
		Miembro miembro14 = new Miembro(14, "Victor", "Valjean" , 19);
		Miembro miembro15 = new Miembro(15, "Ignacio", "Kiman" , 16);
		Miembro miembro16 = new Miembro(16, "Juan Ignacio", "Jarvet" , 18);
		Miembro miembro17 = new Miembro(17, "Juan Patricio", "Dominguez" , 25);
		Miembro miembro18 = new Miembro(18, "Patricio", "Ventura" , 28);
		Miembro miembro19 = new Miembro(19, "Joaquin", "Burocco" , 24);
		Miembro miembro20 = new Miembro(20, "Nicolas", "Cardozo" , 20);
		Miembro miembro21 = new Miembro(21, "Fernando", "Novoa" , 15);
		Miembro miembro22 = new Miembro(22, "Juan Manuel", "Iba�ez" , 22);
		Miembro miembro23 = new Miembro(23, "Juan Martin", "Bugarin" , 24);
		Miembro miembro24 = new Miembro(24, "Constantino", "Pereyra" , 19);
		Miembro miembro25 = new Miembro(25, "Augusto", "Ledesma" , 15);
		
		
		miembros.add(miembro1);
		miembros.add(miembro2);
		miembros.add(miembro3);
		miembros.add(miembro4);
		miembros.add(miembro5);
		miembros.add(miembro6);
		miembros.add(miembro7);
		miembros.add(miembro8);
		miembros.add(miembro9);
		miembros.add(miembro10);
		miembros.add(miembro11);
		miembros.add(miembro12);
		miembros.add(miembro13);
		miembros.add(miembro14);
		miembros.add(miembro15);
		miembros.add(miembro16);
		miembros.add(miembro17);
		miembros.add(miembro18);
		miembros.add(miembro19);
		miembros.add(miembro20);
		miembros.add(miembro21);
		miembros.add(miembro22);
		miembros.add(miembro23);
		miembros.add(miembro24);
		miembros.add(miembro25);
		
	}
	
	//Instancia la forma de inscripcion dependiendo de la opcion elegida
	public static FormaInscripcion seleccionFormaInscripcion(int opcion)
	{
		switch(opcion)
		{
			case 1:
				return new Estandar();
				
			case 2:
				return new Solidario();
				
			case 3:
				return new Condicional(); 
				
			default:
				System.out.println("Opcion no valida");
				break;
		}
		//me obliga a hacer esto porque sino dice que puede llegar
		//a no tener valor
		return new Estandar();
	}

	//Se pide los datos del Nuevo jugador y se deja en espera
	//hasta que el administrador lo revise
	public static void incorporarNuevoJugador()
	{
		Scanner scanner = new Scanner(System.in);
		int id = ultimoId() +1;
		System.out.println("Ingrese el nuevo nombre:");
		String nombre = scanner.next();
		System.out.println("Ingrese el nuevo apellido:");
		String apellido = scanner.next();
		System.out.println("Ingrese la nuevo edad:");
		int edad = scanner.nextInt();
		nuevoMiembro = new Miembro(id, nombre, apellido, edad);
	}
	
	//El administrador decide si admite o no al nuevo jugador
	public static void administrarNuevoJugador()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Este nuevo jugador quiere inscribirse");
		System.out.println(nuevoMiembro);
		System.out.println("Lo aprueba?(1 para Si, 2 para No)");
		int respuesta = scanner.nextInt();
		
		switch(respuesta)
		{
			case 1:
				agregarMiembro();
				inscribirJugador();
				break;
			case 2:
				completarRazonNegacion();
				break;
			default:
				break;
		}
	}
	
	//El administrador aclara las razones por las cuales rechazo
	// la inscripcion del jugador
	public static void completarRazonNegacion()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese la razon de negacion de solicitud: ");
		String razon = scanner.next();
		Date fecha = new Date();
		denegaciones.add(new Denegacion(razon, fecha));
	}
	
	//Agrega un miembro y muestra un mensaje
	public static void agregarMiembro()
	{
		miembros.add(nuevoMiembro);
		System.out.println("Se ha inscripto correctamente");
		System.out.println("Su nuevo id es: "+nuevoMiembro.getIdMiembro());

	}
	
	
	//Devuelve el ultimo idMiembro de la lista de miembros
	public static int ultimoId()
	{
		return (miembros.get(miembros.size())).getIdMiembro();
	}
		
	//Presentando su idMiembro, un miembro(si jug� el partido)
	//puede puntuar y escribir una critica sobre los otros jugadores
	public static void calificarJugadores()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese su id_Miembro:");
		int id = scanner.nextInt();
		Miembro miembro = buscarMiembro(id);

		ArrayList<Aspirante> jugadores = partido.getJugadores();
		
		//Chequea que el miembro haya jugado el partido
		if(!jugadores.contains(miembro))
		{
			System.out.println("Usted no jug� el partido");
			return;
		}
		//Recorre la lista de jugadores y la califica.
		for(int i=0; i<10; i++)
		{
			Miembro miembroACalificar = jugadores.get(i).getMiembro();
			if(miembroACalificar.getIdMiembro() != id)
			{
				miembro.calificar(miembroACalificar, partido.getFecha());
			}
		}
	}

	//Ingresando los parametros para generar los equipos, muestra
	// la opcion de equipos. Si al administrador no le gustan los
	// equipos formados vuelve a hacer el proceso
	public static void generarEquiposTentativos()

	{
		boolean fin = false;
		while(!fin)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Eliga un criterio de ordenamiento:");
			System.out.println("1) Handicap");
			System.out.println("2) Calificaciones del ultimo partido");
			System.out.println("3) Calificaciones de los ultimos n partidos");
			System.out.println("4) Mix");
			int opcion = scanner.nextInt();
			
			Criterio criterio = criterios.get(opcion-1);
			
			
			if(opcion==3)
			{
				System.out.println("Ingrese n:");
				int n = scanner.nextInt();
				((PromedioNPartidos)criterio).setN(n);
				
			}
			if(opcion == 4)
			{
				System.out.println("Ingrese n:");
				int n = scanner.nextInt();
				((Mix)criterio).setN(n);
				((Mix)criterio).setCriterios(criterios);
			}
					
			partido.ordenarJugadores(criterio);
			System.out.println("Eliga algoritmo de aramdo de quipos:");
			System.out.println("1) Pares e impares");
			System.out.println("2) 1�,4�,5�,8� y 9� vs 2�,3�,6�,7� y 10�");
			int i = scanner.nextInt();
			AlgortimoEquipo algoritmo = algoritmos.get(i);
			
			partido.organizarEquipos(algoritmo);
			partido.mostrarEquipos();
			
			System.out.println("Confirma estos 2 equipos?(1 Si, 2 No)");
			opcion = scanner.nextInt();
			if(opcion==1)
			{
				fin =true;
			}
		}
		
		confirmarEquipos();
		
		
	}
	
	//Bloquea todas los menues que tratan sobre cambios en el partido
	public static void confirmarEquipos()
	{
		partidoBloqueado = true;
	}
}

	
	


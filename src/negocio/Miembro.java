package negocio;

import java.util.*;

public class Miembro {
	private int idMiembro;
	private String nombre;
	private String apellido;
	private int edad;
	private Date fechaNacimiento;
	private ArrayList<Miembro> amigos;
	private ArrayList<Infraccion> infracciones;
	private ArrayList<Calificacion> calificaciones;
	
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public Miembro(int id, String n, String a, int e)
	{
		idMiembro = id;
		nombre =n;
		apellido = a;
		edad = e;
		amigos = new ArrayList<Miembro>();
		infracciones = new ArrayList<Infraccion>();
		ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
	}
	public void calificar(Miembro miembro, Date fechaPartido)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Calificando a "+miembro.getApellido()+", "+miembro.getNombre());
		System.out.println("Ingrese la nota:");
		int nota = scanner.nextInt();
		System.out.println("Ingrese un comentario:");
		String comentario = scanner.next();
		
		miembro.getCalificaciones().add(new Calificacion(nota, comentario, fechaPartido));
	}
	
	//Manda un mail a todos sus amigos
	public void notificarInscripcion()
	{
		Mock mockObject = new Mock();
		int len = amigos.size();
		for(int i=0;i<len;i++)
		{
			mockObject.enviarMail(amigos.get(i));
		}
	}
	
	public int getIdMiembro()
	{
		return idMiembro;
	}
        
        public Date getNacimiento()
	{
		return fechaNacimiento;
	}
        public int getEdad()
	{
		return edad;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	public String getApellido()
	{
		return apellido;
	}

	public ArrayList<Miembro> getAmigos() {
		return amigos;
	}


	public ArrayList<Infraccion> getInfracciones() {
		
		return infracciones;
	}
	
	
	public boolean equals(Object aspirante)
	{
		return idMiembro == ((Aspirante) aspirante).getMiembro().getIdMiembro();
	}
	
	public String toString()
	{
		
		return "Nombre: "+nombre+"\n"
			  +"Apellido: "+apellido+"\n"
			  +"Edad: "+edad;
	}
	
}

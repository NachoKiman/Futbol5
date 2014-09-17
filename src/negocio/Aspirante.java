package negocio;
import java.util.*;

public class Aspirante {
	private Miembro miembro;
	private FormaInscripcion tipoInscripto;
	private Date fechaIncripcion;
	private double calificacion;
	
	

	public Aspirante(Miembro miembro, FormaInscripcion tipoInscripto, Date fechaIncripcion)
	{
		this.miembro =miembro;
		this.tipoInscripto = tipoInscripto;
		this.fechaIncripcion = fechaIncripcion;
	}

	public boolean tieneMasPrioridad(Aspirante asp)
	{
		if((asp.getFormaInscripto()).tieneMasPrioridad(tipoInscripto))
		{
			return true;
		}
		
		return false;
	}
	
	
	
	public FormaInscripcion getFormaInscripto()
	{
		return tipoInscripto;
	}
	
	public Date getFechaInscripcion()
	{
		return fechaIncripcion;
	}
	public void setMiembro(Miembro miembro)
	{
		this.miembro = miembro;
		
	}
	
	public Miembro getMiembro()
	{
		return miembro;
	}
	
	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
}

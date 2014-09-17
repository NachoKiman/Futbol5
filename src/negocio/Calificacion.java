package negocio;
import java.util.*;

public class Calificacion {

	private int nota;
	private String comentario;
	private Date fechaPartido;
	
	public Calificacion(int nota, String comentario, Date fechaPartido) {
		
		this.nota = nota;
		this.comentario = comentario;
		this.fechaPartido = fechaPartido;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}
	
	
}

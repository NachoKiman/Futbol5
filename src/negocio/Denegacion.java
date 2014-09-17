package negocio;

import java.util.*;

public class Denegacion {
	private String razon;
	private Date fecha;
	
	
	
	public Denegacion(String razon, Date fecha) {
		
		this.razon = razon;
		this.fecha = fecha;
	}
	public String getRazon() {
		return razon;
	}
	public void setRazon(String razon) {
		this.razon = razon;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}

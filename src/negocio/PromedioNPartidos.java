package negocio;

import java.util.ArrayList;

public class PromedioNPartidos implements Criterio {
	private int n;
	
	
	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public double puntuar(Miembro miembro)
	{
		ArrayList<Calificacion> calificaciones  = miembro.getCalificaciones();
		int len = calificaciones.size();
		
		int i=0;
		int j = 0;
		double sumaCalificaciones =0;
		//Primera iteracion para todos los partidos que quiere
		while ((i<len)&&(j<n))
		{
			Calificacion calificacionAnterior = null;
			if (len!=0)
			{
				calificacionAnterior = calificaciones.get(0);
			}
			//Iteracion a partir de cada partido
			while((i<len)&&
					  (calificaciones.get(i)).getFechaPartido().equals(calificacionAnterior.getFechaPartido()))
				{
					//Incremento la suma
					Calificacion calificacion = calificaciones.get(i);
					sumaCalificaciones += calificacion.getNota();
					
					//Me preparo para la siguiente vuelta
					calificacionAnterior = calificacion;
					i++;
					
				}
			j++;
		}
		
		return (sumaCalificaciones/i);
	}

}

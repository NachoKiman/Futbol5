package negocio;
import java.util.*;

public class Mix implements Criterio {
	private int n;
	private ArrayList<Criterio> criterios;
	
	public double puntuar(Miembro miembro)
	{
		int len = criterios.size();
		int sumaTotal =0;
		for(int i=0; i<len-1;i++)
		{
			Criterio criterio = criterios.get(i);
			sumaTotal+=criterio.puntuar(miembro);
		}
		
		return (sumaTotal/len);
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public ArrayList<Criterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(ArrayList<Criterio> criterios) {
		this.criterios = criterios;
	}
	
}

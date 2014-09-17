package negocio;

public abstract class FormaInscripcion {
	private int prioridad;
	
	
	public boolean tieneMasPrioridad(FormaInscripcion fIns)
	{
		
		if(fIns.getPrioridad() < prioridad)
		{
			return true;
		}
		return false;
		
	}
	
	public int getPrioridad()
	{
		return prioridad;
	}
	
	protected void setPrioridad(int p)
	{
		prioridad = p;
	}
	
}

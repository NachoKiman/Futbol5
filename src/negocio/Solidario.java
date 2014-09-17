package negocio;

public class Solidario extends FormaInscripcion 
{
	
	public Solidario()
	{
		super.setPrioridad(2);
	}
	
	//esta sobreescrito porque el solidario deja a otro solidario
	//tomar su lugar, en caso de que este lleno.
	public boolean tieneMasPrioridad(FormaInscripcion fIns)
	{
	
		if (super.getPrioridad() == fIns.getPrioridad())
		{
			return true;
		}
		else
		{
			return super.tieneMasPrioridad(fIns);
		}
		

	}
	
	
}

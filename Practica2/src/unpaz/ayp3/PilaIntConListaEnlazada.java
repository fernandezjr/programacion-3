package unpaz.ayp3;

public class PilaIntConListaEnlazada implements PilaInt
{
	private ListaInt lista;
	
	public PilaIntConListaEnlazada() 
	{
		lista = new ListaInt();
	}

	@Override
	public void apilar(int n) 
	{
		lista.agregarAdelante(n);
	}

	@Override
	public void desapilar()
	{
		lista.quitarEnPosicion(0);		
	}

	@Override
	public boolean estaVacia() 
	{
		return (lista.estaVacia());
	}

	@Override
	public int tope()
	{
		return lista.iesimo(0);
	}
}
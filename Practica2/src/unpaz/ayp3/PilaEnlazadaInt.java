package unpaz.ayp3;

public class PilaEnlazadaInt implements PilaInt
{
	private NodoInt primero;
	
	public PilaEnlazadaInt()
	{
		primero = null;
	}

	@Override
	public void apilar(int n) 
	{
		NodoInt nuevo = new NodoInt(n);
		nuevo.setSiguiente(primero);
		primero = nuevo;
	}

	//PRECOND: !estaVacia()
	@Override
	public void desapilar() 
	{
		if(estaVacia())
			throw new RuntimeException("Pila vacia. No se puede desapilar");
		
		primero = primero.getSiguiente();
	}

	@Override
	public boolean estaVacia() 
	{
		return (primero == null);
	}

	//PRECOND: !estaVacia()
	@Override
	public int tope() 
	{
		if(estaVacia())
			throw new RuntimeException("Pila vacia. No se puede obtener tope");
		
		return primero.getElemento();
	}
	
	//PRECOND: !estaVacia()
	public void imprimir()
	{
		if(estaVacia())
			throw new RuntimeException("Pila vacia. No se puede imprimir");
		
		NodoInt actual = primero;
		while(actual != null)
		{
			System.out.println(actual + " ");
			actual = actual.getSiguiente();
		}
	}
}
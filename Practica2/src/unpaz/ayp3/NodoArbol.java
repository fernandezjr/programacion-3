package unpaz.ayp3;

public class NodoArbol 
{
	private ElementoComparable elemento;
	private NodoArbol hijo_izquierdo;
	private NodoArbol hijo_derecho;
	
	public NodoArbol(ElementoComparable elemento) 
	{
		this.elemento = elemento;
		hijo_izquierdo = null;
		hijo_derecho = null;
	}

	public ElementoComparable getElemento() 
	{
		return elemento;
	}

	public void setElemento(ElementoComparable elemento) 
	{
		this.elemento = elemento;
	}

	public NodoArbol getHIzq() 
	{
		return hijo_izquierdo;
	}

	public void setHIzq(NodoArbol hijoIzq) 
	{
		hijo_izquierdo = hijoIzq;
	}

	public NodoArbol getHDer() 
	{
		return hijo_derecho;
	}

	public void setHDer(NodoArbol hijoDer) 
	{
		hijo_derecho = hijoDer;
	}
	
	public void visitar()
	{
		System.out.print(elemento + " ");
	}
}
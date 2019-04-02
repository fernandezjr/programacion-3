package unpaz.ayp3;

public class Arbol 
{
	private NodoArbol raiz;
	
	public Arbol()
	{
		raiz = null;
	}
	
	public void insertar(ElementoComparable e)
	{
		NodoArbol nuevo = new NodoArbol(e);
		
		if(this.estaVacio())
			raiz = nuevo;
		else
			this.insertar(raiz, nuevo);
	}
	
	private void insertar(NodoArbol raizSubarbol, NodoArbol nuevo)
	{
		if(nuevo.getElemento().menorQue(raizSubarbol.getElemento()))
		{
			if(raizSubarbol.getHIzq() == null)
				raizSubarbol.setHIzq(nuevo);
			else
				this.insertar(raizSubarbol.getHIzq(), nuevo);
		}
		else
		{
			if(raizSubarbol.getHDer() == null)
				raizSubarbol.setHDer(nuevo);
			else
				this.insertar(raizSubarbol.getHDer(), nuevo);
		}
	}
	
	private boolean estaVacio()
	{
		return (raiz == null);
	}
	
	public void recorrerPreOrden()
	{
		recorrerPreOrden(raiz);
	}
	
	private void recorrerPreOrden(NodoArbol nodo)
	{
		if(nodo != null)
		{
			nodo.visitar();
			recorrerPreOrden(nodo.getHIzq());
			recorrerPreOrden(nodo.getHDer());
		}
	}
	
	public void recorrerInOrden()
	{
		recorrerInOrden(raiz);
	}
	
	private void recorrerInOrden(NodoArbol nodo)
	{
		if(nodo != null)
		{
			recorrerInOrden(nodo.getHIzq());
			nodo.visitar();
			recorrerInOrden(nodo.getHDer());
		}
	}
	
	public void recorrerPostOrden()
	{
		recorrerPostOrden(raiz);
	}
	
	private void recorrerPostOrden(NodoArbol nodo)
	{
		if(nodo != null)
		{
			recorrerPostOrden(nodo.getHIzq());
			recorrerPostOrden(nodo.getHDer());
			nodo.visitar();
		}
	}
	
	public int profundidad()
	{
		return profundidad(raiz);
	}
	
	private int profundidad(NodoArbol nodo)
	{
		if(nodo != null)
		{
			return mayor(profundidad(nodo.getHIzq()), 
					profundidad(nodo.getHDer())) + 1;
		}
		else
			return 0;
	}
	
	private int mayor(int x, int y)
	{
		return (x > y ? x : y);
	}
	
	public ElementoComparable minimo()
	{
		ElementoComparable minimo = null;
		NodoArbol actual = raiz;
		while(actual != null)
		{
			minimo = actual.getElemento();
			actual = actual.getHIzq();
		}
		return minimo;
	}
	
	public ElementoComparable maximo()
	{
		ElementoComparable maximo = null;
		NodoArbol actual = raiz;
		while(actual != null)
		{
			maximo = actual.getElemento();
			actual = actual.getHDer();
		}
		return maximo;
	}
}
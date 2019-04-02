package unpaz.ayp3;

public class ListaInt 
{
	private NodoInt primero;
	
	public ListaInt()
	{
		primero = null;
	}
	
	public int largo()
	{
		int largo = 0;
		NodoInt actual = this.primero;
		
		while(actual != null)
		{
			largo++;
			actual = actual.getSiguiente();
		}
		
		return largo;
	}
	
	public boolean estaVacia()
	{
		return (this.primero == null);
	}
	
	public int suma()
	{
		int suma = 0;
		NodoInt actual = this.primero;
		
		while(actual != null)
		{
			suma += actual.getElemento();
			actual = actual.getSiguiente();
		}
		
		return suma;
	}
	
	public double promedio()
	{
		if(largo() != 0)
			return this.suma() / this.largo();
		else
			throw new RuntimeException("No se puede promediar una lista vacia");
	}
	
	// PRECOND: 0 <= i < largo()
	public int iesimo(int i)
	{
		return this.nodoIesimo(i).getElemento();
	}
	
	public boolean buscar(int n)
	{
		NodoInt actual = this.primero;		
		while(actual != null)
		{
			if(actual.getElemento() == n)
				return true;
			
			actual = actual.getSiguiente();
		}		
		return false;
	}
	
	
	//PRECOND: !estaVacia()
	public int maximo()
	{
		if(estaVacia()) throw new RuntimeException("No se pudo buscar el maximo "
				+ "ya que la lista esta vacia");
		
		int maximo = 0;
		NodoInt actual = this.primero;
		
		while(actual != null)
		{
			if(actual.getElemento() > maximo)
				maximo = actual.getElemento();
			
			actual = actual.getSiguiente();
		}
		return maximo;
	}
	
	public boolean estaOrdenada()
	{
		if(!this.estaVacia())
		{
			NodoInt actual = this.primero;			
			while(actual.getSiguiente() != null)
			{
				NodoInt siguiente = actual.getSiguiente();				
				while(siguiente != null)
				{
					if(actual.getElemento() > siguiente.getElemento())
						return false;
					
					siguiente = siguiente.getSiguiente();
				}				
				actual = actual.getSiguiente();
			}
		}		
		return true;
	}
	
	// PRECOND: !this.estaOrdenada()
	public void ordenar()
	{
		NodoInt actual = this.primero;
		
		while(actual.getSiguiente() != null)
		{
			int minimo = actual.getElemento();
			NodoInt siguiente = actual.getSiguiente();
			
			while(siguiente != null)
			{
				if(siguiente.getElemento() < minimo)
				{
					minimo = siguiente.getElemento();
					siguiente.setElemento(actual.getElemento()); // refactorizar
					actual.setElemento(minimo);
				}				
				siguiente = siguiente.getSiguiente();
			}			
			actual = actual.getSiguiente();
		}
	}
	
	public void rotarDerecha()
	{
		NodoInt ultimo = this.nodoIesimo(this.largo() - 1);
		this.agregarAdelante(ultimo.getElemento());
		this.quitarEnPosicion(this.largo() - 1);
	}
	
	// PRECOND: 0 <= pos < this.largo()
	public void agregarEnPosicion(int pos, int elem)
	{
		if(pos == 0)
			this.agregarAdelante(elem);
		else
		{
			if(pos == this.largo())
				this.agregarAtras(elem);
			else
			{
				NodoInt nuevo = new NodoInt(elem);
				NodoInt anterior = this.nodoIesimo(pos - 1);
				nuevo.setSiguiente(anterior.getSiguiente());
				anterior.setSiguiente(nuevo);
			}
		}
	}
	
	// PRECOND: this.estaOrdenada
	public void insertarOrdenado(int e)
	{
		NodoInt actual = this.primero;
		int i = 0;
		boolean insertado = false;
		
		while(!insertado && actual != null)
		{
			if(actual.getElemento() >= e)
			{
				this.agregarEnPosicion(i, e);
				insertado = true;
			}
			
			i++;
			actual = actual.getSiguiente();
		}
	}
	
	public static void intercambiarColas(ListaInt l1, int pos1, ListaInt l2, int pos2) {}
	
	public ListaInt buscarTodos(int n)
	{
		ListaInt posiciones = new ListaInt();
		int posicion = 0;
		NodoInt actual = primero;
		while(actual != null)
		{
			if(actual.getElemento() == n)
				posiciones.agregarAtras(posicion);
			
			posicion++;
			actual = actual.getSiguiente();
		}
		return posiciones;
	}
	
	public void anexar(ListaInt otraLista)
	{
		NodoInt actual = otraLista.primero;
		while(actual != null)
		{
			this.agregarAtras(actual.getElemento());
			actual = actual.getSiguiente();
		}
	}
	
	public static ListaInt concatenar(ListaInt l1, ListaInt l2)
	{
		l1.anexar(l2);
		return l1;
	}
	
	public ListaInt reversa()
	{
		NodoInt actual = primero;
		ListaInt reversa = new ListaInt();
		while(actual != null)
		{
			reversa.agregarAdelante(actual.getElemento());
			actual = actual.getSiguiente();
		}
		return reversa;
	}
	
	// PRECOND: l1.estaOrdenada() && l2.estaOrdenada()
	public static ListaInt combinarListasOrdenadas(ListaInt l1, ListaInt l2)
	{
		if(!l1.estaOrdenada() || !l2.estaOrdenada())
			throw new RuntimeException("Las listas no estan ordenadas");
		
		l1.anexar(l2);
		l1.ordenar();
		return l1;
	}
	
	public void agregarAdelante(int elemento)
	{
		NodoInt nuevo = new NodoInt(elemento);
		nuevo.setSiguiente(this.primero);
		this.primero = nuevo;
	}
	
	// PRECOND: 0 <= i < largo()
	private NodoInt nodoIesimo(int i)
	{
		if(!indiceValido(i)) throw new RuntimeException("Se intento acceder a un indice "
				+ "no existente en la lista");
		
		int posicion = 0;
		NodoInt buscado = this.primero;
		
		while(posicion < i && buscado != null)
		{
			posicion++;
			buscado = buscado.getSiguiente();
		}
		
		return buscado;
	}
	
	private boolean indiceValido(int i)
	{
		return (i >= 0 && i < largo());
	}
	
	// PRECOND: 0 <= posicion < this.largo()
	public void quitarEnPosicion(int posicion)
	{
		if(posicion == 0)
			this.primero = this.primero.getSiguiente();
		else
		{
			NodoInt anterior = this.nodoIesimo(posicion - 1);
			NodoInt nodoAquitar = this.nodoIesimo(posicion);
			
			if(nodoAquitar.getSiguiente() == null)
				anterior.setSiguiente(null);
			else
				anterior.setSiguiente(nodoAquitar.getSiguiente());
		}
	}
	
	public void agregarAtras(int elemento)
	{
		if(this.estaVacia())
			this.agregarAdelante(elemento);
		else
		{
			NodoInt ultimo = this.nodoIesimo(this.largo() - 1);
			NodoInt nuevo = new NodoInt(elemento);
			ultimo.setSiguiente(nuevo);
		}
	}
	
	public void imprimir()
	{
		NodoInt actual = this.primero;
		
		while(actual != null)
		{
			System.out.print(actual + " ");
			actual = actual.getSiguiente();
		}
	}
}
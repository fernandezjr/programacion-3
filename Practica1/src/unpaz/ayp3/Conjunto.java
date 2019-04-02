package unpaz.ayp3;

public class Conjunto 
{
	int[] elementos;
	int cantidad;
	
	Conjunto()
	{
		elementos = new int[10];
		cantidad = 0;
	}
	
	Conjunto(int[] elementos, int cantidad)
	{
		this.elementos = elementos;
		this.cantidad = cantidad;
	}
	
	void agregar(int n)
	{
		if(this.estaLleno())
		{
			elementos = Arreglos.agregarAlFinal(elementos, n);
		}
		else
		{
			elementos[cantidad] = n;
		}
		cantidad++;
	}
	
	private boolean estaLleno()
	{
		return (cantidad == elementos.length);
	}
	
	boolean pertenece(int n)
	{
		for(int i = 0; i < cantidad; i++)
		{
			if(elementos[i] == n)
			{
				return true;
			}
		}
		return false;
	}
	
	void quitar(int n)
	{
		if(this.pertenece(n))
		{
			int posicionN = this.buscar(n);
			elementos[posicionN] = 0;
			cantidad--;
		}
	}
	
	// PRECOND: this.pertenece(n)
	private int buscar(int n)
	{
		int posicion = 0, i = 0;
		boolean encontrado = false;
		while(!encontrado && i < cantidad)
		{
			if(elementos[i] == n)
			{
				posicion = i;
				encontrado = true;
			}
			i++;
		}
		return posicion;
	}
	
	static Conjunto union(Conjunto c1, Conjunto c2)
	{
		int[] elementosC1 = c1.getElementos();
		int[] elementosC2 = c2.getElementos();
		
		int[] unido = Arreglos.pegar(elementosC1, elementosC2);
		
		return new Conjunto(unido, unido.length);
	}
	
	private int[] getElementos()
	{
		int[] elementos = new int[cantidad];
		for(int i = 0; i < cantidad; i++)
		{
			elementos[i] = this.elementos[i];
		}
		return elementos;
	}
	
	static Conjunto interseccion(Conjunto c1, Conjunto c2)
	{
		Conjunto interseccion = new Conjunto();
		for(int i = 0; i < c1.cantidad; i++)
		{
			if(c2.pertenece(c1.elementos[i]))
			{
				interseccion.agregar(c1.elementos[i]);
			}
		}
		return interseccion;
	}
	
	static Conjunto resta(Conjunto c1, Conjunto c2)
	{
		c1.restar(c2);
		return c1;
	}
	
	void restar(Conjunto c)
	{
		for(int i = 0; i < this.cantidad; i++)
		{
			if(this.pertenece(c.elementos[i]))
			{
				this.quitar(c.elementos[i]);
			}
		}
	}
	
	void imprimir()
	{
		for(int i = 0; i < cantidad; i++) // puede delegar en Arreglos.imprimir(elementos)?
		{
			System.out.print(elementos[i] + " ");
		}
	}
}
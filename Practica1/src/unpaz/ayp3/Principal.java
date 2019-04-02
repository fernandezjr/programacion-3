package unpaz.ayp3;

public class Principal 
{
	public static void main(String[] args) 
	{
		Conjunto c1 = new Conjunto();
		c1.agregar(18);
		c1.agregar(7);
		
		Conjunto c2 = new Conjunto();		
		c2.agregar(33);
		c2.agregar(7);
		
		Conjunto.interseccion(c1, c2).imprimir();
	}
}
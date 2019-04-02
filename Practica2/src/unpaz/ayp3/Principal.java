package unpaz.ayp3;

public class Principal 
{
	public static void main(String[] args) 
	{
		Fecha f1 = new Fecha(18, 10, 1978);
		Fecha f2 = new Fecha(8, 05, 1993);
		Fecha f3 = new Fecha(28, 8, 2006);
		Fecha f4 = new Fecha(20, 6, 1953);
		ElementoComparable e4 = new Persona("Diego", f1);
		ElementoComparable e5 = new Persona("Maria", f2);
		ElementoComparable e6 = new Persona("Paula", f3);
		ElementoComparable e7 = new Persona("Eliseo", f4);
		
		Arbol a1 = new Arbol();
		a1.insertar(e4);
		a1.insertar(e5);
		a1.insertar(e6);
		a1.insertar(e7);
		
		System.out.println("Profundidad: " + a1.profundidad());
	}
}
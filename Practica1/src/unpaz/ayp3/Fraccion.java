package unpaz.ayp3;

public class Fraccion 
{
	int numerador;
	int denominador;
	
	// PRECOND: denominador != 0
	Fraccion(int numerador, int denominador)
	{
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	void imprimir()
	{
		System.out.println(numerador + "/" + denominador);
	}
	
	void invertirSigno()
	{
		denominador *= -1;
	}
	
	void invertir()
	{
		int auxiliar = numerador;
		numerador = denominador;
		denominador = auxiliar;
	}
	
	double aDouble()
	{
		return (double) numerador / denominador;
	}
	
	static Fraccion producto(Fraccion q1, Fraccion q2)
	{
		int numerador = q1.numerador * q2.numerador;
		int denominador = q2.denominador * q2.denominador;
		return new Fraccion(numerador, denominador);
	}
	
	static Fraccion suma(Fraccion q1, Fraccion q2)
	{
		int numerador = (q1.numerador * q2.denominador) + (q2.numerador * q1.denominador);
		int denominador = q1.denominador * q2.denominador;
		return new Fraccion(numerador, denominador);
	}
}
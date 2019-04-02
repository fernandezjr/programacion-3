package unpaz.ayp3;

public class Circulo 
{
	double radio;
	Punto centro;
	
	Circulo(double centro_x, double centro_y, double radio)
	{
		this.radio = radio;
		centro = new Punto(centro_x, centro_y);
	}
	
	void imprimir()
	{
		System.out.print("r = " + radio + " ");
		centro.imprimir();
	}
	
	double perimetro()
	{
		return 2 * (3.14) * radio;
	}
	
	double superficie()
	{
		return Math.pow(radio, 2) * 3.14;
	}
	
	void escalar(double factor)
	{
		radio *= factor;
	}
	
	void desplazar(double desp_x, double desp_y)
	{
		centro.desplazar(desp_x, desp_y);
	}
	
	static double distancia(Circulo c1, Circulo c2)
	{
		return Punto.distancia(c1.centro, c2.centro) - (c1.radio + c2.radio);
	}
	
	static boolean seTocan(Circulo c1, Circulo c2)
	{
		double distanciaCentros = Punto.distancia(c1.centro, c2.centro);
		
		return (c1.esIgual(c2, distanciaCentros) || c1.loToca(c2, distanciaCentros));
	}
	
	private boolean esIgual(Circulo otro, double distanciaCentros)
	{
		return (distanciaCentros == 0 && this.radio == otro.radio);
	}
	
	private boolean loToca(Circulo otro, double distanciaCentros)
	{
		return (distanciaCentros != 0 && (this.radio - otro.radio) <= distanciaCentros 
				&& (this.radio + otro.radio) >= distanciaCentros);
	}
	
	boolean loContiene(Circulo otro)
	{
		double distanciaCentros = Punto.distancia(this.centro, otro.centro);
		
		return (this.radio >= distanciaCentros + otro.radio);
	}
}
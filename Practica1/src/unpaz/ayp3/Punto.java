package unpaz.ayp3;

public class Punto 
{
	double x;
	double y;
	
	Punto()
	{
		x = 0;
		y = 0;
	}
	
	Punto(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	void imprimir()
	{
		System.out.println("x = " + x + ", y = " + y);
	}
	
	void desplazar(double desp_x, double desp_y)
	{
		x += desp_x;
		y += desp_y;
	}
	
	static double distancia(Punto p1, Punto p2)
	{
		return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
	}
}
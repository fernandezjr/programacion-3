package unpaz.ayp3;

public class PilaIntArreglo implements PilaInt
{
	int[] elementos;
	int tope;
	
	public PilaIntArreglo() 
	{
		elementos = new int[10];
		tope = -1;
	}
	
	@Override
	public void apilar(int n) 
	{
		elementos[tope + 1] = n;
		
	}
	@Override
	public void desapilar() 
	{
		elementos[tope] = 0;
		tope--;
	}
	@Override
	public boolean estaVacia() 
	{
		return (tope == -1);
	}
	@Override
	public int tope() 
	{
		return elementos[tope];
	}
}
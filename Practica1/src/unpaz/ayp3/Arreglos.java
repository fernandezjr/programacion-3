package unpaz.ayp3;

public class Arreglos 
{
	static boolean esSinRepetidos(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(cantidadApariciones(arr[i], arr) > 1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	static int[] pegar(int[] arr, int [] arr2)
	{
		int[] nuevo = new int[arr.length + arr2.length];
		nuevo = copiar(arr, nuevo, 0);
		nuevo = copiar(arr2, nuevo, arr.length);
		
		return nuevo;
	}
	
	// PRECOND: origen.length <= (destino.lenght - posicion)
	private static int[] copiar(int[] origen, int[] destino, int posicion)
	{
		for(int i = 0; i < origen.length; i++)
		{
			destino[posicion] = origen[i];
			posicion++;
		}
		
		return destino;
	}
	
	static int[] agregarAlFinal(int[] arr, int elem)
	{
		int[] nuevo = new int[arr.length + 1];
		nuevo = copiar(arr, nuevo, 0);
		nuevo[nuevo.length - 1] = elem;
		
		return nuevo;
	}
	
	static int[] sinRepetidos(int[] arr)
	{
		if(esSinRepetidos(arr)) return arr;
		
		int[] sinRepetidos = new int[1];
		sinRepetidos[0] = arr[0];
		
		for(int i = 1; i < arr.length; i++)
		{
			if(!pertenece(arr[i], sinRepetidos))
			{
				sinRepetidos = agregarAlFinal(sinRepetidos, arr[i]);
			}
		}
		
		return sinRepetidos;
	}
	
	static boolean pertenece(int valor, int[] arreglo)
	{
		return (cantidadApariciones(valor, arreglo) > 0);
	}
	
	private static int cantidadApariciones(int valor, int[] arreglo)
	{
		int apariciones = 0;
		
		for(int i = 0; i < arreglo.length; i++)
		{
			if(arreglo[i] == valor)
			{
				apariciones++;
			}
		}
		return apariciones;
	}
	
	static void invertir(int[] arr)
	{
		for(int i = 0; i < arr.length / 2; i++)
		{
			int auxiliar = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = auxiliar;
		}
	}
	
	static void imprimir(int[] arreglo)
	{
		for(int i = 0; i < arreglo.length; i++)
		{
			System.out.print(arreglo[i] + " ");
		}
	}
}
package unpaz.ayp3;

import unpaz.ayp3.Consola;

public class Principal 
{
	public static void main(String[] args) 
	{
		Principal.collatz(1);
	}
	
	static void imprimirHolaMundo() // Ejercicio 1
	{
		System.out.println("¡Hola, mundo!");
	}
	
	static void imprimirSaludo() // Ejercicio 2
	{
		String nombre = Consola.pedirTexto("Cual es tu nombre?");
		System.out.println("Hola " + nombre);
	}
	
	static void imprimirSuma() // Ejercicio 3
	{
		int a = Consola.pedirEntero("Ingrese numero A: ");
		int b = Consola.pedirEntero("Ingrese numero B: ");
		Principal.imprimirSuma(a, b);
	}
	
	static int sumar(int a, int b)
	{
		return a + b;
	}
	
	static void imprimirPromedio() // Ejercicio 5
	{
		int a = Consola.pedirEntero("Ingrese numero A: ");
		int b = Consola.pedirEntero("Ingrese numero B: ");
		Principal.imprimirPromedio(a, b);
	}
	
	static double promedio(int total, int cantidad)
	{
		return total / cantidad;
	}
	
	static void imprimirSuma(int a, int b) // Ejercicio 6
	{
		System.out.println("La suma es: " + Principal.sumar(a, b));
	}
	
	static void imprimirPromedio(int a, int b) // Ejercicio 7
	{
		int total = Principal.sumar(a, b);
		System.out.println("El promedio es: " + Principal.promedio(total, 2));
	}
	
	static void ponerNota(double x, double y) // Ejercicio 8
	{
		double totalNotas = Principal.sumar((int) x, (int) y);
		double promedio = Principal.promedio((int) totalNotas, 2);
		System.out.println(Principal.getCondicion(promedio));
	}
	
	static String getCondicion(double promedio)
	{
		if(promedio >= 7)
			return "Promocionado";
		else
		{
			if(promedio >= 4)
				return "Aprobado";
			else
				return "Debe recuperar";
		}
	}
	
	static void imprimirFecha(int dia, int mes, int anio) // Ejercicio 9
	{
		String nombreMes = Principal.getNombreMes(mes);
		System.out.println(dia + " de " + nombreMes + " de " + anio);
	}
	
	static String getNombreMes(int mes)
	{
		String nombreMes = "";
		switch(mes)
		{
			case 1: nombreMes = "Enero"; break;
			case 2: nombreMes = "Febrero"; break;
			case 3: nombreMes = "Marzo"; break;
			case 4: nombreMes = "Abril"; break;
			case 5: nombreMes = "Mayo"; break;
			case 6: nombreMes = "Junio"; break;
			case 7: nombreMes = "Julio"; break;
			case 8: nombreMes = "Agosto"; break;
			case 9: nombreMes = "Septiembre"; break;
			case 10: nombreMes = "Octubre"; break;
			case 11: nombreMes = "Noviembre"; break;
			case 12: nombreMes = "Diciembre"; break;
		}
		return nombreMes;
	}
	
	static void imprimirParImpar(int x) // Ejercicio 10
	{
		if(Principal.esPar(x))
		{
			System.out.println(x + " es par");
		}
		else
		{
			System.out.println(x + " es impar");
		}
	}
	
	static boolean esPar(int n)
	{
		return (Principal.esDivisible(n, 2));
	}
	
	static int cantCifras(int n) // Ejercicio 11
	{
		String numero = Integer.toString(n);
		return numero.length();
	}
	
	static boolean esDivisible(int n, int m) // Ejercicio 12
	{
		return (n % m == 0);
	}
	
	static int sumatoria(int n) // Ejercicio 13
	{
		return (Principal.iterSumatoria(n));
	}
	
	static int sumatoriaPares(int n) // Ejercicio 14
	{
		return (Principal.iterSumatoriaPares(n));
	}
	
	static double potencia(double x, int a) // Ejercicio 15
	{
		return (double) (Principal.recurPotencia((int) x, a));
	}
	
	static double factorial(int n) // Ejercicio 16
	{
		return (double) (Principal.iterFactorial(n));
	}
	
	static int recurSumatoria(int n) // Ejercicio 17
	{		
		if(n == 0)
		{
			return 0;
		}
		
		return n + recurSumatoria(n - 1);
	}
	
	static int recurSumatoriaPares(int n)
	{
		if(n == 0)
			return 0;
		else 
		{
			if(Principal.esPar(n))
				return n + recurSumatoriaPares(n - 2);
			else
				return recurSumatoriaPares(n - 1);
		}
	}
		
	static int recurPotencia(int n, int e)
	{				
		if(e == 1)
			return n;
		else
		{
			if(e == 0)
				return 1;
			else
				return n * recurPotencia(n, e - 1);
		}
	}
	
	static int recurFactorial(int n)
	{
		if(n == 0)
		{
			return 1;
		}
		
		return n * recurFactorial(n - 1);
	}
	
	static int iterSumatoria(int n) // Ejercicio 18
	{
		int sumatoria = 0;
		
		for(int i = 1; i <= n; i++)
		{
			sumatoria += i;
		}
		
		return sumatoria;			
	}
	
	static int iterSumatoriaPares(int n)
	{
		int sumatoriaPares = 0;
		
		for(int i = 1; i <= n; i++)
		{
			if(Principal.esPar(i))
			{
				sumatoriaPares += i;
			}
		}
		
		return sumatoriaPares;
	}
	
	static int iterPotencia(int n)
	{
		int e = Consola.pedirEntero("Exponente:");
		int potencia = n;
		
		for(int i = 1; i < e; i++)
		{
			potencia *= n;
		}
		
		return potencia;
	}
	
	static int iterFactorial(int n)
	{
		for(int i = n - 1; i > 1; i--)
		{
			n *= i;
		}
		
		return n;
	}
	
	static void imprimirReversa() // Ejercicio 19
	{
		String cadena = Consola.pedirTexto("Ingrese palabra");
		Principal.imprimirReversa(cadena);
	}
	
	static String reversa(String cadena)
	{
		String invertido = "";
		
		for(int i = cadena.length() - 1; i >= 0; i--)
		{
			invertido += cadena.charAt(i);
		}
		
		return invertido;
	}
	
	static void imprimirReversa(String cadena)
	{
		System.out.println(Principal.reversa(cadena));
	}
	
	static int cantidadApariciones(String s, char c) // Ejercicio 20
	{
		int apariciones = 0;
		
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == c)
			{
				apariciones++;
			}
		}
		
		return apariciones;
	}
	
	static int cantidadVocales(String s) // Ejercicio 21
	{
		int vocales = 0;
		
		for(int i = 0; i < s.length(); i++)
		{
			if(Principal.esVocal(s.charAt(i)))
			{
				vocales++;
			}
		}
		
		return vocales;
	}
	
	static boolean esVocal(char c)
	{
		if(c == 'a' || c == 'e' || c == 'i' 
				|| c == 'o' || c == 'u')
		{
			return true;
		}
		
		return false;
	}
	
	static boolean esAbecedaria(String s) // Ejercicio 22
	{
		for(int i = 0; i < s.length() - 1; i++)
		{
			if(s.charAt(i) > s.charAt(i + 1))
			{
				return false;
			}
		}
		
		return true;
	}
	
	static boolean esCapicua(String s) // Ejercicio 23
	{
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) != s.charAt(s.length() - i - 1))
			{
				return false;
			}
		}
		
		return true;
	}
	
	static boolean esSinRepetidos(String s) // Ejercicio 24
	{
		for(int i = 0; i < s.length() - 1; i++)
		{
			for(int j = i + 1; j < s.length(); j++)
			{
				if(s.charAt(j) == s.charAt(i))
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	static String sinRepetidos(String s) // Ejercicio 25
	{
		String sinRepetidos = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			if(!Principal.pertenece(sinRepetidos, s.charAt(i)))
			{
				sinRepetidos += s.charAt(i);
			}
		}
		
		return sinRepetidos;
	}
	
	static boolean pertenece(String s, char c)
	{
		for(int i = 0; i < s.length(); i++)
		{
			if(Principal.cantidadApariciones(s, c) > 0)
			{
				return true;
			}
		}
		
		return false;
	}
	
	static int fibrec(int n) // Ejercicio 26
	{
		if(n == 0 || n == 1)
		{
			return n;
		}
		
		return fibrec(n - 1) + fibrec(n - 2);
	}
	
	static int fibiter(int n)
	{
		int f0 = 0, f1 = 1, fn = 0;
		
		for(int i = 2; i <= n; i++)
		{
			fn = f0 + f1;
			f0 = f1;
			f1 = fn;
		}
		
		return fn;
	}
	
	static void collatz(int n) // Ejercicio 27
	{
		do
		{
			if(Principal.esPar(n))
				n /= 2;
			else
				n = 3 * n + 1;
			
			System.out.println(n);
		} while(n != 0 && n!= 1);
	}
}
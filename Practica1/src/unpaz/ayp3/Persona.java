package unpaz.ayp3;

public class Persona 
{
	String nombre;
	Fecha fecha_nacimiento;
	
	Persona(String nombre, Fecha f_nac)
	{
		this.nombre = nombre;
		fecha_nacimiento = new Fecha(f_nac.dia, f_nac.mes, f_nac.anio);
	}
	
	void imprimir()
	{
		System.out.print(nombre + " ");
		fecha_nacimiento.imprimir();
	}
	
	boolean masJovenQue(Persona otro)
	{
		return (this.fecha_nacimiento.esPosterior(otro.fecha_nacimiento));
	}
	
	boolean tocayo(Persona otro)
	{
		return (this.nombre.equals(otro.nombre));
	}
	
	boolean mismaPersona(Persona otro)
	{
		return (this.tocayo(otro) && this.fecha_nacimiento.esIgual(otro.fecha_nacimiento));
	}
	
	// PRECOND: grupo.length > 0
	static Persona masJoven(Persona[] grupo)
	{
		Persona masJoven = grupo[0];
		
		for(int i = 1; i < grupo.length; i++)
		{
			if(grupo[i].masJovenQue(masJoven))
			{
				masJoven = grupo[i];
			}
		}
		
		return masJoven;
	}
	
	static Persona buscar(Persona[] grupo, String nombre)
	{
		for(int i = 0; i < grupo.length; i++)
		{
			if(grupo[i].nombre.equals(nombre))
			{
				return grupo[i];
			}
		}
		
		return null;
	}
}
package unpaz.ayp3;

public class Persona implements ElementoComparable
{
	private String nombre;
	private Fecha fecha_nacimiento;
	
	public Persona(String nombre, Fecha f_nac)
	{
		this.nombre = nombre;
		fecha_nacimiento = new Fecha(f_nac.getDia(), f_nac.getMes(), f_nac.getAnio());
	}

	@Override
	public boolean igualQue(ElementoComparable otro) 
	{
		Persona otra = (Persona) otro;
		return (this.fecha_nacimiento.esIgual(otra.fecha_nacimiento));
	}

	@Override
	public boolean menorQue(ElementoComparable otro) 
	{
		Persona otra = (Persona) otro;
		return (this.fecha_nacimiento.esPosterior(otra.fecha_nacimiento));
	}

	@Override
	public boolean menorIgualQue(ElementoComparable otro) 
	{
		return (this.menorQue(otro) || this.igualQue(otro));
	}

	@Override
	public boolean mayorQue(ElementoComparable otro) 
	{
		Persona otra = (Persona) otro;
		return (this.fecha_nacimiento.esAnterior(otra.fecha_nacimiento));
	}

	@Override
	public boolean mayorIgualQue(ElementoComparable otro) 
	{
		return (this.igualQue(otro) || this.mayorQue(otro));
	}
	
	public String toString()
	{
		return nombre + " " + fecha_nacimiento.toString();
	}
}
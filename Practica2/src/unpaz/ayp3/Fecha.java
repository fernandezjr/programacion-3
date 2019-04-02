package unpaz.ayp3;

public class Fecha 
{
	private int dia;
	private int mes;
	private int anio;
	
	public Fecha(int dia, int mes, int anio)
	{
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	public int getDia() 
	{
		return dia;
	}

	public int getMes() 
	{
		return mes;
	}

	public int getAnio() 
	{
		return anio;
	}
	
	public boolean esAnterior(Fecha otra)
	{
		if(this.anio < otra.anio)
		{
			return true;
		}
		else if(this.anio == otra.anio)
		{
			if(this.mes < otra.mes)
			{
				return true;
			}
			else if(this.mes == otra.mes)
			{
				if(this.dia < otra.dia)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean esIgual(Fecha otra)
	{
		return (this.dia == otra.dia && this.mes == otra.mes
				&& this.anio == otra.anio);
	}
	
	public boolean esPosterior(Fecha otra)
	{
		if(this.anio > otra.anio)
		{
			return true;
		}
		else if(this.anio == otra.anio)
		{
			if(this.mes > otra.mes)
			{
				return true;
			}
			else if(this.mes == otra.mes)
			{
				if(this.dia > otra.dia)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString()
	{
		return "" + dia + "/" + mes + "/" + anio;
	}
}
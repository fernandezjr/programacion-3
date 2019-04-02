package unpaz.ayp3;

public class Fecha 
{
	int dia;
	int mes;
	int anio;
	
	Fecha(int dia, int mes, int anio)
	{
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	void imprimir()
	{
		System.out.print(dia + "/" + mes + "/" + anio + " ");
	}
	
	boolean esPosterior(Fecha otra)
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
	
	boolean esIgual(Fecha otra)
	{
		return (this.dia == otra.dia && this.mes == otra.mes
				&& this.anio == otra.anio);
	}
}
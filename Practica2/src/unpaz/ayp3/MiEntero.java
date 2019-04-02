package unpaz.ayp3;

public class MiEntero implements ElementoComparable
{
	private int valor;
	
	public MiEntero(int valor) 
	{
		this.valor = valor;
	}
	
	@Override
	public boolean igualQue(ElementoComparable otro) 
	{
		MiEntero otroEntero = (MiEntero) otro;
		return (this.valor == otroEntero.valor);
	}

	@Override
	public boolean menorQue(ElementoComparable otro) 
	{
		MiEntero otroEntero = (MiEntero) otro;
		return (this.valor < otroEntero.valor);
	}

	@Override
	public boolean menorIgualQue(ElementoComparable otro) 
	{
		MiEntero otroEntero = (MiEntero) otro;
		return (this.valor <= otroEntero.valor);
	}

	@Override
	public boolean mayorQue(ElementoComparable otro) 
	{
		MiEntero otroEntero = (MiEntero) otro;
		return (this.valor > otroEntero.valor);
	}

	@Override
	public boolean mayorIgualQue(ElementoComparable otro) 
	{
		MiEntero otroEntero = (MiEntero) otro;
		return (this.valor >= otroEntero.valor);
	}
	
	public String toString()
	{
		return "" + valor;
	}
}
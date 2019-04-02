package unpaz.ayp3;

public class NodoInt 
{
	private int elemento;
	private NodoInt siguiente;
	
	public NodoInt(int elemento)
	{
		this.elemento = elemento;
		siguiente = null;
	}
	
	public int getElemento() 
	{
		return elemento;
	}
	
	public void setElemento(int elemento) 
	{
		this.elemento = elemento;
	}
	
	public NodoInt getSiguiente() 
	{
		return siguiente;
	}
	
	public void setSiguiente(NodoInt siguiente) 
	{
		this.siguiente = siguiente;
	}
	
	public String toString()
	{
		return "" + this.elemento;
	}
}
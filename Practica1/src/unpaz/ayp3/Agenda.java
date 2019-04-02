package unpaz.ayp3;

public class Agenda 
{
	Persona[] contactos;
	String[] telefonos;
	
	Agenda(int tamanio)
	{
		contactos = new Persona[tamanio];
		telefonos = new String[tamanio];
	}
	
	void guardar(Persona contacto, String telefono)
	{
		boolean guardado = false;
		int i = 0;
		
		while(!guardado && i < contactos.length)
		{
			if(contactos[i] == null)
			{
				contactos[i] = contacto;
				telefonos[i] = telefono;
				guardado = true;
			}
			
			i++;
		}
	}
	
	void eliminar(Persona contacto)
	{
		boolean eliminado = false;
		int i = 0;
		
		while(!eliminado && i < contactos.length)
		{
			if(contactos[i].mismaPersona(contacto))
			{
				contactos[i] = null;
				telefonos[i] = null;
				eliminado = true;
			}
			i++;
		}
	}
	
	boolean pertenece(Persona contacto)
	{
		for(int i = 0; i < contactos.length; i++)
		{
			if(contactos[i].mismaPersona(contacto))
			{
				return true;
			}
		}
		
		return false;
	}
	
	// PRECOND: this.pertenece(contacto)
	String dameTelefono(Persona contacto)
	{
		String telefono = "";
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i < contactos.length)
		{
			if(contactos[i].mismaPersona(contacto))
			{
				telefono = telefonos[i];
				encontrado = true;
			}
			i++;
		}
		return telefono;
	}
	
	void imprimir()
	{
		int i = 0;
		
		while(contactos[i] != null && i < contactos.length)
		{
			contactos[i].imprimir();
			System.out.println(" " + telefonos[i]);
			i++;
		}
	}
}
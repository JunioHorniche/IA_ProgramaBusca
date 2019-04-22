public class Node
{
	private Estado estado;
	private Node next = null;
	
	public Node(Estado estado)
	{
		this.estado = estado;
	}
	
	public Node(Estado estado, Node next)
	{
		this.estado = estado;
		this.next = next;
	}
	
	public Estado getEstado()
	{
		return estado;
	}

	public Node getNext()
	{
		return next;
	}

	public String toString()
	{
		return estado.toString();
	}
}

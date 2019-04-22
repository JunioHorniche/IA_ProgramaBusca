import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
	
		ArrayList <Node> fila = new ArrayList<>();
		
		Estado inicial = new Estado(0, 1, 2, 1, false);
		
		Node atual = new Node(inicial);
		
		fila.add(atual);
		
		while(!atual.getEstado().estadoFinal())
		{
			fila.remove(0);
			
			ArrayList <Estado> filhos = atual.getEstado().expande();
			
			for(int i = 0; i < filhos.size(); i++)
			{
				Node n1 = new Node(filhos.get(i), atual);
				fila.add(n1);
			}
			atual = fila.get(0);
		}
		
		while(atual.getNext() != null)
		{
			System.out.println(atual.getEstado());
			atual = atual.getNext();
		}
		System.out.println(atual.getEstado());
	}
}

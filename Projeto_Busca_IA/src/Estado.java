import java.util.ArrayList;

public class Estado
{
	private int xMacaco;
	private int yMacaco;
	private int xCaixa;
	private int yCaixa;
	private boolean pegouBanana;
	
	public Estado(int xMacaco, int yMacaco, int xCaixa, int yCaixa, boolean pegouBanana)
	{
		this.xMacaco = xMacaco;
		this.yMacaco = yMacaco;
		this.xCaixa = xCaixa;
		this.yCaixa = yCaixa;
		this.pegouBanana = pegouBanana;
	}
	
	private Estado andarDireita() //Estado para andar para direita
	{
		if(restricoes(this.xMacaco, this.yMacaco, this.xCaixa, this.yCaixa))
			return new Estado(this.xMacaco + 1, this.yMacaco, this.xCaixa, this.yCaixa, this.pegouBanana);
		return null;
	}
	
	private Estado andarEsquerda() //Estado para andar para esquerda
	{
		if(restricoes(this.xMacaco, this.yMacaco, this.xCaixa, this.yCaixa))
			return new Estado(this.xMacaco - 1, this.yMacaco, this.xCaixa, this.yCaixa, this.pegouBanana);
		return null;
	}
	
	private Estado subirCaixa() //Estado para subir na caixa
	{
		if(restricoes(this.xMacaco, this.yMacaco, this.xCaixa, this.yCaixa))
			return new Estado(this.xMacaco + 1, this.yMacaco - 1, this.xCaixa, this.yCaixa, this.pegouBanana);
		return null;
	}
	
	private Estado descerCaixa() //Estado para descer da caixa
	{
		if(restricoes(this.xMacaco, this.yMacaco, this.xCaixa, this.yCaixa))
			return new Estado(this.xMacaco - 1, this.yMacaco + 1, this.xCaixa, this.yCaixa, this.pegouBanana);
		return null;
	}
	
	private Estado puxarCaixa() //Estado para puxar a caixa
	{
		if(restricoes(this.xMacaco, this.yMacaco, this.xCaixa, this.yCaixa))
			return new Estado(this.xMacaco - 1, this.yMacaco, this.xCaixa - 1, this.yCaixa, this.pegouBanana);
		return null;
	}
	
	private Estado empurrarCaixa() //Estado para empurrar a caixa
	{
		if(restricoes(this.xMacaco, this.yMacaco, this.xCaixa, this.yCaixa))
			return new Estado(this.xMacaco + 1, this.yMacaco, this.xCaixa + 1, this.yCaixa, this.pegouBanana);
		return null;
	}
	
	private Estado pegarBanana() //Estado para pegar a banana
	{
		if(restricoes(this.xMacaco, this.yMacaco, this.xCaixa, this.yCaixa))
		{
			return new Estado(this.xMacaco, this.yMacaco, this.xCaixa, this.yCaixa, true);
		}
		return null;
	}
	
	private boolean restricoes(int xMacaco, int yMacaco, int xCaixa, int yCaixa) //Restrições
	{
		if((xMacaco + 1 <= 4) && (xMacaco + 1 != xCaixa) && (yMacaco == 1)) //Restrição direira
			return true;
		if((yMacaco == 1) && (xMacaco - 1 >= 0)) //Restrição esquerda
			return true;
		if((xMacaco == xCaixa - 1) && (yMacaco == yCaixa)) //Restrição subir sobre a caixa
			return true;
		if((xMacaco == xCaixa) && (yMacaco == yCaixa - 1)) //Restrição para descer da caixa
			return true;
		if((xMacaco - 1 >= 0) && (xMacaco == xCaixa - 1) && (yMacaco == 1)) //Restrição para puxar a caixa
			return true;
		if((xCaixa + 1 <= 4) && (xMacaco == xCaixa - 1) && (yMacaco == 1)) //Restrição para empurrar a caixa
			return true;
		if((xMacaco == 2) && (yMacaco == 0) && (xCaixa == 2) && (yCaixa == 1)) //Restrição para pegar a banana
			return true;
		return false;
	}
	
	public boolean estadoFinal() //Estado final
	{
		return (xMacaco == 4 && yMacaco == 0 && xCaixa == 4 && yCaixa == 1 && pegouBanana == true);
	}
	
	public ArrayList<Estado> expande()
	{
		ArrayList <Estado> novosEstados = new ArrayList<>();
		if(andarDireita() != null)
			novosEstados.add(andarDireita());
		if(andarEsquerda() != null)
			novosEstados.add(andarEsquerda());
		if(subirCaixa() != null)
			novosEstados.add(subirCaixa());
		if(descerCaixa() != null)
			novosEstados.add(descerCaixa());
		if(puxarCaixa() != null)
			novosEstados.add(puxarCaixa());
		if(empurrarCaixa() != null)
			novosEstados.add(empurrarCaixa());
		if(pegarBanana() != null)
			novosEstados.add(pegarBanana());
		return novosEstados;

	}
	
	public String toString() //Desenha os estados
	{
		String msg = "";
		for(int i=0; i <= 1; i++)
	    {
	        for(int j=0; j <= 5; j++)
	        {
	            msg += "|";
	            if(this.xMacaco == j && this.yMacaco == i)
	                msg += "M";
	            else if(this.xCaixa == j && this.yCaixa == i)
	                msg += "C";
	            else
	                msg += " ";
	        }
	        msg += "\n";
	    }
		msg += "Pegou Banana: " + this.pegouBanana + "\n\n";
		return msg;
	}
}

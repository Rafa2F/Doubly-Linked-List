package util;
import view.Pessoa;


public class Nodo  {

	
	private Pessoa date;
	private Nodo next;
	private Nodo prev;
	
	
	public Nodo(Pessoa date){
		this.date=date;
	
	}	
	public Nodo(Pessoa obj, Nodo next)
	{
		
		this.next=next;
		this.date=obj;
		
	}
	
	public Pessoa getDate()
	{
		return date;

	}
	
	public void setDate(Pessoa date)
	{
		this.date=date;

	}
	
	public Nodo getNext()
    {
    	 return next;
     
    }
     
	public void setNext(Nodo next)
	{
		this.next=next;
	
	}
	
	public void setPrev(Nodo prev){
		this.prev=prev;
	}
	
	public Nodo getPrev(){
		return prev;
	}

}	


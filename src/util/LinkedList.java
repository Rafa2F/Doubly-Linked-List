package util;

import java.util.Collections;

import view.Pessoa;

public class LinkedList{

		private Nodo primeiro;
		private Nodo ultimo;
		private int totalElementos;
		
	
		public void adiciona(Pessoa elemento){
			if(this.totalElementos==0)
			{
				this.adicionaNoComecoDupla(elemento);

			}else{
				Nodo novo=new Nodo(elemento);
				this.ultimo.setNext(novo);
				this.ultimo=novo;
				this.totalElementos++;
			}
		}
		
		public String toString(){
			if(this.totalElementos==0)
			{
				return "[]";
			}
			Nodo atual=primeiro;
			while(atual!=null)
			{
				System.out.println(atual.getDate()+"\n");
				atual=atual.getNext();
			}
			
			return toString();
		}
		
		private boolean posicaoOcupada(int posicao){
			return posicao>=0 && posicao <this.totalElementos;
		}
		
		private Nodo pegaNodo(int posicao){
			if(!this.posicaoOcupada(posicao))
			{
				throw new IllegalArgumentException("Posicão não existe.");
			}
			
			Nodo atual=primeiro;
			for(int i=0; i<posicao; i++)
			{
				atual=atual.getNext();
			
			}
			return atual;
		}
		
		public void contem(String palavra){
			Nodo atual=this.primeiro;
			int soma=0;
			for(int i=0;i<totalElementos;i++)
			{
				if(atual.getDate().getNome().equals(palavra))
				{
					atual.getDate().dados();	
				} else {
				System.out.println("Elemento "+(i+1)+" Não localizado");
				}
				
				soma++;
				atual=atual.getNext();
			}


		
			
		}
		
		public boolean eVazia(){
		    
			if(primeiro==null)
			{
		    System.out.println("Lista vazia.");
		     return true;
		    }
		    	return false;   
		}
		
		public int tamanho(){
			return this.totalElementos;
		}
		
	public void adicionaNoComecoDupla(Pessoa elemento){
		Collections.sort(primeiro.getDate().getNome());
		if(this.primeiro==null)
		{
			Nodo novo=new Nodo(elemento);
			this.primeiro=novo;
			this.ultimo=novo;
		}else{
			Nodo novo=new Nodo(elemento, this.primeiro);
			this.primeiro.setPrev(novo);
			this.primeiro=novo;
		}
		totalElementos++;
	}
	
	
	public void ordenar(){
		Nodo x=this.primeiro;
		Nodo y=this.primeiro.getNext();
		Nodo temp;
		
		if(x.getDate().getNome()=="A")
		{
			if(y.getDate().getNome()=="B")
			{
			y=y.getNext();	
			}else{
				temp=x.getNext();
				x=y.getNext();
				x=y.getPrev();
				y=x.getNext();
			}
				
		}
	}

	public void adicionaNoFimDupla(Pessoa elemento){

		if(this.primeiro==null)
		{
			adicionaNoComecoDupla(elemento);
		}else{
			Nodo novo=new Nodo(elemento);
			this.ultimo.setNext(novo);
			this.ultimo.setPrev(this.ultimo);
			this.ultimo=novo;
			totalElementos++;
		}
	}
		
	public void adicionaPosicao(int posicao, Pessoa elemento) {
		  if(posicao == 0)
		  { 
		    this.adicionaNoComecoDupla(elemento);
		    
		  } else if(posicao == this.totalElementos) { 
		    
			  this.adiciona(elemento);
		    
		  } else {
			  
		    Nodo anterior = this.pegaNodo(posicao - 1);
		    Nodo proxima = anterior.getNext();
		    Nodo novo = new Nodo(elemento, anterior.getNext());
		    novo.setPrev(anterior);
		    anterior.setPrev(novo);
		    proxima.setPrev(novo);
		    this.totalElementos++;
		    
		  }
		}
	
	public void remove(int posicao) { 
        if (primeiro != null) 
        { 
            //se for remover o primeiro
            if (posicao==1) 
            {
                this.primeiro = this.primeiro.getNext();
            } else {
                Nodo novo = primeiro.getNext();
                novo.setPrev(primeiro);
                //percorre a lista
                while (novo != null && posicao!=totalElementos)
                {
                    novo = novo.getNext();
                }
                
                //se temp for diferente de null é pq encontrou o objeto
                if (novo != null) 
                {
                    novo.getPrev().setNext(novo.getNext());
                    novo.getNext().setPrev(novo.getPrev());
                } 
            }
        } 
    } 
		
}
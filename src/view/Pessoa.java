package view;
import java.util.*;
public class Pessoa {

	private String nome;
	private String endereco;
	private Agenda telefone;
	
	public Pessoa(){
		
	}
	
	public void dados(){
		System.out.println("Nome: "+nome+" Endereco: "+endereco+" Telefone: ");
		this.telefone.telefones();
		
	}
	public Pessoa(String nome, String endereco, Agenda telefone)
	{
		this.nome=nome;
		this.endereco=endereco;
		this.telefone=telefone;
		
	}
	
	public String getNome(){
		return nome;
	}
	
	
	
}

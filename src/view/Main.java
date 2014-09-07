package view;
import util.LinkedList;

import java.util.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.Nodo;
public class Main {

	public static void main(String[] args)throws IOException { 
		InputStream is=new FileInputStream("Pessoas.txt");
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		
		
		
		/*for(int i=0;i<listPessoa.size(); i++){
			System.out.println(listPessoa.get(i));
		}	
		*/
		
		LinkedList link=new LinkedList();
	
		Scanner input=new Scanner(System.in);
		
	
		boolean painel=true;
		while(painel){
		System.out.println("1- Criar Lista");
		System.out.println("2- Buscar Pessoa");
		System.out.println("3- Adicionar Pessoa");
		System.out.println("4- Listar todos");
		System.out.println("5- Adicionar Depois");
		System.out.println("6- Adicionar Antes");
		int opcao=input.nextInt();
		switch(opcao){
		
		case 1:
			// Criar Lista
			String linha;
			String [] palavras;
			
			while((linha=br.readLine())!= null)
			{
			
				palavras=linha.split("#");
				String nome=null;
				String endereco=null;
				String telefone = null;
				int tempo=0;
				String[] tempTel = new String[20];
			
			for(int i=0; i<palavras.length;i++)
			{
				
				if(i==0){
					nome=palavras[i];
					//System.out.println("\nNome: "+nome);
				}
				if(i==1){
					endereco=palavras[i];
				//	System.out.println("Endereco: "+endereco);
		
				}
				
				else{
				//	System.out.println("Telefone" +telefone);
				telefone=palavras[i];
					tempTel[tempo]=telefone;
				tempo++;
				}		
				
			}//Fim For
			
			Agenda agendaObj=new Agenda(tempTel);
			
			Pessoa pessoaObj=new Pessoa(nome,endereco, agendaObj);
		
			Nodo nodoObj=new Nodo(pessoaObj);
			
			link.adicionaNoFimDupla(pessoaObj);

			
			}//Fim While
	
		break;
		
		case 2:
			//Buscar Pessoa
			input=new Scanner(System.in);
			System.out.println("Digite o nome da pessoa");
			String nome=input.nextLine();
			link.contem(nome);
			
			break;
		case 3:
			//Adicionar Pessoa
			input=new Scanner(System.in);
			System.out.println("Digite o nome");
			String nomeAdd=input.nextLine();
			
			input=new Scanner(System.in);
			System.out.println("Digite o endereco: ");
			String enderecoAdd=input.nextLine();
	
			boolean telefone=true;
			String[] telefoneAdd=new String[20];
			int telCount=1;
			while(telefone)
			{
			
				input=new Scanner(System.in);
				System.out.println("Digite o telefone: ");
				String telefoneUser=input.nextLine();
				telefoneAdd[telCount]=telefoneUser;
				input=new Scanner(System.in);
				System.out.println("Continuar adicionando telefone? 1- Sim, 2 Não");
				int opTel=input.nextInt();
				if(opTel==1)
				{
					telefone=true;
		
				}else{
				telefone=false;
				}
				telCount++;	
			}
			
			Agenda agendaAdd=new Agenda(telefoneAdd);
			Pessoa pessoaAdd=new Pessoa(nomeAdd, enderecoAdd, agendaAdd);
			link.adicionaNoFimDupla(pessoaAdd);
			
			break;
		case 4:
			
			System.out.println(link);
			
			break;
		case 5:
			
			painel=false;
			
			
			break;
			default:
				
				break;
		}
		
		}// Fim while
	
	}
	
}

package view;

import java.util.Arrays;

public class Agenda {

	private String[] telefone;
	
	public Agenda(String[] telefone){
		this.telefone=telefone;
	}

	public void telefones(){
		for(int i=1;i<telefone.length;i++){
			if(telefone[i]==null){
				i=telefone.length;
			}else{
			System.out.println(telefone[i]);
			}
		}
	}

}

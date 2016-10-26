package br.com.fiap.main;

import br.com.fiap.repository.ClienteRepository;


public class RemoverTest {
	
	
	public static void main(String[] args) {
		
		ClienteRepository rep = new ClienteRepository();
		
		try{
			rep.excluir(3);
			System.out.println("Exluido com sucesso !");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		

}

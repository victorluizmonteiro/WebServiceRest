package br.com.fiap.main;

import br.com.fiap.model.Cliente;
import br.com.fiap.repository.ClienteRepository;

public class AtualizarTest {

	public static void main(String[] args) throws Exception{
		
		ClienteRepository rep = new ClienteRepository();
		
		
		
		try{
			Cliente cliente = rep.buscar(1);
			cliente.setNome("Marcos");
			
			rep.alterar(cliente);
			
			System.out.println("Cliente alterado ! ");
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}

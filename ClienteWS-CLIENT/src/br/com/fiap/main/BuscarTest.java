package br.com.fiap.main;

import br.com.fiap.model.Cliente;
import br.com.fiap.repository.ClienteRepository;

public class BuscarTest {
	
	public static void main(String[] args) {
		ClienteRepository rep = new ClienteRepository();
		
		try{
			Cliente c = rep.buscar(1);
			System.out.println(c.getNome() +"\n " + c.getLogradouro());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

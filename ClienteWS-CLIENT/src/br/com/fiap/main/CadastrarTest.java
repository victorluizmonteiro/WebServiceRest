package br.com.fiap.main;

import java.util.Calendar;

import br.com.fiap.model.Cliente;
import br.com.fiap.repository.ClienteRepository;

public class CadastrarTest {

	public static void main(String[] args) {
		
		Cliente c = new Cliente(0,"Lucas","11-41844282","Av  Teixeira Lott",Calendar.getInstance());
		
		try{
			ClienteRepository dao = new ClienteRepository();
			
			dao.cadastrar(c);
			
			System.out.println("Cliente cadastrado com sucesso");
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}

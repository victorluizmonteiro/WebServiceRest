package br.com.fiap.main;

import java.util.List;

import br.com.fiap.model.Cliente;
import br.com.fiap.repository.ClienteRepository;

public class ListarTest {

	public static void main(String[] args) {
		ClienteRepository dao = new ClienteRepository();
		
		List<Cliente>lista = dao.listar();
		
		
		for (Cliente cliente : lista) {
			
			System.out.println(cliente.getNome());
			
		}

	}

}

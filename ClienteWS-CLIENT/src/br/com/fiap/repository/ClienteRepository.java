package br.com.fiap.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import br.com.fiap.model.Cliente;

public class ClienteRepository {

	public void cadastrar(Cliente cliente) {
		try {
			// Cria o objeto URL com o endereço do WebService
			URL url = new URL("http://localhost:8080/ClienteWS-SERVER/rest/cliente/");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Configura o Método http
			connection.setRequestMethod("POST");
			// Configura o tipo de informação que será enviada (JSON)
			connection.setRequestProperty("Content-type", "application/json");

			// Configura o charset para os caracteres especiais
			connection.setRequestProperty("charset", "utf-8");

			// Para permitir o envido do JSON para o servidor
			connection.setDoOutput(true);

			// Mandar o objeto Agencia para o servidor

			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(new Gson().toJson(cliente));
			writer.close();

			// recupera o código HTTP do retorno da conexão
			int codigoHTTP = connection.getResponseCode();

			// Valida se deu erro
			// (codigo diferente de 201 - Created)
			if (codigoHTTP != 201) {
				throw new Exception(codigoHTTP + " " + connection.getResponseMessage());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> listar() {

		try {
			URL url = new URL("http://localhost:8080/ClienteWS-SERVER/rest/cliente/");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("charset", "utf-8");

			int httpCode = connection.getResponseCode();

			if (httpCode == 200) {
				// Recupera o JSON
				BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String linha;

				// Armazena o JSON retornado
				StringBuilder builder = new StringBuilder();

				while ((linha = buffer.readLine()) != null) {
					builder.append(linha);
				}

				// Converte o JSON na lista de Clientes

				Cliente[] array = new Gson().fromJson(builder.toString(), Cliente[].class);

				// Transforma o Array em lista e Retorna
				return Arrays.asList(array);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void excluir(int id) throws Exception {

		URL url = new URL("http://localhost:8080/ClienteWS-SERVER/rest/cliente/" + id);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("DELETE");

		int httpCode = connection.getResponseCode();

		if (httpCode != 200) {
			throw new Exception("Ocorreu algum erro");
		}

	}

	public void alterar(Cliente cliente) throws Exception {

		URL url = new URL("http://localhost:8080/ClienteWS-SERVER/rest/cliente/");

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("charset", "utf-8");

		con.setDoOutput(true);

		OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());

		writer.write(new Gson().toJson(cliente));
		writer.close();

		int httpCode = con.getResponseCode();

		if (httpCode != 200) {
			throw new Exception("Ocorreu um erro");
		}

	}
	
	public Cliente buscar(int codigo)throws Exception{
		
		URL url = new URL("http://localhost:8080/ClienteWS-SERVER/rest/cliente/" + codigo);
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("charset", "utf-8");
		
		int status =  con.getResponseCode();
		
		if(status == 200){
			//le a resposta do servidor (JSON)
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			
			StringBuilder builder = new StringBuilder();
			String linha;
			
			while((linha = reader.readLine()) != null){
				builder.append(linha);
			}
			return new Gson().fromJson(builder.toString(), Cliente.class);
		}
		return null;
	}

}

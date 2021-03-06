package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class DetalheEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Detalhando a empresa!");
		
		String paramId = request.getParameter("id");
		int id = Integer.parseInt(paramId);
		
		Banco bd = new Banco();
		

		request.setAttribute("empresa", bd.getEmpresa(id));

		
		return "forward:formNovaEmpresa.jsp";
		
	}
	
}

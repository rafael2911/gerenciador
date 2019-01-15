package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Servlet Controladora!!!");
		
		String acao = request.getParameter("acao");
		
		if(acao.equals("detalheEmpresa")) {
			System.out.println("Detalhando a empresa!");
		}else if(acao.equals("listaEmpresas")) {
			System.out.println("Listando a empresa!");
		}else if(acao.equals("novaEmpresa")) {
			System.out.println("Cadastrando/Editando empresa!");
		}else if(acao.equals("removeEmpresa")) {
			System.out.println("Removendo empresa!");
		}
		
	}
	
}

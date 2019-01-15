package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.DetalheEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Servlet Controladora!!!");
		
		String acao = request.getParameter("acao");
		
		if(acao.equals("detalheEmpresa")) {
			DetalheEmpresa de = new DetalheEmpresa();
			de.executa(request, response);
		}else if(acao.equals("listaEmpresas")) {
			ListaEmpresas le = new ListaEmpresas();
			le.executa(request, response);
		}else if(acao.equals("novaEmpresa")) {
			System.out.println("Cadastrando/Editando empresa!");
		}else if(acao.equals("removeEmpresa")) {
			System.out.println("Removendo empresa!");
		}
		
	}
	
}

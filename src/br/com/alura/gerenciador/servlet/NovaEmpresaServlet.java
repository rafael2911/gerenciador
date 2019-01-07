package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	// utilizando o método doPost: a requisição só é permitida através do method Post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		System.out.println("Cadastrando nova empresa!!!");
		
		//recebendo parâmetros
		String nome = req.getParameter("nome");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Empresa " + nome + " cadastrada com sucesso!!!");
		out.println("<body>");
		out.println("</html>");
		
	}
}

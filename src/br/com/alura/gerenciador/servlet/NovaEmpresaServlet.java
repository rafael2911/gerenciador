package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	// utilizando o m�todo doPost: a requisi��o s� � permitida atrav�s do method Post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		System.out.println("Cadastrando nova empresa!!!");
		
		//recebendo par�metros
		String nome = req.getParameter("nome");
		
		Empresa empresa = new Empresa(nome);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		System.out.println("Listando empresas cadastradas!!!");
		System.out.println(banco.getEmpresas());
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Empresa " + nome + " cadastrada com sucesso!!!");
		out.println("<body>");
		out.println("</html>");
		
	}
}

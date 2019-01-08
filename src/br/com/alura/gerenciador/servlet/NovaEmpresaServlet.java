package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	// utilizando o método doPost: a requisição só é permitida através do method Post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		System.out.println("Cadastrando nova empresa!!!");
		
		//recebendo parâmetros
		String nome = req.getParameter("nome");
		
		Empresa empresa = new Empresa(nome);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		System.out.println("Listando empresas cadastradas!!!");
		System.out.println(banco.getEmpresas());
		
		RequestDispatcher rd = req.getRequestDispatcher("/novaEmpresaCriada.jsp");
		req.setAttribute("empresa", empresa.getNome());
		rd.forward(req, resp);
		
	}
}

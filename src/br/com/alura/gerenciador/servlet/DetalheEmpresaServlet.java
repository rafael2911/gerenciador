package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/detalheEmpresa")
public class DetalheEmpresaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String paramId = req.getParameter("id");
		int id = Integer.parseInt(paramId);
		
		Banco bd = new Banco();
		

		req.setAttribute("empresa", bd.getEmpresa(id));

		
		RequestDispatcher rd = req.getRequestDispatcher("/formNovaEmpresa.jsp");
		rd.forward(req, resp);
	}
	
}

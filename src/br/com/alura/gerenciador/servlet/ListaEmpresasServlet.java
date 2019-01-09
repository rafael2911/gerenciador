package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet(urlPatterns="/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		
//		out.println("<html><body>");
////		out.println("<table border='1'>");
////		out.println("<tr><th>Nome da Empresa</th></tr>");
////		lista.forEach(empresa -> out.println("<tr><td>" + empresa.getNome() + "</td></tr>"));
////		out.println("</table>");
//		out.println("<ul>");
//		lista.forEach(empresa -> out.println("<li>" + empresa.getNome() + "</li>"));
//		out.println("</ul>");
//		out.println("<body><html>");
		
		RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas.jsp");
		req.setAttribute("empresas", lista);
		rd.forward(req, resp);
		
	}
	
}

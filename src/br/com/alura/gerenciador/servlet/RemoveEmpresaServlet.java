package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String paramId = req.getParameter("id");
		
		if(!paramId.isEmpty()) {
//			int id = Integer.parseInt(paramId);
			Integer id = Integer.valueOf(paramId); // conforme a aula
			
			Banco banco = new Banco();
			banco.removeEmpresa(id);
			
		}
		
		
		resp.sendRedirect("listaEmpresas");
		
	}
	
}

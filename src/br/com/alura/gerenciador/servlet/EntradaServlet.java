package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.DetalheEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.RemoveEmpresa;
import br.com.alura.gerenciador.acao.SalvaEmpresa;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Servlet Controladora!!!");
		
		String acao = request.getParameter("acao");
		
		String resposta = null;
		
		if(acao.equals("detalheEmpresa")) {
			DetalheEmpresa de = new DetalheEmpresa();
			resposta = de.executa(request, response);
		}else if(acao.equals("listaEmpresas")) {
			ListaEmpresas le = new ListaEmpresas();
			resposta = le.executa(request, response);
		}else if(acao.equals("salvaEmpresa")) {
			SalvaEmpresa se = new SalvaEmpresa();
			resposta = se.executa(request, response);
		}else if(acao.equals("removeEmpresa")) {
			RemoveEmpresa re = new RemoveEmpresa();
			resposta = re.executa(request, response);
		}
		
		String[] RespostaEDestino = resposta.split(":");
		
		if(RespostaEDestino[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(RespostaEDestino[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(RespostaEDestino[1]);
		}
		
	}
	
}

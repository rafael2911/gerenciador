package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String paramId = req.getParameter("id");  
		String nome = req.getParameter("nome");
		String dataEmpresa = req.getParameter("data");
		
		Date dataEmpresaFmt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataEmpresaFmt = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		Empresa empresa = new Empresa(nome);
		empresa.setDataAbertura(dataEmpresaFmt);
		
		
		
		Banco banco = new Banco();
		
		if(paramId.isEmpty()) {
			banco.adiciona(empresa);
		}else {
			Integer id = Integer.valueOf(paramId);
			empresa.setId(id);
			banco.atualiza(empresa);
		}
		
		
//		System.out.println("Listando empresas cadastradas!!!");
//		System.out.println(banco.getEmpresas());
		
		req.setAttribute("empresa", empresa.getNome());
		resp.sendRedirect("listaEmpresas");
		
//		RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//		req.setAttribute("empresa", empresa.getNome());
//		rd.forward(req, resp);
		
	}
}

package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class SalvaEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("Cadastrando/Editando empresa!");
		
		//recebendo parâmetros
		String paramId = request.getParameter("id");  
		String nome = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		
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
		
		request.setAttribute("empresa", empresa.getNome());
		response.sendRedirect("entrada?acao=listaEmpresas");
		
	}
	
}

package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Integer index = 1;
	
	// Bloco statico, executado quando a máquina virtual carrega a classe
	static {
		
		Empresa e1 = new Empresa("Casa Blanca");
		e1.setId(Banco.index++);
		Banco.empresas.add(e1);
		
		Empresa e2 = new Empresa("Suvinil");
		e2.setId(Banco.index++);
		Banco.empresas.add(e2);
		
		Empresa e3 = new Empresa("Ambev");
		e3.setId(Banco.index++);
		Banco.empresas.add(e3);
		
		Empresa e4 = new Empresa("Bradesco");
		e4.setId(Banco.index++);
		Banco.empresas.add(e4);
		
		Usuario u1 = new Usuario();
		u1.setLogin("rafael");
		u1.setSenha("123456");
		
		Usuario u2 = new Usuario();
		u2.setLogin("mariana");
		u2.setSenha("1234");
		
		Banco.usuarios.add(u1);
		Banco.usuarios.add(u2);

	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.index++);
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Collections.unmodifiableList(Banco.empresas);
	}
	
	public Empresa getEmpresa(int id) {
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id)
				return empresa;
		}
		
		return null;
	}
	
	public void removeEmpresa(Integer id) {
//		Empresa e1 = new Empresa("teste");
//		for (Empresa empresa : empresas) {
//			if(empresa.getId() == id) {
//				e1 = empresa;
//			}
//		}
//		
//		Banco.empresas.remove(e1);
		
		// Feito na aula
		Iterator<Empresa> listaIterator = empresas.iterator();

		while(listaIterator.hasNext()) {
			
			if(listaIterator.next().getId() == id)
				listaIterator.remove();
			
		}
		
	}

	public void atualiza(Empresa emp) {
		for (Empresa empresa : empresas) {
			if(emp.getId() == empresa.getId()) {
				empresa.setNome(emp.getNome());
				empresa.setDataAbertura(emp.getDataAbertura());
			}
				
		}
		
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : usuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		
		return null;
		
	}
	
}

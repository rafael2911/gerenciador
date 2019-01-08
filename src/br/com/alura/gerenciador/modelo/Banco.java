package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	
	public Banco() {
		Banco.empresas.add(new Empresa("Casa Blanca"));
		Banco.empresas.add(new Empresa("Suvinil"));
		Banco.empresas.add(new Empresa("Ambev"));
		Banco.empresas.add(new Empresa("Bradesco"));
	}

	public void adiciona(Empresa empresa) {
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Collections.unmodifiableList(Banco.empresas);
	}
	
}

package br.com.limaconsultoria.apollo.domain;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Sheet
public class Usuario {
	
	@SheetColumn
	private String nome;
	
	@SheetColumn
	private String nomeMae;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;	
	}
	
}

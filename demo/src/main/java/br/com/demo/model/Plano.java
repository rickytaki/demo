package br.com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ricardo T. <rickytaki@yahoo.com.br>
 *
 */
@Entity
@Table(name = "plano")
public class Plano {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private int minutos;
	
	@Column(name = "minuto_adicional")
	private double minutoAdicional;
	
	public Plano() {
	}

	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return minutos
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * @param minutos the minutos to set
	 */
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	/**
	 * @return minutoAdicional
	 */
	public double getMinutoAdicional() {
		return minutoAdicional;
	}

	/**
	 * @param minutoAdicional the minutoAdicional to set
	 */
	public void setMinutoAdicional(double minutoAdicional) {
		this.minutoAdicional = minutoAdicional;
	}
	
}

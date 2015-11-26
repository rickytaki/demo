package br.com.demo.model;

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
@Table(name = "ddd")
public class Ddd {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String codigo;

	public Ddd() {
	}

	/**
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}

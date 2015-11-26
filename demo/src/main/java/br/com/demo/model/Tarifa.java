package br.com.demo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Ricardo T. <rickytaki@yahoo.com.br>
 *
 */
@Entity
public class Tarifa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Ddd origem;
	@OneToOne
	private Ddd destino;
	private BigDecimal taxa;
	
	public Tarifa(){
	}

	/**
	 * @return origem
	 */
	public String getOrigem() {
		return this.origem.getCodigo();
	}

	/**
	 * @param origem the origem to set
	 */
	public void setOrigem(Ddd origem) {
		this.origem = origem;
	}

	/**
	 * @return destino
	 */
	public String getDestino() {
		return this.destino.getCodigo();
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(Ddd destino) {
		this.destino = destino;
	}

	/**
	 * @return tarifa
	 */
	public BigDecimal getTaxa() {
		return taxa;
	}

	/**
	 * @param tarifa the tarifa to set
	 */
	public void setTaxa(BigDecimal tarifa) {
		this.taxa = tarifa;
	}
	
	

}

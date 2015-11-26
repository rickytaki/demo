package br.com.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.demo.model.Ddd;
import br.com.demo.model.Plano;
import br.com.demo.model.Tarifa;
import br.com.demo.repository.DddRepository;
import br.com.demo.repository.PlanoRepository;
import br.com.demo.repository.TarifaRepository;

/**
 * @author Ricardo T. <rickytaki@yahoo.com.br>
 *
 */
@SpringBootApplication
public class ComparadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComparadorApplication.class, args);
    }
    
	@Bean
	public InitializingBean insertDefaultDdd() {
		return new InitializingBean() {

			@Autowired
			private DddRepository dddRepo;

			@Override
			public void afterPropertiesSet() {
				addDdd("011");
				addDdd("016");
				addDdd("017");
				addDdd("018");
			}

			private void addDdd(String codigo) {
				Ddd ddd = new Ddd();
				ddd.setCodigo(codigo);
				dddRepo.save(ddd);
			}
		};
	}
	@Bean
	public InitializingBean insertDefaultTarifa() {
		return new InitializingBean() {
			
			@Autowired
			private TarifaRepository tarifaRepository;
			
			@Autowired
			private DddRepository repo;
			
			@Override
			public void afterPropertiesSet() {
				addTarifa(repo.findByCodigo("011"), repo.findByCodigo("016"), new BigDecimal("1.90"));
				addTarifa(repo.findByCodigo("016"), repo.findByCodigo("011"), new BigDecimal("2.90"));
				addTarifa(repo.findByCodigo("011"), repo.findByCodigo("017"), new BigDecimal("1.70"));
				addTarifa(repo.findByCodigo("017"), repo.findByCodigo("011"), new BigDecimal("2.70"));
				addTarifa(repo.findByCodigo("011"), repo.findByCodigo("018"), new BigDecimal("0.90"));
				addTarifa(repo.findByCodigo("018"), repo.findByCodigo("011"), new BigDecimal("1.90"));
			}
			
			private void addTarifa(Ddd origem, Ddd destino, BigDecimal taxa) {
				Tarifa tarifa = new Tarifa();
				tarifa.setOrigem(origem);
				tarifa.setDestino(destino);
				tarifa.setTaxa(taxa);
				tarifaRepository.save(tarifa);

			}
		};
	}
	
	@Bean
	public InitializingBean insertDefaultPlano() {
		return new InitializingBean() {

			@Autowired
			private PlanoRepository planoRepo;

			@Override
			public void afterPropertiesSet() {
				addPlano("Fale Mais 30", 30, 10);
				addPlano("Fale Mais 60", 60, 10);
				addPlano("Fale Mais 120", 120, 10);
			}

			private void addPlano(String nome, int minutos, double minutoAdicional) {
				Plano plano = new Plano();
				plano.setNome(nome);
				plano.setMinutos(minutos);
				plano.setMinutoAdicional(minutoAdicional);
				
				planoRepo.save(plano);
			}
		};
	}
}

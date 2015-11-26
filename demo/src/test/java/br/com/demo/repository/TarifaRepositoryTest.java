package br.com.demo.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.demo.ComparadorApplication;
import br.com.demo.model.Tarifa;


/**
 * @author Ricardo T. <rickytaki@yahoo.com.br>
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringApplicationConfiguration(classes = ComparadorApplication.class)
public class TarifaRepositoryTest {
	
	@Autowired
	TarifaRepository repo;
	
	@Autowired
	DddRepository dddRepo;
	Tarifa tarifa;

	@Before
	public void setUp() throws Exception {
	
		tarifa = new Tarifa();
		tarifa.setTaxa(new BigDecimal(3.10));
		tarifa.setOrigem(dddRepo.findByCodigo("011"));
		tarifa.setDestino(dddRepo.findByCodigo("016"));
		
	}

	@Test
	public void findAll() {
		tarifa = repo.save(tarifa);
		List<Tarifa> tarifas = (List<Tarifa>) repo.findAll();
		assertTrue(tarifas.contains(tarifa));
	}
	
	@Test
	public void findByOrigemAndDestino() {
		assertEquals(repo.findByOrigemAndDestino("011", "018"), 0.90 , 0.01);
	}

}

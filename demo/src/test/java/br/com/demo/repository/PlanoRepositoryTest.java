package br.com.demo.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.demo.ComparadorApplication;
import br.com.demo.model.Plano;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringApplicationConfiguration(classes = ComparadorApplication.class)
public class PlanoRepositoryTest {

	@Autowired
	PlanoRepository repo;
	Plano plano;
	
	@Before
	public void setup() throws Exception{
		
		plano = new Plano();
		plano.setNome("Plano teste");
		plano.setMinutos(500);
		plano.setMinutoAdicional(2.50);
	}
	
	@Test
	public void findAll() {
		
		plano = repo.save(plano);
		List<Plano> planos = (List<Plano>) repo.findAll();
		assertTrue(planos.contains(plano));
	
	}

}

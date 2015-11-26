/**
 * 
 */
package br.com.demo.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.demo.ComparadorApplication;
import br.com.demo.model.Ddd;

/**
 * @author Ricardo T. <rickytaki@yahoo.com.br>
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringApplicationConfiguration(classes = ComparadorApplication.class)
public class DddRepositoryTest {

	@Autowired
	DddRepository repo;
	Ddd ddd;
	
	@Before
	public void setup(){
		
		ddd = new Ddd();
		ddd.setCodigo("021");
	}
	
	@Test
	public void findAll() {
		
		ddd = repo.save(ddd);
		List<Ddd> ddds = (List<Ddd>) repo.findAll();
		assertTrue(ddds.contains(ddd));
	}
	
	@Test
	public void findByCodigo(){
		
		ddd = repo.save(ddd);
		Ddd dddAchado = repo.findByCodigo("021");
		assertNotNull(ddd);
		assertEquals(ddd, dddAchado);
	}

}

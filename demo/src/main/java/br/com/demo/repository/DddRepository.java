/**
 * 
 */
package br.com.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.demo.model.Ddd;

/**
 * @author ricardo
 *
 */
public interface DddRepository extends PagingAndSortingRepository<Ddd, Long>{
	
	Ddd findByCodigo(@Param("codigo") String codigo);
}

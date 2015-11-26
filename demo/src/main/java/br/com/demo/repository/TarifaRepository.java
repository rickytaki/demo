package br.com.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.demo.model.Tarifa;

public interface TarifaRepository extends PagingAndSortingRepository<Tarifa, Long> {

	@Query("SELECT t.taxa FROM Tarifa t JOIN t.origem o JOIN t.destino d "
			+ "WHERE o.codigo = :origem AND d.codigo = :destino")
	double findByOrigemAndDestino(
			@Param("origem") String origem, 
			@Param("destino") String destino);
}

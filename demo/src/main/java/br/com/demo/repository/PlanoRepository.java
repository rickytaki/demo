package br.com.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.demo.model.Plano;

@RepositoryRestResource(collectionResourceRel = "planos", path = "planos")
public interface PlanoRepository extends PagingAndSortingRepository<Plano, Long>{

}

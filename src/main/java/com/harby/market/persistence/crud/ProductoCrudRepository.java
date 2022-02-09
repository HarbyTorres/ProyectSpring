package com.harby.market.persistence.crud;

import java.util.List;

import com.harby.market.persistence.entity.Producto;

import org.springframework.data.repository.CrudRepository;

/**CrudRepository, PagingAndSortingRepository, JPARepository**/

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{ 

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

}

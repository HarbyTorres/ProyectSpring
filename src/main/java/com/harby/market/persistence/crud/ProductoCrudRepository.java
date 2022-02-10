package com.harby.market.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.harby.market.persistence.entity.Producto;

import org.springframework.data.repository.CrudRepository;

//repositorio Spring Data
/**CrudRepository, PagingAndSortingRepository, JPARepository**/

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{ 

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado( int cantidadStock, boolean estado);

    Optional<List<Producto>> findByNombreContainingOrderByNombreAsc( String nombre); 

    List<Producto> findByEstado(boolean estado);

    List<Producto> findByPrecioVentaBetween (int min, int max);

}

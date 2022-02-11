package com.harby.market.persistence;

import java.util.List;
import java.util.Optional;

import com.harby.market.persistence.crud.ProductoCrudRepository;
import com.harby.market.persistence.entity.Producto;

import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getByStock (int cantidadStock){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
    }

    public Optional<List<Producto>> getByNombre (String nombre){
        return productoCrudRepository.findByNombreContainingOrderByNombreAsc(nombre);
    }
    
    public List<Producto> getByEstado (boolean estado){
        return productoCrudRepository.findByEstado(estado);
    }

    public Optional<Producto> getProducto (int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
    
}

package com.harby.market.persistence;

import java.util.List;
import java.util.Optional;

import com.harby.market.domain.Product;
import com.harby.market.domain.repository.ProductRepository;
import com.harby.market.persistence.crud.ProductoCrudRepository;
import com.harby.market.persistence.entity.Producto;
import com.harby.market.persistence.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository implements ProductRepository {

    //@Autowired Dependency injection controlled by spring
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos =(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(produ -> mapper.toProducts(produ));
    }

    @Override
    public Optional<List<Product>> getByName(String name) {
        return productoCrudRepository.findByNombreContainingOrderByNombreAsc(name).map(produ -> mapper.toProducts(produ));
    }

    @Override
    public List<Product> getByActive(boolean active) {
        return mapper.toProducts(productoCrudRepository.findByEstado(active));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(produ -> mapper.toProduct(produ));
    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(productoCrudRepository.save(mapper.toProducto(product)));
    }
    
}

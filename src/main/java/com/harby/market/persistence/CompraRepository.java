package com.harby.market.persistence;

import com.harby.market.domain.Purchase;
import com.harby.market.domain.repository.PurchaseRepository;
import com.harby.market.persistence.crud.CompraCrudRepository;
import com.harby.market.persistence.entity.Compra;
import com.harby.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    CompraCrudRepository compraCrudRepository;

    @Autowired
    PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        Optional<List<Compra>> compras = compraCrudRepository.findByIdCliente(clientId);
        return compras.map(compras1 -> purchaseMapper.toPurchases(compras1));
    }

    @Override
    public Optional<List<Purchase>> getByDate(LocalDateTime date) {
        Optional<List<Compra>> compras = compraCrudRepository.findByFecha(date);
        return compras.map(compras1 -> purchaseMapper.toPurchases(compras1));
    }

    @Override
    public Optional<List<Purchase>> getByState(String state) {
        Optional<List<Compra>> compras = compraCrudRepository.findByEstado(state);
        return compras.map(compras1 -> purchaseMapper.toPurchases(compras1));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra= purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        compraCrudRepository.save(compra);
        return purchaseMapper.toPurchase(compra);
    }
}

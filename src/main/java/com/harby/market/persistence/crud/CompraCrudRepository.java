package com.harby.market.persistence.crud;

import com.harby.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByFecha(LocalDateTime fecha);
    Optional<List<Compra>> findByEstado(String estado);
    Optional<List<Compra>> findByIdCliente(String idCliente);
}

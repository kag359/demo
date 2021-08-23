package com.example.demo.repository;

import com.example.demo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    public Pais findByNome(String nome);
    //List<Pais> findAllOrderByNomeAsc();
}

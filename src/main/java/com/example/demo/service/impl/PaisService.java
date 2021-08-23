package com.example.demo.service.impl;

import com.example.demo.model.Pais;

import java.util.List;

public interface PaisService {
    Pais salvarPais(Pais pais);
    List<Pais> getPaises();
    Pais getPaisId(long id);
    Pais modPais(Pais pais, String nome);
    void apagarPais(long id);
    List<Pais> ordenar();
}

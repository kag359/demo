package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Pais;
import com.example.demo.repository.PaisRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    private PaisRepository paisRepository;


    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public Pais salvarPais(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public List<Pais> getPaises() {
        return paisRepository.findAll();
    }

    @Override
    public Pais getPaisId(long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        if (pais.isPresent()){
            return pais.get();
        }else {
            throw new ResourceNotFoundException("Pais", "Id",id);
        }

        //ou
        //return paisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pais", "Id",id));
    }

    @Override
    public Pais modPais(Pais pais, String nome) {

        Pais existePais = paisRepository.findByNome(nome);
        if (existePais.equals(pais.getNome())) {

            existePais.setNome(pais.getNome());
            existePais.setArea(pais.getArea());
            existePais.setCapital(pais.getCapital());



            existePais.setRegiao(pais.getRegiao());
            existePais.setSubRegiao(pais.getSubRegiao());
            paisRepository.save(existePais);
        }else {
            throw new ResourceNotFoundException("Pais", "Nome",nome);
        }
        return existePais;

    }

    @Override
    public void apagarPais(long id) {
        //verificar se existe na base de dados
        paisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pais", "Id", id));
        paisRepository.deleteById(id);
    }

    @Override
    public List<Pais> ordenar() {
        return paisRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }
}

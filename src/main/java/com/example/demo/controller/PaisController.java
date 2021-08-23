package com.example.demo.controller;

import com.example.demo.model.Pais;
import com.example.demo.service.impl.PaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {
    private PaisService paisService;

    public PaisController(PaisService paisService){
        super();
        this.paisService=paisService;
    }

    //build criar pais rest api
    @PostMapping()
    public ResponseEntity<Pais> salvarPais(@RequestBody Pais pais){
        return new ResponseEntity<Pais>(paisService.salvarPais(pais), HttpStatus.CREATED);
    }

    //build get todos paises
    @GetMapping
    public List<Pais> getPaises(){
        return paisService.getPaises();
    }

    // Bonus build get pais por id rest api
    @GetMapping("{id}")
    public ResponseEntity<Pais> getPaisId(@PathVariable("id") long paisId){
        return new ResponseEntity<Pais>(paisService.getPaisId(paisId), HttpStatus.OK);
    }

    // update propriedades do pais pesquisa por nome
    @PutMapping("{nome}")
    public ResponseEntity<Pais> modPais(@PathVariable("nome") String nomePais, @RequestBody Pais pais){
        return new ResponseEntity<Pais>(paisService.modPais(pais, nomePais), HttpStatus.OK);
    }

    //apagar pais pesquisa por id
    @DeleteMapping("{id}")
    public ResponseEntity<String> apagarPais(@PathVariable("id") long idPais){
        paisService.apagarPais(idPais);
        return new ResponseEntity<String>("Pais Apagado com sucesso", HttpStatus.OK);
    }

    //ordenar
    //@PutMapping("/ordenar")
    //public ResponseEntity<String> ordenar(){
      //  paisService.ordenar();
        //return new ResponseEntity<String>("Paises ordenados com sucesso", HttpStatus.OK);
    //}
    @GetMapping("/ordenar")
    public List<Pais> ordenar(){
        return paisService.ordenar();
    }



}

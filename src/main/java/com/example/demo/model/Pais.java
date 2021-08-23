package com.example.demo.model;


import javax.persistence.*;

@Entity(name = "Pais")
@Table(name = "pais",
        uniqueConstraints = {
                @UniqueConstraint(name = "pais_nome_unique", columnNames = "nome")
        })
public class Pais {

    @Id
    @SequenceGenerator(
            name = "pais_sequence",
            sequenceName = "pais_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pais_sequence"
    )
    @Column(name = "id",
            updatable = false)
    private long id;

    @Column(name = "nome",
            columnDefinition = "TEXT",
            nullable = false)
    private String nome;

    @Column(name = "capital",
            columnDefinition = "TEXT",
            nullable = false)
    private String capital;

    @Column(name = "regiao",
            columnDefinition = "TEXT",
            nullable = false)
    private String regiao;

    @Column(name = "subRegiao",
            columnDefinition = "TEXT",
            nullable = false)
    private String subRegiao;

    @Column(name = "area",
            columnDefinition = "TEXT",
            nullable = false)
    private String area;

    public Pais(String nome, String capital, String regiao, String subRegiao, String area) {
        this.nome = nome;
        this.capital = capital;
        this.regiao = regiao;
        this.subRegiao = subRegiao;
        this.area = area;
    }

    public Pais() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSubRegiao() {
        return subRegiao;
    }

    public void setSubRegiao(String subRegiao) {
        this.subRegiao = subRegiao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", capital='" + capital + '\'' +
                ", regiao='" + regiao + '\'' +
                ", subRegiao='" + subRegiao + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}







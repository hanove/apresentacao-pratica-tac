package com.example.infrastructure;


import jakarta.persistence.*;

@Entity
@Table(name = "atuadores")
public class Atuador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private boolean status;

    public Atuador() {
    }

    public Atuador(Long id, String nome, boolean status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Atuador(String nome, boolean status) {
        this.nome = nome;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

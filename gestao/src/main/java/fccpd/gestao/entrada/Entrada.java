package fccpd.gestao.entrada;

import fccpd.gestao.usuario.Usuario;

import java.time.LocalDate;

public class Entrada {
    private int id;
    private int valor;
    private String descricao;
    private LocalDate data;
    public Usuario usuario;


    public Entrada(int id, int valor, String descricao, LocalDate data, Usuario usuario) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

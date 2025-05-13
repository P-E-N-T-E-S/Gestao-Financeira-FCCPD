package fccpd.gestao.transferencia;

import fccpd.gestao.categoria.Categoria;
import fccpd.gestao.usuario.Usuario;

import java.time.LocalDate;

public class Transferencia {
    private int id;
    private double valor;
    private String descricao;
    private LocalDate data;
    public Usuario usuario;
    public boolean recebimento;
    public Categoria categoria;


    public Transferencia(int id, Double valor, String descricao, LocalDate data, Usuario usuario, boolean recebimento, Categoria categoria) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.usuario = usuario;
        this.recebimento = recebimento;
        this.categoria = categoria;
    }

    public Transferencia(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
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

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isRecebimento() {
        return recebimento;
    }

    public void setRecebimento(boolean recebimento) {
        this.recebimento = recebimento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "id=" + id +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", usuario=" + usuario.getUsername() +
                ", recebimento=" + recebimento +
                ", categoria=" + categoria.getTitulo() +
                '}';
    }
}

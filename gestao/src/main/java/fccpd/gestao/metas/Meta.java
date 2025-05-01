package fccpd.gestao.metas;

public class Meta {
    private int id;
    private String titulo;
    private String descricao;
    private double valor;
    private int usuarioId;

    public Meta(int id, String titulo, String descricao, double valor, int usuarioId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}

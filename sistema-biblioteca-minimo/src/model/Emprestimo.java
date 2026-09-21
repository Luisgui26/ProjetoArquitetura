package model;

public class Emprestimo {
    private int id;
    private String descricao;

    public Emprestimo(int id, String descricao) { this.id = id; this.descricao = descricao; }
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}

package com.example.aluno.atividade04_04;

/**
 * Created by aluno on 28/03/18.
 */

public class Contato {
    private long id;
    private String nome;
    private String telefone;
    private int imagem;

    public Contato(long id, String nome, String telefone,
                   int imagem) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.imagem = imagem;
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

    public String getCidade() {
        return telefone;
    }

    public void setCidade(String cidade) {
        this.telefone = cidade;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}

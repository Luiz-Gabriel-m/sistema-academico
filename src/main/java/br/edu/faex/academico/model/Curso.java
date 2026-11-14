package br.edu.faex.academico.model;

public class Curso {
    private Long id;
    private String nome;
    private String modalidade;

    // Construtor vazio
    public Curso() {
    }

    // Construtor para cadastrar (sem ID)
    public Curso(String nome, String modalidade) {
        this.nome = nome;
        this.modalidade = modalidade;
    }

    // Construtor completo (usado pelo Repository ao listar)
    public Curso(Long id, String nome, String modalidade) {
        this.id = id;
        this.nome = nome;
        this.modalidade = modalidade;
    }

    // Getters e Setters com o "this." corrigido
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
        this.nome = nome; // O "this.nome" garante que vai salvar na variável da classe
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade; // O "this.modalidade" garante que vai salvar na variável
    }
}
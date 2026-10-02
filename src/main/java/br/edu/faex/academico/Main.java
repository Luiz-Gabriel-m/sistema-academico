package br.edu.faex.academico;

import br.edu.faex.academico.controller.AlunoController;
import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.repository.AlunoRepository;
import br.edu.faex.academico.service.AlunoService;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Aleandro Ribeiro de Lima", "aleandro.lima@faex.edu.br");
        Aluno aluno2 = new Aluno("Maria Helena de Lima", "maria.lima@faex.edu.br");

        AlunoRepository alunoRepository = new AlunoRepository();
        AlunoService alunoService = new AlunoService(alunoRepository);
        AlunoController alunoController = new AlunoController(alunoService);

        // Cadastrar
        alunoController.cadastrar(aluno1);
        alunoController.cadastrar(aluno2);

        // Listar
        System.out.println("----- ALUNOS CADASTRADOS -----");
        for (Aluno aluno : alunoController.listar()) {
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
            System.out.println("Ativo: " + aluno.isAtivo());
            System.out.println("-----------------------------");
        }

        // Buscar por ID
        Aluno aluno = alunoController.buscarPorId(2L);
        if (aluno != null) {
            System.out.println("Aluno encontrado!");
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
        } else {
            System.out.println("Aluno não encontrado.");
        }
        System.out.println("-----------------------------");

        // Atualizar
        Aluno alunoEditado = new Aluno("Maria Helena da Silva", "maria.silva@faex.edu.br");
        alunoEditado.setId(2L);
        alunoController.atualizar(alunoEditado);

        // Listar após atualização
        System.out.println("----- ALUNOS APÓS ATUALIZAÇÃO -----");
        for (Aluno alunoLista : alunoController.listar()) {
            System.out.println("ID: " + alunoLista.getId());
            System.out.println("Nome: " + alunoLista.getNome());
            System.out.println("E-mail: " + alunoLista.getEmail());
            System.out.println("-----------------------------");
        }

        // Excluir
        alunoController.excluir(2L);

        // Listar após exclusão
        System.out.println("----- ALUNOS APÓS EXCLUSÃO -----");
        for (Aluno alunoLista : alunoController.listar()) {
            System.out.println("ID: " + alunoLista.getId());
            System.out.println("Nome: " + alunoLista.getNome());
            System.out.println("E-mail: " + alunoLista.getEmail());
            System.out.println("-----------------------------");
        }
    }
}
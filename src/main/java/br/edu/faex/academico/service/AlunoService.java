package br.edu.faex.academico.service;

import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.repository.AlunoRepository;
import java.util.List;

public class AlunoService {

    private AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    // Método de validação PRIVADO reutilizável
    private boolean validar(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            System.out.println("O nome do aluno é obrigatório.");
            return false;
        }

        if (aluno.getEmail() == null || aluno.getEmail().trim().isEmpty()) {
            System.out.println("O e-mail do aluno é obrigatório.");
            return false;
        }

        if (!aluno.getEmail().contains("@")) {
            System.out.println("E-mail inválido.");
            return false;
        }

        return true;
    }

    public void cadastrar(Aluno aluno) {
        if (!validar(aluno)) {
            return;
        }
        repository.cadastrar(aluno);
    }

    public List<Aluno> listar() {
        return repository.listar();
    }

    public Aluno buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    // Excluir com verificação de existência
    public void excluir(Long id) {
        Aluno aluno = repository.buscarPorId(id);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        repository.excluir(id);
        System.out.println("Aluno excluído com sucesso.");
    }

    // Atualizar com verificação de existência e validação privada
    public void atualizar(Aluno alunoEditado) {
        Aluno aluno = repository.buscarPorId(alunoEditado.getId());

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if (!validar(alunoEditado)) {
            return;
        }

        repository.atualizar(alunoEditado);
        System.out.println("Aluno atualizado com sucesso.");
    }
}
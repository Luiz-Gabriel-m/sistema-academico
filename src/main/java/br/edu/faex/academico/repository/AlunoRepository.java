package br.edu.faex.academico.repository;

import br.edu.faex.academico.model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    private List<Aluno> alunos = new ArrayList<>();
    private Long proximoId = 1L;

    public void cadastrar(Aluno aluno) {
        aluno.setId(proximoId++);
        alunos.add(aluno);
    }

    public List<Aluno> listar() {
        return alunos;
    }

    public Aluno buscarPorId(Long id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() != null && aluno.getId().equals(id)) {
                return aluno;
            }
        }
        return null;
    }

    // 1- Excluir do Repository
    public void excluir(Long id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() != null && aluno.getId().equals(id)) {
                alunos.remove(aluno);
                return; // Encerra após encontrar e remover
            }
        }
    }

    // 2- Atualizar do Repository
    public void atualizar(Aluno alunoEditado) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() != null && aluno.getId().equals(alunoEditado.getId())) {
                aluno.setNome(alunoEditado.getNome());
                aluno.setEmail(alunoEditado.getEmail());
                return; // Encerra após atualizar
            }
        }
    }
}
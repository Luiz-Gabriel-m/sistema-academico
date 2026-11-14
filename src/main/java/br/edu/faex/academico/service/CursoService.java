package br.edu.faex.academico.service;

import br.edu.faex.academico.model.Curso;
import br.edu.faex.academico.repository.CursoRepository;

import java.util.List;

public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void cadastrar(Curso curso) {
        if (curso.getNome() == null || curso.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do curso não pode ser vazio.");
        }
        cursoRepository.salvar(curso);
    }

    public List<Curso> listar() {
        return cursoRepository.listar();
    }

    public void excluir(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID de curso inválido.");
        }
        cursoRepository.excluir(id);
    }
}

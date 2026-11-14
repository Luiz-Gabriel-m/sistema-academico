package br.edu.faex.academico.service;

import br.edu.faex.academico.model.Professor;
import br.edu.faex.academico.repository.ProfessorRepository;

import java.util.List;

public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void cadastrar(Professor professor) {
        if (professor.getNome() == null || professor.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do professor não pode ser vazio.");
        }
        if (professor.getEmail() == null || !professor.getEmail().contains("@")) {
            throw new IllegalArgumentException("E-mail do professor inválido.");
        }
        professorRepository.salvar(professor);
    }

    public List<Professor> listar() {
        return professorRepository.listar();
    }

    public void excluir(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID de professor inválido.");
        }
        professorRepository.excluir(id);
    }
}

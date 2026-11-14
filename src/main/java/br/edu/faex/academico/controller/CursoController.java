package br.edu.faex.academico.controller;

import br.edu.faex.academico.model.Curso;
import br.edu.faex.academico.service.CursoService;

import java.util.List;

public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    public void cadastrar(Curso curso) {
        cursoService.cadastrar(curso);
    }

    public List<Curso> listar() {
        return cursoService.listar();
    }

    public void excluir(Long id) {
        cursoService.excluir(id);
    }
}

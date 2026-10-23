package br.edu.faex.academico;

import br.edu.faex.academico.Config.Conexão;
import br.edu.faex.academico.controller.AlunoController;
import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.repository.AlunoRepository;
import br.edu.faex.academico.service.AlunoService;

import java.sql.Connection;

public class Main {
    static void main() {

        Aluno a1 = new Aluno();
        a1.getNome();

        try (Connection con = Conexão.conectar()){
            System.out.println("Conectando");
        } catch (Exception e){
            System.out.println("Erro ao conectar");
            System.out.println(e.getMessage());
        }
    }
}

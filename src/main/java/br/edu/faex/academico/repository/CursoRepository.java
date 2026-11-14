package br.edu.faex.academico.repository;

import br.edu.faex.academico.config.Conexao;
import br.edu.faex.academico.model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {

    public void salvar(Curso curso) {
        String sql = "INSERT INTO cursos (nome, modalidade) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getModalidade());
            stmt.executeUpdate();

            // Pega o ID gerado pelo AUTO_INCREMENT do MySQL
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                curso.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar curso: " + e.getMessage(), e);
        }
    }

    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM cursos";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getLong("id"), // <-- Confira se a coluna no banco chama "id"
                        rs.getString("nome"),
                        rs.getString("modalidade")
                );
                cursos.add(curso);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar cursos: " + e.getMessage(), e);
        }
        return cursos;
    }

    public void excluir(Long id) {
        String sql = "DELETE FROM cursos WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir curso: " + e.getMessage(), e);
        }
    }
}

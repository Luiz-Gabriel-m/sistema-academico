package br.edu.faex.academico.repository;

import br.edu.faex.academico.config.Conexao;
import br.edu.faex.academico.model.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {

    public void salvar(Professor professor) {
        String sql = "INSERT INTO professores (nome, email) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.executeUpdate();

            // Pega o ID gerado pelo AUTO_INCREMENT do MySQL
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                professor.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar professor: " + e.getMessage(), e);
        }
    }

    public List<Professor> listar() {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professores";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Professor professor = new Professor(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
                professores.add(professor);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar professores: " + e.getMessage(), e);
        }
        return professores;
    }

    public void excluir(Long id) {
        String sql = "DELETE FROM professores WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir professor: " + e.getMessage(), e);
        }
    }
}
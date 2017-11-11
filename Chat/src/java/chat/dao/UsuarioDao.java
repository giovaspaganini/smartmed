package chat.dao;

import chat.dao.model.Sessaochat;
import java.sql.Connection;
import chat.dao.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDao {

    private Connection connection;

    public UsuarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Usuario buscar(Usuario usuario) {
        try {
            String sql = "";
            boolean possuiId = usuario.id > 0;
            if (possuiId) {
                sql = "select * from usuario where id = " + usuario.id;
            } else if (!usuario.login.isEmpty()) {
                sql = "select * from usuario where login = '" + usuario.login + "'";
            }

            PreparedStatement stmt = connection.prepareStatement(sql);
            Statement stm = (Statement) this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            Usuario usuarioEncontrado = new Usuario();
            if (rs.next()) {
                usuarioEncontrado.id = rs.getInt("id");
                usuarioEncontrado.login = rs.getString("login");
                usuarioEncontrado.senha = rs.getString("senha");
                usuarioEncontrado.isAluno = rs.getBoolean("usuario_aluno");
                usuarioEncontrado.isTutor = rs.getBoolean("usuario_tutor");
                usuarioEncontrado.nome = rs.getString("nome");
            }

            sql = "select sessaochat.id id_sessaochat, sessaochat.objetivo, sessaochat.dh_inicio, sessaochat.dh_fim, curso.nome nome_curso "
                    + "  from usuario_sessaochat, sessaochat, curso "
                    + " where usuario_sessaochat.id_usuario = " + usuarioEncontrado.id
                    + "   and usuario_sessaochat.id_sessaochat = sessaochat.id "
                    + "   and sessaochat.id_curso = curso.id "
                    + "   and curso.status = 'ATIVO' ";

            Statement stm2 = (Statement) this.connection.createStatement();
            ResultSet rs2 = stm2.executeQuery(sql);

            while (rs2.next()) {
                Sessaochat sc = new Sessaochat();
                sc.id = rs2.getInt("id_sessaochat");
                sc.objetivo = rs2.getString("objetivo");
                sc.cursoRelacionado = rs2.getString("nome_curso");
                usuarioEncontrado.sessoesDisponiveis.add(sc);
            }

            stmt.close();
            stm.close();
            stm2.close();
            return usuarioEncontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

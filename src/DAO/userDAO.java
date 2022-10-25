package DAO;

import BEAN.userBEAN;
import ConexaoDB.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class userDAO {

    Connection conn = Conexao.getConnection();
    ResultSet rs = null;
    PreparedStatement stm = null;

    public int getMax() {
        int id = 0;
        String sql = "SELECT max(id) from users";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return id + 1;
    }

    public void create(userBEAN u) {

        String sql = "INSERT INTO users (nome) VALUES (?)";
        
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, u.getNome());

            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "User criado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao guardar: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void delete(userBEAN u) {
        
        String sql = "DELETE FROM users WHERE id = ?";
        
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, u.getIDusers());

            stm.execute();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public List<userBEAN> leitura() {

        List<userBEAN> users = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY ID";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                userBEAN u = new userBEAN();

                u.setIDusers(rs.getInt("id"));
                u.setNome(rs.getString("nome"));

                users.add(u);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na leitura: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }

    public List<userBEAN> pesquisa(String nome) {

        List<userBEAN> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE nome LIKE ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + nome + "%");
            rs = stm.executeQuery();

            while (rs.next()) {
                userBEAN u = new userBEAN();

                u.setIDusers(rs.getInt("id"));
                u.setNome(rs.getString("nome"));

                users.add(u);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa: " +erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }
}

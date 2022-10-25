package DAO;

import ConexaoDB.Conexao;
import java.sql.*;
import BEAN.anexo;
import BEAN.historicoBEAN;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class anexoDAO {

    Connection conn = Conexao.getConnection();
    PreparedStatement stm = null;
    ResultSet rs = null;

    public void create(anexo anx) {

        String sql = "INSERT INTO anexos (anexo, nome_anx, data, id_historico) VALUES (?, ?, ?, ?)";

        try {
            stm = conn.prepareStatement(sql);

            stm.setString(1, anx.getAnexo());
            stm.setString(2, anx.getNomeAnx());
            stm.setString(3, anx.getData());
            stm.setInt(4, anx.getId_historico().getIdhistorico());

            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Anexo guardado!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro guardar anexo: " + erro);
        }
    }
    
    public void delete(anexo anx) {
        
        String sql = "DELETE FROM anexos WHERE idanexos = ?";
        
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, anx.getIdAnexo());
            
            stm.execute();
            JOptionPane.showMessageDialog(null, "Anexo apagado!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro Apagar Anexo: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public List<anexo> leitura() {

        List<anexo> anexos = new ArrayList<>();
        String sql = "SELECT * FROM anexos";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                anexo anx = new anexo();

                anx.setIdAnexo(rs.getInt("idanexos"));
                anx.setNomeAnx(rs.getString("nome_anx"));
                anx.setData(rs.getString("data"));

                historicoBEAN hist = new historicoBEAN();
                hist.setIdhistorico(rs.getInt("id_historico"));

                anx.setId_historico(hist);
                anexos.add(anx);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro Leitura Anexos: " + erro);
        }
        return anexos;
    }

    public List<anexo> pesquisa(Object histID) {

        List<anexo> anxs = new ArrayList<>();
        String sql = """
                     SELECT anx.idanexos, anx.nome_anx, anx.data, hist.id_historico
                     FROM anexos anx
                     INNER JOIN historico hist ON (anx.id_historico = hist.id_historico)
                     WHERE anx.id_historico LIKE ?
                     """;
        
        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, histID);
            
            rs = stm.executeQuery();
            
            while (rs.next()) {                
                anexo anx = new anexo();
                
                anx.setIdAnexo(rs.getInt("idanexos"));
                anx.setNomeAnx(rs.getString("nome_anx"));
                anx.setData(rs.getString("data"));
                
                historicoBEAN hist = new historicoBEAN();
                hist.setIdhistorico(rs.getInt("id_historico"));
                
                anx.setId_historico(hist);
                anxs.add(anx);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro Pesquisa Anexos: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return anxs;
    }
}

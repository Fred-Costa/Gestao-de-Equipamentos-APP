package DAO;

import BEAN.documento;
import BEAN.equipamentoBEAN;
import ConexaoDB.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class documentoDAO {
    
    Connection conn = Conexao.getConnection();
    PreparedStatement stm = null;
    ResultSet rs = null;
    
    public void create(documento doc) {
        
        String sql = "INSERT INTO documentos VALUES (?, ?, ?, ?, ?)";
        
        try {
            stm = conn.prepareStatement(sql);
            
            stm.setInt(1, doc.getIdDoc());
            stm.setString(2, doc.getDoc());
            stm.setString(3, doc.getNomeDoc());
            stm.setString(4, doc.getData());
            stm.setInt(5, doc.getEquipamento().getIDequipamento());
            
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Documento guardado!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Documento: " +erro);
        }
    }
    
    public void delete(documento doc) {
        
        String sql = "DELETE FROM documentos WHERE iddocumentos = ?";
        
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, doc.getIdDoc());
            
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Documento apagado!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar documento: " +erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public List <documento> leitura() {
        
        List<documento> docs = new ArrayList<>();
        String sql = "SELECT * FROM documentos";
        
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while (rs.next()) {                
                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setIDequipamento(rs.getInt("id_equipamento"));
                
                documento doc = new documento();
                doc.setIdDoc(rs.getInt("iddocumentos"));
                doc.setDoc(rs.getString("doc"));
                doc.setNomeDoc(rs.getString("nome_doc"));
                doc.setData(rs.getString("data"));
                
                doc.setEquipamento(equip);
                docs.add(doc);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro leitura docs: " +erro);
        }
        return docs;
    }
    
    public List<documento> pesquisa(Object equipamentoID) {
        
        List<documento> docs = new ArrayList<>();
        String sql;
        sql = """
              SELECT d.iddocumentos, d.nome_doc, d.data, equip.idequipamento
              FROM documentos d
              INNER JOIN equipamento equip ON (d.id_equipamento = equip.idequipamento)
              WHERE d.id_equipamento LIKE ?
              """;
        
        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamentoID);
            
            rs = stm.executeQuery();
            
            while (rs.next()) {                
                documento doc = new documento();
                
                doc.setIdDoc(rs.getInt("iddocumentos"));
                doc.setNomeDoc(rs.getString("nome_doc"));
                doc.setData(rs.getString("data"));
                
                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setIDequipamento(rs.getInt("idequipamento"));
                
                doc.setEquipamento(equip);
                docs.add(doc);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro PesquisaDocumentos: "+erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return docs;
    }

}

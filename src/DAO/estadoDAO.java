package DAO;

import BEAN.estadoBEAN;
import ConexaoDB.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class estadoDAO {
    
    Connection conn = Conexao.getConnection();
    ResultSet rs = null;
    PreparedStatement stm = null;
    
    
    // Ver e colocar o ultimo ID disponivel
    public int getMax() {
        int id = 0;
        String sql = "SELECT max(idestado) FROM estado";
        
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while (rs.next()) {                
                id = rs.getInt(1);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " +erro);
        }
        return id + 1;
    }
    
   // Função Criar
   public void create(estadoBEAN estd) {
       
       String sql = "INSERT INTO estado (estado) VALUES (?)";
       
       try {
           stm = conn.prepareStatement(sql);
           stm.setString(1, estd.getEstado());
           
           stm.executeUpdate();
           JOptionPane.showMessageDialog(null, "Estado guardado com sucesso!");
           
       } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null, "Erro ao guardar: " +erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
       }
   }
   
   // Função Apagar
    public void delete(estadoBEAN estd) {
        
        String sql = "DELETE FROM estado WHERE idestado = ?";
        
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, estd.getIDestado());
            
            stm.execute();
            JOptionPane.showMessageDialog(null, "Eliminado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao eliminar: " +erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Função que lê os estados
    public List<estadoBEAN> leitura() {
        
        List<estadoBEAN> estados = new ArrayList<>();
        String sql = "SELECT * FROM estado";
        
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while (rs.next()) {
                estadoBEAN estd = new estadoBEAN();
                
                estd.setIDestado(rs.getInt("idestado"));
                estd.setEstado(rs.getString("estado"));
                
                estados.add(estd);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na leitura: " +erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return estados;
    }
}

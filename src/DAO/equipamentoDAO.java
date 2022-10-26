package DAO;

import BEAN.equipamentoBEAN;
import ConexaoDB.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class equipamentoDAO {

    Connection conn = Conexao.getConnection();
    PreparedStatement stm = null;
    ResultSet rs = null;

    // Função para dar o max ID 
    public int getMax() {
        int id = 0;
        String sql = "SELECT max(idequipamento) from equipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        return id + 1;
    }

    public void create(equipamentoBEAN equip) {

        String sql = "INSERT INTO equipamento (entrada, equipamento, marca, modelo, numSerie, datAquisi) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, equip.getEntrada());
            stm.setString(2, equip.getEquipamento());
            stm.setString(3, equip.getMarca());
            stm.setString(4, equip.getModelo());
            stm.setString(5, equip.getNumSerie());
            stm.setString(6, equip.getDatAquisi());

            stm.execute();
            JOptionPane.showMessageDialog(null, "Equipamento guardado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao guardar: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void delete(equipamentoBEAN equip) {

        String sql = "DELETE FROM equipamento WHERE idequipamento = ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, equip.getIDequipamento());

            stm.execute();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public List<equipamentoBEAN> leitura() {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM equipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na leitura: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisaData(Object data1, Object data2) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM equipamento WHERE datAquisi BETWEEN ? AND ? ORDER BY datAquisi";

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, data1);
            stm.setObject(2, data2);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro pesquisaData: " + erro);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisaSimplesEquipamento(Object equipamento) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT idequipamento, equipamento, marca, modelo, numSerie, datAquisi FROM equipamento WHERE equipamento LIKE ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa: " + erro, "AVISO", JOptionPane.WARNING_MESSAGE);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisaSimplesMarca(Object marca) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT idequipamento, equipamento, marca, modelo, numSerie, datAquisi FROM equipamento WHERE marca LIKE ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, marca);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa: " + erro, "AVISO", JOptionPane.WARNING_MESSAGE);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisaSimplesModelo(Object modelo) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM equipamento WHERE modelo LIKE ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, modelo);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaSimplesModelo: " + erro);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisaSimplesNumSerie(Object numSerie) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT idequipamento, equipamento, marca, modelo, numSerie, datAquisi FROM equipamento WHERE numSerie LIKE ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, numSerie);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa: " + erro, "AVISO", JOptionPane.WARNING_MESSAGE);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisaDataEquipamento(Object equipamento, Object data1, Object data2) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM equipamento WHERE equipamento LIKE ? AND datAquisi BETWEEN ? AND ? ORDER BY datAquisi";

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);
            stm.setObject(2, data1);
            stm.setObject(3, data2);

            rs = stm.executeQuery();

            while (rs.next()) {

                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro pesquisa DataEquipamento: " + erro);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisa1(Object equipamento, Object marca, Object modelo) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT idequipamento, equipamento, marca, modelo, numSerie, datAquisi FROM equipamento WHERE equipamento LIKE ? AND marca LIKE ? AND modelo LIKE ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);
            stm.setObject(2, marca);
            stm.setObject(3, modelo);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa1: " + erro, "AVISO", JOptionPane.WARNING_MESSAGE);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisa2(Object equipamento, Object marca) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT idequipamento, equipamento, marca, modelo, numSerie, datAquisi FROM equipamento WHERE equipamento LIKE ? AND marca LIKE ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);
            stm.setObject(2, marca);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa1: " + erro, "AVISO", JOptionPane.WARNING_MESSAGE);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisa3(Object equipamento, Object numSerie) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT idequipamento, equipamento, marca, modelo, numSerie, datAquisi FROM equipamento WHERE equipamento LIKE ? AND numSerie LIKE ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);
            stm.setObject(2, numSerie);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa1: " + erro, "AVISO", JOptionPane.WARNING_MESSAGE);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisa4(Object equipamento, Object marca, Object data1, Object data2) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM equipamento WHERE equipamento LIKE ? AND marca LIKE ? AND datAquisi BETWEEN ? AND ?";

        try {

            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);
            stm.setObject(2, marca);
            stm.setObject(3, data1);
            stm.setObject(4, data2);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro Pesquisa4: " + erro);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisa5(Object equipamento, Object marca, Object modelo, Object data1, Object data2) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM equipamento WHERE equipamento LIKE ? AND marca LIKE ? AND modelo LIKE ? AND datAquisi BETWEEN ? AND ?";

        try {

            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);
            stm.setObject(2, marca);
            stm.setObject(3, modelo);
            stm.setObject(4, data1);
            stm.setObject(5, data2);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro Pesquisa5: " + erro);
        }
        return equipamentos;
    }

    public List<equipamentoBEAN> pesquisa6(Object equipamento, Object modelo) {

        List<equipamentoBEAN> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM equipamento WHERE equipamento LIKE ? AND modelo LIKE ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);
            stm.setObject(2, modelo);

            rs = stm.executeQuery();

            while (rs.next()) {
                equipamentoBEAN equip = new equipamentoBEAN();

                equip.setIDequipamento(rs.getInt("idequipamento"));
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));
                equip.setDatAquisi(rs.getString("datAquisi"));

                equipamentos.add(equip);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro Pesquisa6: " + erro);
        }
        return equipamentos;
    }
}

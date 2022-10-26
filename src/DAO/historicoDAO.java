package DAO;

import BEAN.equipamentoBEAN;
import BEAN.estadoBEAN;
import BEAN.historicoBEAN;
import BEAN.userBEAN;
import ConexaoDB.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class historicoDAO {

    Connection conn = Conexao.getConnection();
    PreparedStatement stm = null;
    ResultSet rs = null;

    public int getMax() {
        int id = 0;
        String sql = "SELECT max(id_historico) from historico";

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

    public void create(historicoBEAN hist) {

        String sql = "INSERT INTO historico VALUES (?, ?, ?, ?, ?, ?)";

        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, hist.getIdhistorico());
            stm.setInt(2, hist.getUser().getIDusers());
            stm.setInt(3, hist.getEquipamento().getIDequipamento());
            stm.setInt(4, hist.getEstado().getIDestado());
            stm.setString(5, hist.getAvaria());
            stm.setString(6, hist.getData());

            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registo adicionado com sucesso!");
        } catch (SQLException erro) {
            System.out.println("Erro no registo: " + erro);
        }
    }

    public List<historicoBEAN> leitura() {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                     select h.id_historico,u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                     from historico h 
                     inner join users u on u.id = h.id_user
                     inner JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                     inner JOIN estado estd on estd.idestado = h.id_estado
                     ORDER BY h.id_historico;
                     """;

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                historicoBEAN hist = new historicoBEAN();
                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                hist.setEquipamento(equip);
                hist.setUser(u);
                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na leitura: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }

    public void delete(historicoBEAN hist) {

        String sql = "DELETE FROM historico where id_historico = ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, hist.getIdhistorico());

            stm.execute();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Apagar registo: " + erro, "AVISO", JOptionPane.WARNING_MESSAGE);
        }

    }

    public List<historicoBEAN> pesquisaSimplesUser(Object user) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE u.nome LIKE ? 
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, user);

            rs = stm.executeQuery();

            while (rs.next()) {
                
                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                historicoBEAN hist = new historicoBEAN();
                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                hist.setEquipamento(equip);
                hist.setUser(u);
                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaSimplesUser: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }

    public List<historicoBEAN> pesquisaSimplesEquip(Object equipamento) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                     SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                     from historico h 
                     INNER JOIN users u ON h.id_user = u.id
                     INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                     INNER JOIN estado estd on estd.idestado = h.id_estado
                     WHERE equip.equipamento LIKE ?
                     ORDER BY h.id_historico
                     """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, "%" + equipamento + "%");

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaSimplesEquipamento: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }

    public List<historicoBEAN> pesquisaSimplesMarca(Object marca) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                     SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                     from historico h 
                     INNER JOIN users u ON h.id_user = u.id
                     INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                     INNER JOIN estado estd on estd.idestado = h.id_estado
                     WHERE equip.marca LIKE ? 
                     ORDER BY h.id_historico
                     """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, "%" + marca + "%");

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaSimplesMarca: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }

    public List<historicoBEAN> pesquisaSimplesModelo(Object modelo) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                     SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                     from historico h 
                     INNER JOIN users u ON h.id_user = u.id
                     INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                     INNER JOIN estado estd on estd.idestado = h.id_estado
                     WHERE equip.modelo LIKE ? 
                     ORDER BY h.id_historico
                     """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, "%" + modelo + "%");

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaSimplesModelo: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }

    public List<historicoBEAN> pesquisaSimplesNumSerie(Object numSerie) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                     SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                     from historico h 
                     INNER JOIN users u ON h.id_user = u.id
                     INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                     INNER JOIN estado estd on estd.idestado = h.id_estado
                     WHERE equip.numSerie LIKE ? 
                     ORDER BY h.id_historico
                     """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, numSerie);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaSimplesNumSerie: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }

    public List<historicoBEAN> pesquisaSimplesEstado(Object estado) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                     SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                     from historico h 
                     INNER JOIN users u ON h.id_user = u.id
                     INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                     INNER JOIN estado estd on estd.idestado = h.id_estado
                     WHERE estd.estado LIKE ? 
                     ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, estado);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaSimplesEstado: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    public List<historicoBEAN> pesquisaData(Object data1, Object data2) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                     SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data 
                     FROM historico h
                     INNER JOIN users u ON (h.id_user = u.id)
                     INNER JOIN equipamento equip ON (h.id_equipamento = equip.idequipamento)
                     INNER JOIN estado estd ON (h.id_estado = estd.idestado)
                     WHERE data BETWEEN ? AND ? ORDER BY data
                     """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, data1);
            stm.setObject(2, data2);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));
                
                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro pesquisaData: " + erro);
        }
        return historico;
    }

    public List<historicoBEAN> pesquisaComplementar1(Object user, Object estado) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE u.nome LIKE ? 
                    AND  estd.estado LIKE ? 
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, "%" + user + "%");
            stm.setObject(2, "%" + estado + "%");

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar1: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    public List<historicoBEAN> pesquisaComplementar2(Object user, Object data1, Object data2) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE u.nome LIKE ? 
                    AND data BETWEEN ? AND ? 
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, user);
            stm.setObject(2, data1);
            stm.setObject(3, data2);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar2: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    public List<historicoBEAN> pesquisaComplementar3(Object estado, Object data1, Object data2) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT *
                    FROM historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip ON h.id_equipamento = equip.idequipamento
                    INNER JOIN estado estd ON h.id_estado = estd.idestado
                    WHERE estd.estado LIKE ? 
                    AND data BETWEEN ? AND ? 
                    ORDER BY h.data
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, estado);
            stm.setObject(2, data1);
            stm.setObject(3, data2);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar3: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    public List<historicoBEAN> pesquisaComplementar4(Object equipamento, Object marca) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE equip.equipamento LIKE ? AND equip.marca LIKE ?
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);
            stm.setObject(2, marca);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar4: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    
    public List<historicoBEAN> pesquisaComplementar5(Object equipamento, Object marca, Object modelo) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE equip.equipamento LIKE ? 
                    AND equip.marca LIKE ?
                    AND equip.modelo LIKE ?
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);
            stm.setObject(2, marca);
            stm.setObject(3, modelo);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar5: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    public List<historicoBEAN> pesquisaComplementar6(Object equipamento, Object modelo) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE equip.equipamento LIKE ? AND equip.modelo LIKE ?
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, equipamento);
            stm.setObject(2, modelo);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar6: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    public List<historicoBEAN> pesquisaComplementar7(Object user, Object estado, Object data1, Object data2) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE u.nome LIKE ? 
                    AND estd.estado LIKE ?
                    AND data BETWEEN ? AND ? 
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, user);
            stm.setObject(2, estado);
            stm.setObject(3, data1);
            stm.setObject(4, data2);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar7: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    public List<historicoBEAN> pesquisaComplementar8(Object user, Object equipamento) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE u.nome LIKE ? 
                    AND equip.equipamento LIKE ?
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, user);
            stm.setObject(2, equipamento);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar8: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    public List<historicoBEAN> pesquisaComplementar9(Object user, Object equipamento, Object marca) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE u.nome LIKE ? 
                    AND equip.equipamento LIKE ?
                    AND equip.marca LIKE ?
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, user);
            stm.setObject(2, equipamento);
            stm.setObject(3, marca);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar8: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    public List<historicoBEAN> pesquisaComplementar10(Object user, Object equipamento, Object marca, Object modelo) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE u.nome LIKE ? 
                    AND equip.equipamento LIKE ?
                    AND equip.marca LIKE ?
                    AND equip.modelo LIKE ?
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, user);
            stm.setObject(2, equipamento);
            stm.setObject(3, marca);
            stm.setObject(4, modelo);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar8: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    public List<historicoBEAN> pesquisaComplementar11(Object user, Object numSerie) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE u.nome LIKE ? 
                    AND equip.numSerie LIKE ?
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, user);
            stm.setObject(2, numSerie);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar8: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
    
    
    public List<historicoBEAN> pesquisaComplementar12(Object user, Object equipamento, Object data1, Object data2) {

        List<historicoBEAN> historico = new ArrayList<>();
        String sql = """
                    SELECT h.id_historico, u.nome, equip.equipamento, equip.marca, equip.modelo, equip.numSerie,  estd.estado, h.avaria, h.data
                    from historico h 
                    INNER JOIN users u ON h.id_user = u.id
                    INNER JOIN equipamento equip on equip.idequipamento = h.id_equipamento
                    INNER JOIN estado estd on estd.idestado = h.id_estado
                    WHERE u.nome LIKE ? 
                    AND equip.equipamento LIKE ?
                    AND data BETWEEN ? AND ?
                    ORDER BY h.id_historico
                    """;

        try {
            stm = conn.prepareStatement(sql);
            stm.setObject(1, user);
            stm.setObject(2, equipamento);
            stm.setObject(3, data1);
            stm.setObject(4, data2);

            rs = stm.executeQuery();

            while (rs.next()) {
                historicoBEAN hist = new historicoBEAN();

                hist.setIdhistorico(rs.getInt("id_historico"));
                hist.setAvaria(rs.getString("avaria"));
                hist.setData(rs.getString("data"));

                userBEAN u = new userBEAN();
                u.setNome(rs.getString("nome"));

                hist.setUser(u);

                equipamentoBEAN equip = new equipamentoBEAN();
                equip.setEquipamento(rs.getString("equipamento"));
                equip.setMarca(rs.getString("marca"));
                equip.setModelo(rs.getString("modelo"));
                equip.setNumSerie(rs.getString("numSerie"));

                hist.setEquipamento(equip);

                estadoBEAN estd = new estadoBEAN();
                estd.setEstado(rs.getString("estado"));

                hist.setEstado(estd);

                historico.add(hist);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisaComplementar8: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        return historico;
    }
}

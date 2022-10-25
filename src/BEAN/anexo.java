package BEAN;

public class anexo {
    
    private int idAnexo;
    private String anexo;
    private String nomeAnx;
    private String data;
    private historicoBEAN id_historico;
    
    
    // CONSTRUTOR VAZIO
    public anexo() {
        
    } 
    
    
    // CONSTRUTOR COMPLETO
    public anexo(int idAnexo, String anexo, String nomeAnx, String data, historicoBEAN id_historico) {
        this.idAnexo = idAnexo;
        this.anexo = anexo;
        this.nomeAnx = nomeAnx;
        this.data = data;
        this.id_historico = id_historico;
    }

    public int getIdAnexo() {
        return idAnexo;
    }

    public void setIdAnexo(int idAnexo) {
        this.idAnexo = idAnexo;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getNomeAnx() {
        return nomeAnx;
    }

    public void setNomeAnx(String nomeAnx) {
        this.nomeAnx = nomeAnx;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public historicoBEAN getId_historico() {
        return id_historico;
    }

    public void setId_historico(historicoBEAN id_historico) {
        this.id_historico = id_historico;
    }
    
    
    
}

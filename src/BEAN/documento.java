package BEAN;

public class documento {

    private int idDoc;
    private String doc;
    private String nomeDoc;
    private String data;
    private equipamentoBEAN equipamento;

    // construtor vazio
    public documento() {

    }

    // construtor completox
    public documento(int idDoc, String doc, String nomeDoc, String data, equipamentoBEAN equipamento) {
        this.idDoc = idDoc;
        this.doc = doc;
        this.nomeDoc = nomeDoc;
        this.data = data;
        this.equipamento = equipamento;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNomeDoc() {
        return nomeDoc;
    }

    public void setNomeDoc(String nomeDoc) {
        this.nomeDoc = nomeDoc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public equipamentoBEAN getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(equipamentoBEAN equipamento) {
        this.equipamento = equipamento;
    }

}

package BEAN;

public class historicoBEAN {

    private int idhistorico;
    private userBEAN user;
    private equipamentoBEAN equipamento;
    private estadoBEAN estado;
    private String avaria;
    private String data;
    
    public historicoBEAN() {
    }
    
    public historicoBEAN(int idhistorico, userBEAN user, equipamentoBEAN equipamento, estadoBEAN estado, String avaria, String data) {
        this.idhistorico = idhistorico;
        this.user = user;
        this.equipamento = equipamento;
        this.estado = estado;
        this.avaria = avaria;
        this.data = data;
    }
    
    public int getIdhistorico() {
        return idhistorico;
    }

    public void setIdhistorico(int idhistorico) {
        this.idhistorico = idhistorico;
    }

    public userBEAN getUser() {
        return user;
    }

    public void setUser(userBEAN user) {
        this.user = user;
    }

    public equipamentoBEAN getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(equipamentoBEAN equipamento) {
        this.equipamento = equipamento;
    }

    public estadoBEAN getEstado() {
        return estado;
    }

    public void setEstado(estadoBEAN estado) {
        this.estado = estado;
    }

    public String getAvaria() {
        return avaria;
    }

    public void setAvaria(String avaria) {
        this.avaria = avaria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}

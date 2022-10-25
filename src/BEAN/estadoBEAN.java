package BEAN;

public class estadoBEAN {

    //Variáveis da tabela
    private int idestado;
    private String estado;

    //Construtor vazio
    public estadoBEAN() {
    }
    
    //Construtor
    public estadoBEAN(int idestado, String estado){
        this.idestado = idestado;
        this.estado = estado;
    }
    
// GET E SET
    // Método GET - lê atributos da classe e retorna um valor
    public int getIDestado() {
        return idestado;
    }

    public String getEstado() {
        return estado;
    }

    // Método SET - serve para introduzir, alterar ou modificar valores
    // atribuídos a uma classe de maneira protegida
    public void setIDestado(int idestado) {
        this.idestado = idestado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.getEstado();
    }

}

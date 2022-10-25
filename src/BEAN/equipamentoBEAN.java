package BEAN;

public class equipamentoBEAN {

    //Variáveis da tabela
    private int idequipamento;
    private int entrada;
    private String equipamento;
    private String marca;
    private String modelo;
    private String numSerie;
    private String datAquisi;

    
    //CONSTRUTOR SIMPLES
    public equipamentoBEAN(){
    }
    
    //CONSTRUTOR
    public equipamentoBEAN(int idequipamento, int entrada, String equipamento, String marca, String modelo, String numSerie, String datAquisi){
        this.idequipamento = idequipamento;
        this.entrada = entrada;
        this.equipamento = equipamento;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
        this.datAquisi = datAquisi;
    }
    
    
//GET E SET
    // Métodos GET - lê atributos da classe e retorna um valor
    public int getIDequipamento() {
        return idequipamento;
    }

    public int getEntrada() {
        return entrada;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public String getDatAquisi() {
        return datAquisi;
    }

    // Métodos de Set - serve para introduzir, alterar ou modificar valores
    // atribuídos a uma classe de maneira protegida
    public void setIDequipamento(int idequipamento) {
        this.idequipamento = idequipamento;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public void setDatAquisi(String datAquisi) {
        this.datAquisi = datAquisi;
    }

    @Override
    public String toString() {
        return equipamento;
    }
}

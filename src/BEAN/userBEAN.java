package BEAN;

public class userBEAN {

    // Variáveis da tabela
    private int idusers;
    private String nome;

    //Construtor vazio
    public userBEAN() {
    }
    
    //Construtor
    public userBEAN(int idusers, String nome){
        this.idusers = idusers;
        this.nome = nome;
    }
    
    
// GET E SET
    // Método GET - lê atributos da classe e retorna um valor 
    public int getIDusers() {
        return idusers;
    }

    public String getNome() {
        return nome;
    }

    // Método SET - serve para introduzir, alterar ou modificar valores 
    // atribuidos a uma classe de maneira protegida
    public void setIDusers(int idusers) {
        this.idusers = idusers;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
}

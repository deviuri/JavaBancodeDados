package modelo;

public class Produto {
    private Integer id;
    private String nome;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    @Override
    public String toString(){
        return String.format("O produto criado é: %d, %s, %s", this.id, this.nome, this.descricao);
    }
    public Produto(Integer id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}

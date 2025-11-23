package br.com.fiap.beans;

public class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String areaInteresse;
    private int horasSemanais;

    public Usuario() {}

    public Usuario(int id, String nome, int idade, String areaInteresse, int horasSemanais) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.areaInteresse = areaInteresse;
        this.horasSemanais = horasSemanais;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getAreaInteresse() { return areaInteresse; }
    public void setAreaInteresse(String areaInteresse) { this.areaInteresse = areaInteresse; }

    public int getHorasSemanais() { return horasSemanais; }
    public void setHorasSemanais(int horasSemanais) { this.horasSemanais = horasSemanais; }
}

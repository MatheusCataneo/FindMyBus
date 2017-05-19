package br.com.recuperacao.projetotcc1.modelo;


public class Cadastro {
    private int id;
    private String nome;
    private String sobrenome;
    private String data_nascimento;
    private String email;
    private String nome_usuario;
    private String senha_usuario;
    private String repetir_senha_usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public String getRepetir_senha_usuario() {
        return repetir_senha_usuario;
    }

    public void setRepetir_senha_usuario(String repetir_senha_usuario) {
        this.repetir_senha_usuario = repetir_senha_usuario;
    }
}



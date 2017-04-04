package br.com.recuperacao.projetotcc1.modelo;


public class Cadastro {
    private int id;
    private String nome;
    private String cpf;
    private String data_nascimento;
    private String numero_cartao;
    private String tipo_cartao;
    private String nome_usuario;
    private String senha_usuario;
    private String repetir_senha_usuario;

    public Cadastro(){

    }


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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public String getTipo_cartao() {
        return tipo_cartao;
    }

    public void setTipo_cartao(String tipo_cartao) {
        this.tipo_cartao = tipo_cartao;
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



package br.com.mito.model;

public class usuario {
    private int cpf;
    private String nome, prontuario, senha, email;
    private boolean isProfessor;

    public usuario(int cpf, String nome, String prontuario, String senha, String email, boolean isProfessor) {
        this.cpf = cpf;
        this.nome = nome;
        this.prontuario = prontuario;
        this.senha = senha;
        this.email = email;
        this.isProfessor = isProfessor;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsProfessor() {
        return isProfessor;
    }

    public void setIsProfessor(boolean isProfessor) {
        this.isProfessor = isProfessor;
    }
    
}

package model;

public class Usuario {
    private int codigo;
    private String cpf, nome, prontuario, senha, email;
    private boolean isProfessor, isCoordenador;

    public Usuario(String cpf, int codigo, String nome, String prontuario, String senha, String email, boolean isProfessor, boolean isCoordenador) {
        this.cpf = cpf;
        this.codigo = codigo;
        this.nome = nome;
        this.prontuario = prontuario;
        this.senha = senha;
        this.email = email;
        this.isProfessor = isProfessor;
        this.isCoordenador = isCoordenador;
    }
    
    public Usuario() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
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

    public boolean getIsProfessor() {
        return isProfessor;
    }

    public void setIsProfessor(boolean isProfessor) {
        this.isProfessor = isProfessor;
    }
    
    public boolean getIsCoordenador() {
        return isCoordenador;
    }

    public void setIsCoordenador(boolean isCoordenador) {
        this.isCoordenador = isCoordenador;
    }
    
}

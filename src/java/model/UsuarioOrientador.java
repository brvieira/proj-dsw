package model;

public class UsuarioOrientador {
    private String aluno, orientador;

    public UsuarioOrientador(String aluno, String orientador) {
        this.aluno = aluno;
        this.orientador = orientador;
    }
    
    public UsuarioOrientador() {}

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
    
    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }
}

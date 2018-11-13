package model;

public class UsuarioOrientador {
    private Usuario aluno, orientador;
    private boolean orientacaoAceita;
    
     public UsuarioOrientador() {
         
    }
     
    public UsuarioOrientador(Usuario aluno, Usuario orientador, boolean orientacaoAceita) {
        this.aluno = aluno;
        this.orientador = orientador;
        this.orientacaoAceita = orientacaoAceita;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    public Usuario getOrientador() {
        return orientador;
    }

    public void setOrientador(Usuario orientador) {
        this.orientador = orientador;
    }

    public boolean isOrientacaoAceita() {
        return orientacaoAceita;
    }

    public void setOrientacaoAceita(boolean orientacaoAceita) {
        this.orientacaoAceita = orientacaoAceita;
    }
        
}

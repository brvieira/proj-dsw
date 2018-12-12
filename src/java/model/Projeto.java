package model;

public class Projeto {
    private int codigo;
    private String nome, parecerProjeto, resultadoQualificacao;
    private Usuario aluno;
    private boolean projetoEnviadoColegiado, projetoEnviadoColegiadoConcordado, projetoRecebidoAnalise, versaoFinalEnviada, versaoFinalConfirmadaOrientador;

    public Projeto(int codigo, String nome, String parecerProjeto, String resultadoQualificacao, Usuario aluno, boolean projetoEnviadoColegiado, boolean projetoEnviadoColegiadoConcordado, boolean projetoRecebidoAnalise, boolean versaoFinalEnviada, boolean versaoFinalConfirmadaOrientador) {
        this.codigo = codigo;
        this.nome = nome;
        this.parecerProjeto = parecerProjeto;
        this.resultadoQualificacao = resultadoQualificacao;
        this.aluno = aluno;
        this.projetoEnviadoColegiado = projetoEnviadoColegiado;
        this.projetoEnviadoColegiadoConcordado = projetoEnviadoColegiadoConcordado;
        this.projetoRecebidoAnalise = projetoRecebidoAnalise;
        this.versaoFinalEnviada = versaoFinalEnviada;
        this.versaoFinalConfirmadaOrientador = versaoFinalConfirmadaOrientador;
    }
    
    public Projeto() {}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParecerProjeto() {
        return parecerProjeto;
    }

    public void setParecerProjeto(String parecerProjeto) {
        this.parecerProjeto = parecerProjeto;
    }

    public String getResultadoQualificacao() {
        return resultadoQualificacao;
    }

    public void setResultadoQualificacao(String resultadoQualificacao) {
        this.resultadoQualificacao = resultadoQualificacao;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    public boolean isProjetoEnviadoColegiado() {
        return projetoEnviadoColegiado;
    }

    public void setProjetoEnviadoColegiado(boolean projetoEnviadoColegiado) {
        this.projetoEnviadoColegiado = projetoEnviadoColegiado;
    }

    public boolean isProjetoEnviadoColegiadoConcordado() {
        return projetoEnviadoColegiadoConcordado;
    }

    public void setProjetoEnviadoColegiadoConcordado(boolean projetoEnviadoColegiadoConcordado) {
        this.projetoEnviadoColegiadoConcordado = projetoEnviadoColegiadoConcordado;
    }

    public boolean isProjetoRecebidoAnalise() {
        return projetoRecebidoAnalise;
    }

    public void setProjetoRecebidoAnalise(boolean projetoRecebidoAnalise) {
        this.projetoRecebidoAnalise = projetoRecebidoAnalise;
    }   

    public boolean isVersaoFinalEnviada() {
        return versaoFinalEnviada;
    }

    public void setVersaoFinalEnviada(boolean versaoFinalEnviada) {
        this.versaoFinalEnviada = versaoFinalEnviada;
    }

    public boolean isVersaoFinalConfirmadaOrientador() {
        return versaoFinalConfirmadaOrientador;
    }

    public void setVersaoFinalConfirmadaOrientador(boolean versaoFinalConfirmadaOrientador) {
        this.versaoFinalConfirmadaOrientador = versaoFinalConfirmadaOrientador;
    }
}
package model;

import java.util.Date;

public class Defesa {
    private int codigo;
    private Date dataMarcada;
    private boolean statusAgendamentoOrientando, statusAgendamentoCoordenador;
    private Usuario primeiroMembro, segundoMembro;
    private String resultadoDefesa, parecerBanca, consideracoesBanca;
    private Projeto projeto;
    
    public Defesa() {}

    public Defesa(int codigo, Date dataMarcada, boolean statusAgendamentoOrientando, boolean statusAgendamentoCoordenador, Usuario primeiroMembro, Usuario segundoMembro, String resultadoDefesa, String parecerBanca, String consideracoesBanca, Projeto projeto) {
        this.codigo = codigo;
        this.dataMarcada = dataMarcada;
        this.statusAgendamentoOrientando = statusAgendamentoOrientando;
        this.statusAgendamentoCoordenador = statusAgendamentoCoordenador;
        this.primeiroMembro = primeiroMembro;
        this.segundoMembro = segundoMembro;
        this.resultadoDefesa = resultadoDefesa;
        this.parecerBanca = parecerBanca;
        this.consideracoesBanca = consideracoesBanca;
        this.projeto = projeto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataMarcada() {
        return dataMarcada;
    }

    public void setDataMarcada(Date dataMarcada) {
        this.dataMarcada = dataMarcada;
    }

    public boolean isStatusAgendamentoOrientando() {
        return statusAgendamentoOrientando;
    }

    public void setStatusAgendamentoOrientando(boolean statusAgendamentoOrientando) {
        this.statusAgendamentoOrientando = statusAgendamentoOrientando;
    }

    public boolean isStatusAgendamentoCoordenador() {
        return statusAgendamentoCoordenador;
    }

    public void setStatusAgendamentoCoordenador(boolean statusAgendamentoCoordenador) {
        this.statusAgendamentoCoordenador = statusAgendamentoCoordenador;
    }

    public Usuario getPrimeiroMembro() {
        return primeiroMembro;
    }

    public void setPrimeiroMembro(Usuario primeiroMembro) {
        this.primeiroMembro = primeiroMembro;
    }

    public Usuario getSegundoMembro() {
        return segundoMembro;
    }

    public void setSegundoMembro(Usuario segundoMembro) {
        this.segundoMembro = segundoMembro;
    }

    public String getResultadoDefesa() {
        return resultadoDefesa;
    }

    public void setResultadoDefesa(String resultadoDefesa) {
        this.resultadoDefesa = resultadoDefesa;
    }

    public String getParecerBanca() {
        return parecerBanca;
    }

    public void setParecerBanca(String parecerBanca) {
        this.parecerBanca = parecerBanca;
    }

    public String getConsideracoesBanca() {
        return consideracoesBanca;
    }

    public void setConsideracoesBanca(String consideracoesBanca) {
        this.consideracoesBanca = consideracoesBanca;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    
}
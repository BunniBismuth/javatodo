package br.upe.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarefa {

    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataFinalizacao;
    private LocalDate dataVencimento;
    private Boolean finalizada;
    private int ordem;
    public Tarefa(String texto, String dataVencimento, int ordem) {
        this.dataCriacao = LocalDate.now();
        this.descricao = texto;
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("d/MM/yyyy");
        this.dataVencimento = LocalDate.parse(dataVencimento, formatoData);
        this.ordem = ordem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDate dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
}

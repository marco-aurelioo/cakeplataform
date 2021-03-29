package com.cake.entity.receita;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name ="IngredienteEstoque")
public class IngredienteEstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    private IngredienteEntity ingrediente;

    private String descricao;
    private Long quantidade;
    private BigDecimal valor;
    private UNIDADE unidade;

    public IngredienteEstoqueEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IngredienteEntity getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(IngredienteEntity ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public UNIDADE getUnidade() {
        return unidade;
    }

    public void setUnidade(UNIDADE unidade) {
        this.unidade = unidade;
    }
}



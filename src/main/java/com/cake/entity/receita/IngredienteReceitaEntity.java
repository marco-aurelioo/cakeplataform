package com.cake.entity.receita;

import javax.persistence.*;

@Entity
@Table(name ="ingredientes_receita")
public class IngredienteReceitaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    private IngredienteEntity ingrediente;

    private Long quantidade;
    private UNIDADE unidade;

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

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public UNIDADE getUnidade() {
        return unidade;
    }

    public void setUnidade(UNIDADE unidade) {
        this.unidade = unidade;
    }
}

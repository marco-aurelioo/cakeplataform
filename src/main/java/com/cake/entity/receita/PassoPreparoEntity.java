package com.cake.entity.receita;

import javax.persistence.*;

@Entity
@Table(name = "passo_preparo")
public class PassoPreparoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private Integer passo;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPasso() {
        return passo;
    }

    public void setPasso(Integer passo) {
        this.passo = passo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

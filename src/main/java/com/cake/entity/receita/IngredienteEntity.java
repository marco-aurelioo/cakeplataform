package com.cake.entity.receita;

import javax.persistence.*;

@Entity
@Table(name ="ingrediente")
public class IngredienteEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String descricao;
    private UNIDADE unidade;

    private boolean aprovadoPublico;
    private String identificadoPor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UNIDADE getUnidade() {
        return unidade;
    }

    public void setUnidade(UNIDADE unidade) {
        this.unidade = unidade;
    }

    public boolean isAprovadoPublico() {
        return aprovadoPublico;
    }

    public void setAprovadoPublico(boolean aprovadoPublico) {
        this.aprovadoPublico = aprovadoPublico;
    }

    public String getIdentificadoPor() {
        return identificadoPor;
    }

    public void setIdentificadoPor(String identificadoPor) {
        this.identificadoPor = identificadoPor;
    }
}

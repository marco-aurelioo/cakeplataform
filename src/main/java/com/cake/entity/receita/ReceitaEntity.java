package com.cake.entity.receita;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="receita")
public class ReceitaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String descricao;

    @OneToMany
    private List<IngredienteReceitaEntity> ingredietesReceita;

    @OneToMany
    private List<PassoPreparoEntity> passos;

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

    public List<IngredienteReceitaEntity> getIngredietesReceita() {
        return ingredietesReceita;
    }

    public void setIngredietesReceita(List<IngredienteReceitaEntity> ingredietesReceita) {
        this.ingredietesReceita = ingredietesReceita;
    }

    public List<PassoPreparoEntity> getPassos() {
        return passos;
    }

    public void setPassos(List<PassoPreparoEntity> passos) {
        this.passos = passos;
    }
}

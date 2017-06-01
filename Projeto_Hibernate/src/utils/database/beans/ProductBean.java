/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.database.beans;

import java.util.List;
import utils.beans.BaseBeans;

/**
 *
 * @author Izidio
 */
public class ProductBean extends BaseBeans {

    //UID
    private static final long serialVersionUID = -8052161569803621288L;

    private long id;
    private String nome;
    private String descricao;
    private Double preco;
    private CategoryBean category;
    private List<ProductBean> products;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the products
     */
    public List<ProductBean> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<ProductBean> products) {
        this.products = products;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the category
     */
    public CategoryBean getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(CategoryBean category) {
        this.category = category;
    }

}

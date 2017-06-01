package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Izidio Carvalho
 */
@Entity
@Table(name="User")
public class Usuario {
        public Usuario(Integer Id,String nome, Integer Salario){
        this.nome=nome;
        this.salario=Salario;
        this.id=Id;
    }
        public Usuario(String nome, Integer Salario){
        this.nome=nome;
        this.salario=Salario;
  
    }
        public Usuario(){
            
        }

    /**
     * @return the salario
     */
    public Integer getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
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
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Integer salario;
    
}

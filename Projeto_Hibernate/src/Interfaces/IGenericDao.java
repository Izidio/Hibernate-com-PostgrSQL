/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Izidio
 */
//  T - Diferentes entidades
//  ID exentends Serializable - ID muda de acordo com a entidade(pode ser ID, nome, chave composta, chave primaria)
// Interface com os metodos comuns a todos as entidades
public interface IGenericDao<T, ID extends Serializable> {
 
    T findByID(ID id); //consulta de acordo com o ID
    List<T> findALL(); // retorna todos o elementos da entidade
    ID save(T entity); // salvar a entidade
    void update(T entity); // atualizar a entidade
    void delete(T entity); // deletar a aentidade
}

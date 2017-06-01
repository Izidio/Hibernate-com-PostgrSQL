/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Interfaces.IGenericDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.jboss.logging.Logger;

/**
 *
 * @author Izidio
 */
//  T - Diferentes entidades
//  ID exentends Serializable - ID muda de acordo com a entidade(pode ser ID, nome, chave composta, chave primaria)
// Classe Abstrata com os metodos comuns a todos as entidades
public abstract class GenericDao<T, ID extends Serializable> implements IGenericDao<T, ID> {

    //usando o log4j
    private final Logger logger = Logger.getLogger(this.getClass());

    //Representa a classe(entidade) usada
    private final Class<T> persistentClass;

    private Session session;

    //construtor para inicializar o persistenceClass
    public GenericDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    //seta a sessao
    public void setSession(Session session) {
        this.session = session;
    }

    //retorna a sessao
    public Session getSession() {
        if (this.session == null) {
            this.logger.error("sessao nao encontrada.");
            throw new IllegalStateException("sessao nao foi setada no Dao.");
        }
        return this.session;
    }

    //caso nescessario, mudar o comportamento
    private Class<T> getPersistentClass() {
        return this.persistentClass;
    }

    // o argunto é um conjunto de criterios para buscar a iformacao de arcodo com o criterio
    private List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    @Override
    public T findByID(ID id) {
        //getSession retorna a sessao
        //load carrega a classe a ser buscada baseada no ID
        //getPeersistentClass -> criterio, classe, ENTIDADE... ira carregar de acordo com o ID
        //(T) -> retorna um objeto do tipo T, dentre todos os possiveis retornos 
        return (T) getSession().load(getPersistentClass(), id);
    }

    @Override
    public List<T> findALL() {
        //findByCriteria sem nenhum parametro de criterio, logo, retorna todos
        return findByCriteria();
    }

    @Override
    public ID save(T entity) {
        
        //implemeta o controle de transacao
        getSession().beginTransaction();

        //salva a entidade 
        //o banco auto gera o ID e retorna para ser tratado
        Serializable id = getSession().save(entity);
        //envia para o banco
        getSession().getTransaction().commit();

        //conversao do objeto serializavel para o ID
        return (ID) id;
    }

    @Override
    // entity -> o parametro carrega consigo o ID usado como chave
    public void update(T entity) {
        //implemeta o controle de transacao
        getSession().beginTransaction();
        //atualiza o banco baseado na entidade
        getSession().update(entity);
        getSession().getTransaction().commit();
    }

    @Override
 // entity -> o paremetro carrega consigo o ID usado como chave
    public void delete(T entity) {
        //implemeta o controle de transacao
        getSession().beginTransaction();
        //deleta do banco baseado na entidade
        getSession().delete(entity);
        getSession().getTransaction().commit();
    }

}

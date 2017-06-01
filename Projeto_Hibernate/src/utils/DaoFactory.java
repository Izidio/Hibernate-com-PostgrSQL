/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import DAO.CategoryDao;
import DAO.ProductDao;
import Interfaces.ICategoryDao;
import Interfaces.IDaoFactory;
import Interfaces.IProductDao;
import org.hibernate.Session;

/**
 *
 * @author Izidio
 */
public class DaoFactory implements IDaoFactory{
   
    //variaveis referente aos DAOS
    private final ICategoryDao categoryDao;  
    private final IProductDao productDao;

    //Instanciando a variavel de acordo com a classe concreta
    public DaoFactory() {
    this.categoryDao = (ICategoryDao) instatiate(CategoryDao.class);
    this.productDao=(IProductDao) instatiate(ProductDao.class);
    }

    @Override
    public ICategoryDao getCategoryDao() {
    return this.categoryDao;
    }

    @Override
    public IProductDao getProductDao() {
    return this.productDao;
    }

    //metodo seta a sessao correspondente ao dao
    private GenericDao<?,?> instatiate(Class<?> daoClass){
        try{
             //daoClass -> classe a ser instanciada
            GenericDao<?, ?> dao =(GenericDao<?,?>) daoClass.newInstance();
            // seta a sessao relacionada ao dao
            dao.setSession(getCurrenteSession());
            return dao;
             }catch(Exception e){
                 throw new RuntimeException(String.format("não pode intanciar DAO %s com o erro %s",daoClass,e.getMessage()),e);
             }
    }

    //sessao atual
    private Session getCurrenteSession() {
    return HibernateUtility.getSession();   
    }
}
 
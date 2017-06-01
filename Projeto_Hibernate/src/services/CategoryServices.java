/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Interfaces.ICategoryDao;
import Interfaces.IDaoFactory;
import java.util.List;
import utils.ParserDatabase;
import utils.database.beans.CategoryBean;
import utils.database.interfaces.ICategoryService;

/**
 *
 * @author Izidio
 */
public class CategoryServices implements ICategoryService{

    //passa o dao do servico para ser usado
    
    private final ICategoryDao categoryDao;
    //passa todos os daos para a classe de servicos
    //retorna apenas o dao de categoria
    
    public CategoryServices(IDaoFactory daoFactory){
        this.categoryDao=daoFactory.getCategoryDao();
    }
    @Override
    public CategoryBean findByID(Long id) {
        //transforma de entidade para bean
    return ParserDatabase.parserEntityToBean(this.categoryDao.findByID(id));
   }

    @Override
    public List<CategoryBean> findAllCategories() {
        return ParserDatabase.parseCategoryEntitiesToBeans(this.categoryDao.findALL());
     }

    @Override
    public Long insert(CategoryBean categoy) {
    return this.categoryDao.save(ParserDatabase.parserBeanToEntity(categoy));
    }

    @Override
    public void update(CategoryBean category) {
    this.categoryDao.update(ParserDatabase.parserBeanToEntity(category));
    }

    @Override
    public void delete(CategoryBean category) {
      this.categoryDao.delete(ParserDatabase.parserBeanToEntity(category));
    }
    
}

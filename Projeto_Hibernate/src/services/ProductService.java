/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Interfaces.IDaoFactory;
import Interfaces.IProductDao;
import java.util.List;
import utils.ParserDatabase;
import utils.database.beans.ProductBean;
import utils.database.interfaces.IProductService;

/**
 *
 * @author Izidio
 */
public class ProductService implements IProductService {

    //passa o dao do servico para ser usado
    private final IProductDao productDao;

    //passa todos os daos para a classe de servicos
    //retorna apenas o dao de produto
    public ProductService(IDaoFactory daoFactory) {
        this.productDao = daoFactory.getProductDao();
    }

    @Override
    public ProductBean findByID(Long id) {
        return ParserDatabase.parserEntityToBean(this.productDao.findByID(id));
    }

    @Override
    public List<ProductBean> findAllProducts() {
    return ParserDatabase.parseProductEntitiesToBeans(this.productDao.findALL());
    }

    @Override
    public Long insert(ProductBean product) {
    return this.productDao.save(ParserDatabase.parserBeanToEntity(product));
    }

    @Override
    public void update(ProductBean product) {
    this.productDao.update(ParserDatabase.parserBeanToEntity(product));
    }

    @Override
    public void delete(ProductBean product) {
    this.productDao.delete(ParserDatabase.parserBeanToEntity(product));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Interfaces.IDaoFactory;
import services.CategoryServices;
import services.ProductService;
import utils.DaoFactory;
import utils.database.interfaces.ICategoryService;
import utils.database.interfaces.IProductService;
import utils.database.interfaces.IServiceFactory;

/**
 *
 * @author Izidio
 */


//Factory que retorna os serviços
public class ServicesFactory implements IServiceFactory {

    //variaveis a ser instanciadas
    private final ICategoryService categoryService;
    private final IProductService productService;

    public ServicesFactory(){
        IDaoFactory daoFactory = new DaoFactory();
        
        //construtor responsavel por instanciar as variaveis
        this.categoryService = new CategoryServices(daoFactory);
        this.productService = new ProductService(daoFactory);
    }
    
    //metodos que retornam as instacias
    @Override
    public ICategoryService getCategoryService() {
        return this.categoryService;
    }

    @Override
    public IProductService getProducService() {
        return this.productService;
    }

}

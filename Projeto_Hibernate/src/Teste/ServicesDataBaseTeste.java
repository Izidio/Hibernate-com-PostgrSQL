/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import database.ServicesFactory;
import java.util.List;
import org.apache.log4j.Logger;
import utils.database.beans.CategoryBean;
import utils.database.beans.ProductBean;
import utils.database.interfaces.IServiceFactory;

/**
 *
 * @author Izidio
 */
public class ServicesDataBaseTeste {
    private static final Logger logger = Logger.getLogger(ServicesDataBaseTeste.class);
    private static IServiceFactory serviceFactory = new ServicesFactory();

    public static void main(String[] args) {
        testFindAll();
       
    }

    public static void testFindAll() {
        logger.info("Buscando todas as categorias");
        List<CategoryBean> categories = serviceFactory.getCategoryService().findAllCategories();
        for (CategoryBean category : categories) {
            logger.info(String.format("Category [%s].", category));
        }

    }

    public static void TesteInsert(String nome, String descricao) {
        logger.info("Testando metodo de inserção");

        CategoryBean category = new CategoryBean();
        category.setDescricao(descricao);
        category.setNome(nome);

        serviceFactory.getCategoryService().insert(category);
    }
    
        public static void Insert(String nome, String descricao) {
        logger.info("Testando metodo de inserção");

        CategoryBean category = new CategoryBean();
        category.setDescricao(descricao);
        category.setNome(nome);
        
        ProductBean product = new ProductBean();
        
        product.setCategory(category);
        product.setDescricao(descricao);
        product.setPreco(Double.parseDouble("15230"));

        serviceFactory.getCategoryService().insert(category);
        serviceFactory.getProducService().insert(product);
    }
}

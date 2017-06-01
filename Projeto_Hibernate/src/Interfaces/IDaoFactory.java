/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Izidio
 */


public interface IDaoFactory {
    //metodo que retorna os daos especificos
    ICategoryDao getCategoryDao();
    IProductDao getProductDao();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.database.interfaces;

import java.util.List;
import utils.database.beans.ProductBean;

/**
 *
 * @author Izidio
 */
public interface IProductService {
    //servicos disponiblizados
    
    ProductBean findByID(Long id);

    List<ProductBean> findAllProducts();

    Long insert(ProductBean product);

    void update(ProductBean product);

    void delete(ProductBean product);
}

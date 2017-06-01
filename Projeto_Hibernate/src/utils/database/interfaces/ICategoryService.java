/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.database.interfaces;

import java.util.List;
import utils.database.beans.CategoryBean;

/**
 *
 * @author Izidio
 */
public interface ICategoryService {

    CategoryBean findByID(Long id);

    List<CategoryBean> findAllCategories();

    Long insert(CategoryBean product);

    void update(CategoryBean product);

    void delete(CategoryBean product);
}

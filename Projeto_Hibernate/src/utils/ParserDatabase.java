package utils;

import java.util.ArrayList;
import java.util.List;

import entities.CategoryEntity;
import entities.ProductEntity;
import utils.database.beans.CategoryBean;
import utils.database.beans.ProductBean;

public class ParserDatabase {

	public static CategoryEntity parserBeanToEntity(CategoryBean categoryBean) {

		CategoryEntity categoryEntity = new CategoryEntity();

		// ID
		categoryEntity.setId(categoryBean.getId());

		// Description
		categoryEntity.setDescricao(categoryBean.getDescricao());

		// Name
		categoryEntity.setNome(categoryBean.getNome());

		// Products
		List<ProductEntity> products = parseProductBeansToEntities(categoryBean.getProducts());

		categoryEntity.setProducts(products);

		return categoryEntity;

	}

	public static ProductEntity parserBeanToEntity(ProductBean productBean) {

		ProductEntity product = new ProductEntity();

		// ID
		product.setId(productBean.getId());

		// Description
		product.setDescricao(productBean.getDescricao());

		// Price
		product.setPreco(productBean.getPreco());

		// Category
		CategoryEntity category = parserBeanToEntity(productBean.getCategory());

		product.setCategoria(category);

		return product;

	}

	public static List<ProductEntity> parseProductBeansToEntities(List<ProductBean> productsBean) {

		List<ProductEntity> productsEntity = new ArrayList<ProductEntity>();

		if (productsBean != null) {
			for (ProductBean product : productsBean) {
				productsEntity.add(parserBeanToEntity(product));
			}
		}

		return productsEntity;

	}

	public static List<CategoryEntity> parseCategoryBeansToEntities(List<CategoryBean> categoriesBean) {

		List<CategoryEntity> categoriesEntity = new ArrayList<CategoryEntity>();

		if (categoriesBean != null) {
			for (CategoryBean category : categoriesBean) {
				categoriesEntity.add(parserBeanToEntity(category));
			}
		}

		return categoriesEntity;

	}

	public static CategoryBean parserEntityToBean(CategoryEntity categoryEntity) {

		CategoryBean categoryBean = new CategoryBean();

		// ID
		categoryBean.setId(categoryEntity.getId());

		// Description
		categoryBean.setDescricao(categoryEntity.getDescricao());

		// Name
		categoryBean.setNome(categoryEntity.getNome());

		// Products
		List<ProductBean> products = parseProductEntitiesToBeans(categoryEntity.getProducts());

		categoryBean.setProducts(products);

		return categoryBean;

	}

	public static ProductBean parserEntityToBean(ProductEntity productEntity) {

		ProductBean productBean = new ProductBean();

		// ID
		productBean.setId(productEntity.getId());

		// Description
		productBean.setDescricao(productEntity.getDescricao());

		// Price
		productBean.setPreco(productEntity.getPreco());

		// Category
		productBean.setCategory(parserEntityToBean(productEntity.getCategoria()));

		return productBean;

	}

	public static List<ProductBean> parseProductEntitiesToBeans(List<ProductEntity> productsEntity) {

		List<ProductBean> productsBean = new ArrayList<ProductBean>();

		if (productsEntity != null) {
			for (ProductEntity product : productsEntity) {
				productsBean.add(parserEntityToBean(product));
			}
		}

		return productsBean;

	}

	public static List<CategoryBean> parseCategoryEntitiesToBeans(List<CategoryEntity> categoriesEntity) {

		List<CategoryBean> categoriesBean = new ArrayList<CategoryBean>();

		if (categoriesEntity != null) {
			for (CategoryEntity category : categoriesEntity) {
				categoriesBean.add(parserEntityToBean(category));
			}
		}

		return categoriesBean;

	}

}

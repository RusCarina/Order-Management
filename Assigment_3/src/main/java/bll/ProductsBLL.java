package bll;

import bll.validators.Validator;
import dao.ProductsDAO;
import model.Clients;
import model.Products;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductsBLL {
    private Validator validator;
    private ProductsDAO productsDAO;

    /**
     * products
     */
    public ProductsBLL(){
        //validator = new EmailValidator();
        productsDAO = new ProductsDAO();
    }

    /**
     * @param id i
     * @return findbyid
     */
    public Products findById(int id){
        Products products = productsDAO.findById(id);
        if(products == null){
            throw new NoSuchElementException("The student was not found");
        }
        return products;
    }

    /**
     * @return findall
     */
    public List<Products> findAll(){
        List<Products> products = productsDAO.findAll();
        if(products == null){
            throw new NoSuchElementException("There are no clients");
        }
        return products;
    }

    /**
     * @param products p
     */
    public void insertProduct(Products products){
        //validator.validate(products);
        productsDAO.insert(products);
    }

    /**
     * @param products p
     * @param id i
     */
    public void updateProduct(Products products, int id){
        //validator.validate(products);
        productsDAO.update(products, id);
    }

    /**
     * @param id i
     */
    public void deleteProduct(int id){
        Products products = productsDAO.findById(id);
        //validator.validate(products);
        productsDAO.delete(products.getId());
    }
}

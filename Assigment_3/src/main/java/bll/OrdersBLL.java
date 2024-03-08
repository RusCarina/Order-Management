package bll;

import bll.validators.Validator;
import dao.OrdersDAO;
import dao.ProductsDAO;
import model.Orders;
import model.Products;
import bll.ProductsBLL;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.NoSuchElementException;

public class OrdersBLL {
    private Validator validator;
    private OrdersDAO ordersDAO;

    /**
     * order
     */
    public OrdersBLL(){
        //validator = new EmailValidator();
        ordersDAO = new OrdersDAO();
    }

    /**
     * @param id i
     * @return orders
     */
    public Orders findById(int id){
        Orders orders = ordersDAO.findById(id);
        if(orders == null){
            throw new NoSuchElementException("The student was not found");
        }
        return orders;
    }

    /**
     * @return findall
     */
    public List<Orders> findAll(){
        List<Orders> orders = ordersDAO.findAll();
        if(orders == null){
            throw new NoSuchElementException("There are no clients");
        }
        return orders;
    }

    /**
     * @param idClient c
     * @param idProdus p
     * @param quantity q
     */
    public void placeOrder(int idClient, int idProdus, int quantity){
        Orders order = new Orders(idClient,idProdus,quantity,0);
        //validator.validate(order);
        ProductsBLL productBLL = new ProductsBLL();
        Products pr = productBLL.findById(idProdus);
        ordersDAO.insertOrder(idClient,idProdus,quantity,pr);
        productBLL.updateProduct(pr,idProdus);
        pr = productBLL.findById(idProdus);
        if(pr.getStock() == 0){
            productBLL.deleteProduct(Integer.parseInt(pr.getName()));
        }
    }
}

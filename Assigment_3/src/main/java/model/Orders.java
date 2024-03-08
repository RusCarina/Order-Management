package model;

public class Orders{
    private int id;
    private int idClient;
    private int idProduct;
    private int quantity;

    /**
     * orders
     */
    public Orders(){

    }

    /**
     * @param idOrder o
     * @param idClient c
     * @param idProduct p
     * @param quantity q
     */
    public Orders(int idOrder, int idClient, int idProduct, int quantity){
        this.id=idOrder;
        this.idClient=idClient;
        this.idProduct=idProduct;
        this.quantity=quantity;
    }

    /**
     * @return id
     */
    public int getIdOrder(){
        return id;
    }

    /**
     * @param id i
     */
    public void setIdOrder(int id){
        this.id=id;
    }

    /**
     * @return cl
     */
    public int getIdClient(){
        return idClient;
    }

    /**
     * @param id i
     */
    public void setIdClient(int id){
        idClient=id;
    }

    /**
     * @return pr
     */
    public int getIdProduct(){
        return idProduct;
    }

    /**
     * @param id i
     */
    public void setIdProduct(int id){
        idProduct=id;
    }

    /**
     * @return quantity
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * @param q q
     */
    public void setQuantity(int q){
        quantity=q;
    }

    /**
     * @return str
     */
    @Override
    public String toString() {
        return "Orders{" +
                "idOrder=" + id +
                ", idClient=" + idClient +
                ", idProduct='" + idProduct +
                ", quantity='" + quantity +
                '}';
    }
}

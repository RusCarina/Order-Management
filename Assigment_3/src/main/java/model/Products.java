package model;

public class Products {
    private int id;
    private String name;
    private int stock;

    /**
     * products
     */
    public Products(){

    }

    /**
     * @param id i
     * @param name n
     * @param stock s
     */
    public Products(int id, String name, int stock){
        this.id=id;
        this.name=name;
        this.stock=stock;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id i
     */
    public void setId(int id) {
        this.id=id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name n
     */
    public void setName(String name) {
        this.name=name;
    }

    /**
     * @return stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock s
     */
    public void setStock(int stock) {
        this.stock=stock;
    }

    /**
     * @return str
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock + '\'' +
                '}';
    }
}

package bll.validators;

        import model.Products;

public class StockValidator implements Validator<Products> {
    private static final int MIN_STOCK = 0;

    public void validate(Products t) {

        if (t.getStock() < MIN_STOCK) {
            throw new IllegalArgumentException("The stock is negative!");
        }

    }
}


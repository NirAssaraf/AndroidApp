package co.il.androidapp.model;

import java.util.LinkedList;
import java.util.List;

public class ProductModel
{

    public final static ProductModel instance = new ProductModel();

    List<Product> data = new LinkedList<>();

    public ProductModel() {
        for(int i=0;i<10;i++) {
            Product product = new Product();
            product.productId = 1+ i;
            product.productName = "Product " + i;
            product.productQuantity=" "+i;
            product.position=i;
            data.add(product);
        }
    }

    public List<Product> getAllProductList(){return data;}

    public void addProduct(Product p)
    {
        if (data!=null){
            data.add(p);
        }
    }
}

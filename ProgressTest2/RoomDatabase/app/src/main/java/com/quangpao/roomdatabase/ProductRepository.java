package com.quangpao.roomdatabase;

import android.app.Application;

import java.util.List;

public class ProductRepository {

    public static Dao dao;

    public ProductRepository(Application application) {
        ProductDatabase database = ProductDatabase.getInstance(application);
        dao = database.dao();
    }

    public void insert(Product product) {
        dao.insert(product);
    }

    public void update(Product product) {
        dao.update(product);
    }

    public void delete(Product product) {
        dao.delete(product);
    }

    public void deleteAll() {
        dao.deleteAllProducts();
    }

    public List<Product> getAll() {
        return dao.getAllProducts();
    }
}


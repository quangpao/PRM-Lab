package com.quangpao.roomdatabase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(Product model);

    @Update
    void update(Product model);

    @Delete
    void delete(Product model);

    @Query("DELETE FROM products_table")
    void deleteAllProducts();

    @Query("SELECT * FROM products_table ORDER BY id DESC")
    List<Product> getAllProducts();
}


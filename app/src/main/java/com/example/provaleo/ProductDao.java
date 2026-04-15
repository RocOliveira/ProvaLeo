package com.example.provaleo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Interface DAO para operações no banco de dados para a entidade Produto.
 */
@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);

    @Query("SELECT * FROM products ORDER BY id DESC")
    List<Product> getAllProducts();
}

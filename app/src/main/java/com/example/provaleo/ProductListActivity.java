package com.example.provaleo;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Activity que exibe a lista de produtos cadastrados.
 */
public class ProductListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ProductDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recycler_view_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new ProductAdapter();
        recyclerView.setAdapter(adapter);

        // Inicializar banco de dados e carregar produtos
        database = ProductDatabase.getInstance(this);
        loadProducts();

        // Botão para voltar à tela de cadastro
        Button buttonBack = findViewById(R.id.button_back_to_register);
        buttonBack.setOnClickListener(v -> finish());
    }

    /**
     * Carrega a lista de produtos do banco de dados e atualiza o adapter.
     */
    private void loadProducts() {
        List<Product> productList = database.productDao().getAllProducts();
        adapter.setProducts(productList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Atualiza a lista sempre que a tela volta a ficar visível
        loadProducts();
    }
}

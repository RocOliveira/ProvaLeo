package com.example.provaleo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity para cadastrar novos produtos.
 */
public class AddProductActivity extends AppCompatActivity {

    private EditText editName, editCode, editPrice, editQuantity;
    private Button buttonSave, buttonViewList;
    private ProductDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        // Inicializar componentes da UI
        editName = findViewById(R.id.edit_product_name);
        editCode = findViewById(R.id.edit_product_code);
        editPrice = findViewById(R.id.edit_product_price);
        editQuantity = findViewById(R.id.edit_product_quantity);
        buttonSave = findViewById(R.id.button_save);
        buttonViewList = findViewById(R.id.button_view_list);

        database = ProductDatabase.getInstance(this);

        // Ação do botão salvar
        buttonSave.setOnClickListener(v -> saveProduct());

        // Ação do botão ver lista
        buttonViewList.setOnClickListener(v -> {
            Intent intent = new Intent(AddProductActivity.this, ProductListActivity.class);
            startActivity(intent);
        });
    }

    private void saveProduct() {
        String name = editName.getText().toString().trim();
        String code = editCode.getText().toString().trim();
        String priceStr = editPrice.getText().toString().trim();
        String quantityStr = editQuantity.getText().toString().trim();

        // Validação: Nenhum campo em branco
        if (name.isEmpty() || code.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            // Validação: Preço positivo e Quantidade inteira positiva
            if (price <= 0) {
                Toast.makeText(this, "O preço deve ser maior que zero", Toast.LENGTH_SHORT).show();
                return;
            }
            if (quantity <= 0) {
                Toast.makeText(this, "A quantidade deve ser maior que zero", Toast.LENGTH_SHORT).show();
                return;
            }

            // Criar e salvar o produto
            Product product = new Product(name, code, price, quantity);
            database.productDao().insert(product);

            Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show();

            // Limpar campos após salvar
            clearFields();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Erro nos valores informados. Verifique o preço e a quantidade.", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        editName.setText("");
        editCode.setText("");
        editPrice.setText("");
        editQuantity.setText("");
    }
}

package com.example.provaleo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Adapter para exibir a lista de produtos no RecyclerView.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private List<Product> products = new ArrayList<>();

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product currentProduct = products.get(position);
        holder.textViewName.setText(currentProduct.getName());
        holder.textViewCode.setText("Código: " + currentProduct.getCode());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "Preço: R$ %.2f", currentProduct.getPrice()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewCode;
        private TextView textViewPrice;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_item_name);
            textViewCode = itemView.findViewById(R.id.text_item_code);
            textViewPrice = itemView.findViewById(R.id.text_item_price);
        }
    }
}

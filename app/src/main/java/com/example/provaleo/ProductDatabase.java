package com.example.provaleo;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Classe abstrata que representa o Banco de Dados Room.
 * Define a entidade do banco e a versão.
 */
@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {

    private static ProductDatabase instance;

    // Método para acessar o DAO do produto
    public abstract ProductDao productDao();

    /**
     * Método Singleton para obter a instância do banco de dados.
     */
    public static synchronized ProductDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ProductDatabase.class, "product_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // Simplificação para este exemplo
                    .build();
        }
        return instance;
    }
}

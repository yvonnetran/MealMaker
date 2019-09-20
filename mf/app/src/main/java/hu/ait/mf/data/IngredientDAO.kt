package hu.ait.mf.data

import android.arch.persistence.room.*


@Dao
interface IngredientDAO {
    @Query("SELECT * FROM ingredient")
    fun getAllIngredients(): List<Ingredient>

    @Insert
    fun insertIngredient(ingredient: Ingredient): Long

    @Insert
    fun insertIngredients(vararg ingredient: Ingredient): List<Long>

    @Delete
    fun deleteIngredient(ingredient: Ingredient)

    @Update
    fun updateIngredient(ingredient: Ingredient)
}
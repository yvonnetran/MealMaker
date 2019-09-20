package hu.ait.mf

import hu.ait.mf.data.Ingredient

object IngredientNames {

    private val ingredientNamesStrs = mutableListOf<String>()

    public fun addToList(ingredient: Ingredient){
        ingredientNamesStrs.add(0, ingredient.ingredientName)
    }

    public fun getAllNames() : List<String> {
        return ingredientNamesStrs
    }

    public fun removeFromList(position: Int){
        ingredientNamesStrs.removeAt(position)
    }

    public fun editIngredientTo(ingredient: Ingredient, position: Int){
        ingredientNamesStrs.set(position, ingredient.toString())
    }
}
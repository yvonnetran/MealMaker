package hu.ait.mf.adapter

import android.content.Context
import android.content.Intent
import android.preference.PreferenceManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hu.ait.mf.IngredientNames
import hu.ait.mf.R
import hu.ait.mf.ResultActivity
import hu.ait.mf.ScrollingActivity
import hu.ait.mf.data.AppDatabase
import hu.ait.mf.data.Ingredient
import hu.ait.mf.touch.IngredientTouchHelperCallback
import kotlinx.android.synthetic.main.ingredient_row.view.*
import java.util.*

class IngredientAdapter : RecyclerView.Adapter<IngredientAdapter.ViewHolder>, IngredientTouchHelperCallback {

    private val context: Context
    var ingredientItems = mutableListOf<Ingredient>()

    constructor(context: Context, listIngredients: List<Ingredient>) : super() {
        this.context = context
        ingredientItems.addAll(listIngredients)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val ingredientRowView = LayoutInflater.from(context).inflate(
            R.layout.ingredient_row, viewGroup, false
        )
        return ViewHolder(ingredientRowView)
    }

    override fun getItemCount(): Int {
        return ingredientItems.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val ingredient = ingredientItems.get(viewHolder.adapterPosition)

        viewHolder.tvItemName.text = ingredient.ingredientName.capitalize()

        viewHolder.btnDelete.setOnClickListener {
            deleteIngredient(viewHolder.adapterPosition) }
    }

    fun updateIngredient(ingredient: Ingredient, editIndex: Int) {
        ingredientItems.set(editIndex, ingredient)
        IngredientNames.editIngredientTo(ingredient, editIndex)
        notifyItemChanged(editIndex)
    }


    fun addIngredient(ingredient: Ingredient) {
        ingredientItems.add(0, ingredient)
        IngredientNames.addToList(ingredient)
        notifyItemInserted(0)
    }

    fun deleteIngredient(deletePosition: Int) {
        Thread {
            AppDatabase.getInstance(context).ingredientDao().deleteIngredient(ingredientItems.get(deletePosition))
            (context as ScrollingActivity).runOnUiThread {
                ingredientItems.removeAt(deletePosition)
                IngredientNames.removeFromList(deletePosition)
                notifyItemRemoved(deletePosition)
            }
        }.start()
    }

    override fun onDismissed(position: Int) {
        deleteIngredient(position)
    }

    override fun onItemMoved(fromPosition: Int, toPosition: Int) {
        Collections.swap(ingredientItems, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var btnDelete = itemView.btnDelete
        var tvItemName = itemView.tvName
    }

    fun getItem(position: Int): Ingredient {
        return ingredientItems.get(position)
    }

    fun deleteAll(){
        ingredientItems.clear()
    }
}
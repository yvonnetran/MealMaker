package hu.ait.mf

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.widget.EditText
import android.widget.Spinner
import hu.ait.mf.data.Ingredient
import kotlinx.android.synthetic.main.new_ingredient_dialog.view.*
import kotlinx.android.synthetic.main.ingredient_row.view.*
import java.lang.RuntimeException
import java.util.*
import android.R.attr.onClick
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener



class IngredientDialog : DialogFragment() {

    interface IngredientHandler {
        fun ingredientCreated(item: Ingredient)
        fun ingredientUpdated(item: Ingredient)
    }

    private lateinit var ingredientHandler: IngredientHandler

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is IngredientHandler) {
            ingredientHandler = context
        } else {
            throw RuntimeException(
                "The activity does not implement the IngredientHandlerInterface")
        }
    }
    private lateinit var etIngredientName: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle(getString(R.string.new_ingredient))

        val rootView = requireActivity().layoutInflater.inflate(
            R.layout.new_ingredient_dialog, null
        )
        etIngredientName = rootView.etIngredientName

        builder.setView(rootView)

        builder.setPositiveButton("OK") {
                dialog, witch -> // empty
        }

        return builder.create()
    }


    override fun onResume() {
        super.onResume()

        val positiveButton = (dialog as AlertDialog).getButton(Dialog.BUTTON_POSITIVE)
        positiveButton.setOnClickListener {
            if (etIngredientName.text.isNotEmpty()) {
                handleIngredientCreate()
                dialog.dismiss()
            } else {
                etIngredientName.error = "This field cannot be empty"
            }
        }
    }

    private fun handleIngredientCreate() {
        ingredientHandler.ingredientCreated(
            Ingredient(
                null,
                etIngredientName.text.toString()
            )
        )
    }
}
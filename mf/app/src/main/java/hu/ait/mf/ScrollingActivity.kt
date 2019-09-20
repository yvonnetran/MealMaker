package hu.ait.mf

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import hu.ait.mf.adapter.IngredientAdapter
import hu.ait.mf.data.AppDatabase
import hu.ait.mf.data.Ingredient
import hu.ait.mf.touch.IngredientRecyclerTouchCallback
import kotlinx.android.synthetic.main.activity_scrolling.*
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt

class ScrollingActivity : AppCompatActivity(), IngredientDialog.IngredientHandler {

    lateinit var ingredientAdapter : IngredientAdapter

    companion object {
        public val RESULT_NAME = "RESULT_NAME"
        public val REQUEST_DETAILS = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        setSupportActionBar(toolbar)
        fab.setOnClickListener { view -> showAddIngredientDialog() }

        if (!wasOpenedEarlier()) {
            MaterialTapTargetPrompt.Builder(this)
                .setTarget(R.id.fab).setPrimaryText(getString(R.string.new_ingredient))
                .setSecondaryText("Click here to add an ingredient").show()
        }

        btnResult.setOnClickListener {
            var intentDetails = Intent()
            intentDetails.setClass(this@ScrollingActivity,
                ResultActivity::class.java)

            // Activity can be started also if we know
            // the package name and the class name of it
            //intentDetails.setClassName(this@MainActivity,
            //    "com.org.facebook.MainActivity")

            // startActivity(intentDetails)


            startActivityForResult(intentDetails, REQUEST_DETAILS)

            //finish()

        }

        saveFirstOpenInfo()
        initRecyclerViewFromDB()
    }

    fun saveFirstOpenInfo() {
        var sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        var editor = sharedPref.edit()
        editor.putBoolean("KEY_WAS_OPEN", true)
        editor.apply()
    }

    fun wasOpenedEarlier() : Boolean {
        var sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        return sharedPref.getBoolean("KEY_WAS_OPEN", false)
    }

    private fun initRecyclerViewFromDB() {
        Thread {
            var ingredientList = AppDatabase.getInstance(this@ScrollingActivity).ingredientDao().getAllIngredients()

            runOnUiThread {
                ingredientAdapter = IngredientAdapter(this, ingredientList)

                recyclerIngredient.layoutManager = LinearLayoutManager(this)
                recyclerIngredient.adapter = ingredientAdapter

                val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
                recyclerIngredient.addItemDecoration(itemDecoration)

                val callback = IngredientRecyclerTouchCallback(ingredientAdapter)
                val touchHelper = ItemTouchHelper(callback)
                touchHelper.attachToRecyclerView(recyclerIngredient)

                addToIngredientNames(ingredientAdapter)
            }
        }.start()
    }

    private fun addToIngredientNames(adapter: IngredientAdapter){
        for (i in 0 .. (adapter.itemCount - 1)){
            IngredientNames.addToList(adapter.getItem(i))
        }
    }

    private fun showAddIngredientDialog() {
        IngredientDialog().show(supportFragmentManager, "TAG_TODO_DIALOG")
    }

    private fun showAddAboutDialog() {
        AboutDialog().show(supportFragmentManager, "TAG_TODO_DIALOG")
    }



    var editIndex: Int = -1


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> { showAddAboutDialog() }
        }
        return true
    }


    override fun ingredientCreated(item: Ingredient) {
        Thread {
            var newId = AppDatabase.getInstance(this).ingredientDao().insertIngredient(item)
            item.ingredientId = newId

            runOnUiThread {
                ingredientAdapter.addIngredient(item)
            }
        }.start()
    }

    override fun ingredientUpdated(item: Ingredient) {
        Thread {
            AppDatabase.getInstance(this).ingredientDao().updateIngredient(item)
            runOnUiThread {
                ingredientAdapter.updateIngredient(item, editIndex)
            }
        }.start()
    }

}
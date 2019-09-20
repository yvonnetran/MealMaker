package hu.ait.mf

import android.content.Intent
import com.bumptech.glide.Glide
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.ait.mf.data.RecipeResult
import hu.ait.mf.network.RecipeAPI
import kotlinx.android.synthetic.main.activity_result.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultActivity : AppCompatActivity() {

    private val HOST_URL = "https://api.edamam.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        recipeDetails(IngredientNames.getAllNames())
    }

    //https://api.edamam.com/search?q=chicken&app_id=68e785b1&app_key=5a016fcbdc6cf78be06d009994fbe268&from=0&to=3&calories=591-722&health=alcohol-free

    private fun recipeDetails(ingredients: List<String>) {
        val retrofit = Retrofit.Builder()
            .baseUrl(HOST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val ingredientsStr = ingredients.toString()

        val recipeAPI = retrofit.create(RecipeAPI::class.java)
        val recipeCall = recipeAPI.getResult(ingredientsStr.substring(1, ingredientsStr.length-1),
            getString(R.string.api_id),
            getString(R.string.api_key))

        recipeCall.enqueue(object : Callback<RecipeResult> {
            override fun onFailure(call: Call<RecipeResult>, t: Throwable) {
                tvRecipeName.text = getString(R.string.cannot_connect)
        }

            override fun onResponse(call: Call<RecipeResult>, response: Response<RecipeResult>) {
                val result = response.body()

                if (IngredientNames.getAllNames().size == 0) {
                    tvRecipeName.text = getString(R.string.no_results)
                } else {
                    if (result?.hits?.size == 0) {
                        tvRecipeName.text = getString(R.string.no_results)
                    } else {
                        tvRecipeName.text = result?.hits?.get(0)?.recipe?.label.toString()

                        Glide.with(this@ResultActivity)
                            .load(
                                (result?.hits?.get(0)?.recipe?.image)
                            )
                            .into(tvRecipeImage)

                        tvAllIngredients.text = addNewLines(result?.hits?.get(0)?.recipe?.ingredientLines)

                        btnGetRecipe.setOnClickListener {
                            startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(result?.hits?.get(0)?.recipe?.url.toString())
                                )
                            )
                        }
                    }
                }
            }
        })
    }

    private fun addNewLines(someList: List<String>?): String {
        var someString = ""
        val nullableInt: Int? = someList?.size

        if (nullableInt != null){
            someString += getString(R.string.bullet)
            val nonNullableInt: Int = nullableInt - 1
            for (i in 0 .. nonNullableInt){
                someString += someList[i] + "\n" + getString(R.string.bullet)
            }
        }
        return someString.substring(0, someString.length - 2)
    }
}
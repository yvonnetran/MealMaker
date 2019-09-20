package hu.ait.mf.network

//import hu.ait.mf.RecipeResult
import hu.ait.mf.data.RecipeResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// Example call:
//https://api.edamam.com/search?q=chicken&app_id=68e785b1&app_key=5a016fcbdc6cf78be06d009994fbe268&from=0&to=3&calories=591-722&health=alcohol-free

interface RecipeAPI {
    @GET("/search")
    fun getResult(@Query("q") q: String,
                  @Query("app_id") app_id: String,
                  @Query("app_key") app_key: String): Call<RecipeResult>
}
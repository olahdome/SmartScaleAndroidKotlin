package olah.dome.smartscale.network

import kotlinx.coroutines.Deferred
import olah.dome.smartscale.model.Nutritions
import retrofit2.Response
import retrofit2.http.*

interface API {

    @Headers(
        "X-Mashape-Key:z2uBHq5cEBmshGutYdVZVQCAvQ0Wp18WqZdjsnMwm7XzzvRPYm",
        "Accept:application/json"
    )
    @GET("/recipes/guessNutrition")
    fun getNutritionByName(@Query("title") title: String): Deferred<Response<Nutritions>> // ide kell  visszatéri érétékként a a megfelelő modle osztály

}
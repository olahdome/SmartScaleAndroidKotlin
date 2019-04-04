package olah.dome.smartscale.network

import olah.dome.smartscale.model.Nutritions
import retrofit2.Response

object NetworkDataSource {

    private val retrofitAPI: API by lazy {
        RetrofitUtils.getAPIService()
    }

    suspend fun getFood(food :String): Response<Nutritions> {
        return retrofitAPI.getNutritionByName(food).await()
    }
}

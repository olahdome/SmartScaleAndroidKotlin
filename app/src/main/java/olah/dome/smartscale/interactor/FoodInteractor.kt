package olah.dome.smartscale.interactor

import android.util.Log
import olah.dome.smartscale.model.Nutritions
import olah.dome.smartscale.network.NetworkDataSource
import olah.dome.smartscale.withIOContext
import retrofit2.Response

object FoodInteractor {

    suspend fun getFood(food: String): Nutritions? = withIOContext {
        Log.d("fos","")
         val respones : Response<Nutritions> = NetworkDataSource.getFood(food)
                 val code = respones.code()
        val message = respones.message()
        Log .d("fos","code : $code, message: $message" )
        return@withIOContext respones.body() as? Nutritions
    }
}
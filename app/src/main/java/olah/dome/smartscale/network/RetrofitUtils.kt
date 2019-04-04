package olah.dome.smartscale.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {
    private const val BASE_URL = "https://spoonacular-recipe-food-nutrition-v1.p.mashape.com"
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor { chain ->
                Thread.sleep(2000)
                chain.proceed(chain.request())
            }
            .build()

    }

    private val retrofitClient: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun getAPIService(): API = retrofitClient.create(API::class.java)


}
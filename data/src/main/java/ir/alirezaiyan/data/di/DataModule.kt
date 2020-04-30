package ir.alirezaiyan.data.di

import dagger.Module
import dagger.Provides
import ir.alirezaiyan.data.BuildConfig
import ir.alirezaiyan.data.remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 5:00 PM.
 */
@Module
class DataModule {

    @Provides
    fun provideService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.foursquare.com")
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }
}
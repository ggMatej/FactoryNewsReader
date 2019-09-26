package hr.ferit.matejmijic.factorynewsreader.networking

import hr.ferit.matejmijic.factorynewsreader.common.API_KEY
import hr.ferit.matejmijic.factorynewsreader.common.AUTHENTICATION
import hr.ferit.matejmijic.factorynewsreader.common.BASE_URL
import hr.ferit.matejmijic.factorynewsreader.networking.interactors.NewsInteractor
import hr.ferit.matejmijic.factorynewsreader.networking.interactors.NewsInteractorImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object BackendFactory {

    private var retrofit: Retrofit? = null
    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private fun provideAuthenticationInterceptor() = Interceptor {
        var request = it.request()
        var url = request.url().newBuilder().addQueryParameter(AUTHENTICATION, API_KEY).build()
        request = request.newBuilder().url(url).build()
        it.proceed(request)
    }

    private val httpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(provideAuthenticationInterceptor())
            .build()

    private val client: Retrofit? = if (retrofit == null) createRetrofit() else retrofit

    private fun createRetrofit(): Retrofit? {
        retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit
    }

    private fun getService(): NewsApiService = this.client!!.create(NewsApiService::class.java)

    fun getNewsInteractor(): NewsInteractor =
        NewsInteractorImpl(getService())
}
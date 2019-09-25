package hr.ferit.matejmijic.factorynewsreader.networking

import hr.ferit.matejmijic.factorynewsreader.common.API_KEY
import hr.ferit.matejmijic.factorynewsreader.model.response.GetArticlesResponse
import retrofit2.Call
import retrofit2.http.GET

interface NewsApiService {

    @GET("articles?source=bbc-news&sortBy=top&apiKey=$API_KEY")
    fun getArticles(): Call<GetArticlesResponse>
}
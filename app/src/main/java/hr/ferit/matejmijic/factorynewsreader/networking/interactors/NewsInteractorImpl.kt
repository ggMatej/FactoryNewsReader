package hr.ferit.matejmijic.factorynewsreader.networking.interactors

import hr.ferit.matejmijic.factorynewsreader.model.response.GetArticlesResponse
import hr.ferit.matejmijic.factorynewsreader.networking.NewsApiService
import retrofit2.Callback

class NewsInteractorImpl(private val apiService: NewsApiService):
    NewsInteractor {

    override fun getArticles(newsResponseCallback: Callback<GetArticlesResponse>) {
        apiService.getArticles().enqueue(newsResponseCallback)
    }
}
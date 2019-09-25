package hr.ferit.matejmijic.factorynewsreader.networking.interactors

import hr.ferit.matejmijic.factorynewsreader.model.response.GetArticlesResponse
import retrofit2.Callback

interface NewsInteractor {

    fun getArticles(newsResponseCallback: Callback<GetArticlesResponse>)
}
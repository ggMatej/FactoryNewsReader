package hr.ferit.matejmijic.factorynewsreader.presentation


import hr.ferit.matejmijic.factorynewsreader.common.FIVE_MINUTES
import hr.ferit.matejmijic.factorynewsreader.common.RESPONSE_OK
import hr.ferit.matejmijic.factorynewsreader.model.response.GetArticlesResponse
import hr.ferit.matejmijic.factorynewsreader.networking.interactors.NewsInteractor
import hr.ferit.matejmijic.factorynewsreader.persistence.ArticlePrefs
import hr.ferit.matejmijic.factorynewsreader.persistence.ArticleRepository
import hr.ferit.matejmijic.factorynewsreader.persistence.ArticleRoomRepository
import hr.ferit.matejmijic.factorynewsreader.ui.articles.ArticleListFragmentContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleListFragmentPresenter(private val interactor: NewsInteractor): ArticleListFragmentContract.Presenter {

    private lateinit var view: ArticleListFragmentContract.View

    private var repository: ArticleRepository = ArticleRoomRepository()

    override fun setView(view: ArticleListFragmentContract.View) {
        this.view = view
    }

    override fun onGetArticles() {
        if(System.currentTimeMillis() - ArticlePrefs.getLong(ArticlePrefs.LAST_REQUEST_TIME,0)!! > FIVE_MINUTES || repository.getArticles().isEmpty()){
            ArticlePrefs.store(ArticlePrefs.LAST_REQUEST_TIME,System.currentTimeMillis())
            interactor.getArticles(getArticlesCallback())
        }else{
            view.onArticleListReceived(repository.getArticles())
        }
    }

    private fun showArticles() {
        view.onArticleListReceived(repository.getArticles())
    }

    private fun getArticlesCallback(): Callback<GetArticlesResponse> = object : Callback<GetArticlesResponse> {

        override fun onFailure(call: Call<GetArticlesResponse>, t: Throwable) {
            view.onGetArticlesFailed(repository.getArticles())
        }

        override fun onResponse(
            call: Call<GetArticlesResponse>,
            response: Response<GetArticlesResponse>
        ) {
            if(response.isSuccessful) {
                when(response.code()){
                    RESPONSE_OK -> handleOkResponse(response)
                    else -> handleSomethingWentWrong()
                }
            }
        }
    }

    private fun handleSomethingWentWrong() = view.onGetArticlesFailed(repository.getArticles())

    private fun handleOkResponse(response: Response<GetArticlesResponse>) {
        response.body()?.articles?.run {
            repository.deleteAllArticles()
            repository.addArticles(this)
            showArticles()
        }
    }
}
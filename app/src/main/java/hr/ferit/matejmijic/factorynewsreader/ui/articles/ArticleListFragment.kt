package hr.ferit.matejmijic.factorynewsreader.ui.articles

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.matejmijic.factorynewsreader.App
import hr.ferit.matejmijic.factorynewsreader.R
import hr.ferit.matejmijic.factorynewsreader.model.Article
import hr.ferit.matejmijic.factorynewsreader.networking.BackendFactory
import hr.ferit.matejmijic.factorynewsreader.presentation.ArticleListFragmentPresenter
import hr.ferit.matejmijic.factorynewsreader.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_article_list.*

class ArticleListFragment : BaseFragment(),
    ArticleListFragmentContract.View {

    private val adapter by lazy {
        ArticleListAdapter {
            onItemSelected(
                it
            )
        }
    }

    private val presenter: ArticleListFragmentContract.Presenter by lazy {
        ArticleListFragmentPresenter(BackendFactory.getNewsInteractor())
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_article_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        presenter.setView(this)
        articleList.layoutManager = LinearLayoutManager(context)
        articleList.adapter = adapter
        getArticles()
    }



    private fun getArticles() {
        presenter.onGetArticles()
    }

    private fun onItemSelected(article: Article) {
        Toast.makeText(App.getAppContext(), article.title, Toast.LENGTH_LONG).show()
    }

    override fun onArticleListReceived(articles: MutableList<Article>) = adapter.setData(articles)

    override fun onGetArticlesFailed(articles: MutableList<Article>) {
        Toast.makeText(App.getAppContext(), "FAILED", Toast.LENGTH_LONG).show()
        adapter.setData(articles)
    }
}
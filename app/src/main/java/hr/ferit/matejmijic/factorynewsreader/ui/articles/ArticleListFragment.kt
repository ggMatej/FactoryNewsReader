package hr.ferit.matejmijic.factorynewsreader.ui.articles

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.matejmijic.factorynewsreader.App
import hr.ferit.matejmijic.factorynewsreader.R
import hr.ferit.matejmijic.factorynewsreader.common.showFragment
import hr.ferit.matejmijic.factorynewsreader.model.Article
import hr.ferit.matejmijic.factorynewsreader.networking.BackendFactory
import hr.ferit.matejmijic.factorynewsreader.presentation.ArticleListFragmentPresenter
import hr.ferit.matejmijic.factorynewsreader.ui.singlearticle.ArticlesPagerFragment
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

    private val articleList = arrayListOf<Article>()

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
        articleRecyclerView.layoutManager = LinearLayoutManager(context)
        articleRecyclerView.adapter = adapter
        getArticles()
    }

    private fun getArticles() {
        presenter.onGetArticles()
    }

    private fun onItemSelected(article: Article) {
        activity?.showFragment(R.id.fragmentContainer, ArticlesPagerFragment.getInstance(articleList, article), true)
    }

    override fun onArticleListReceived(articles: MutableList<Article>){
        adapter.setData(articles)
        adapter.notifyDataSetChanged()
        articleList.clear()
        articleList.addAll(articles)
    }

    override fun onGetArticlesFailed(articles: MutableList<Article>) {
        Toast.makeText(App.getAppContext(), "FAILED", Toast.LENGTH_LONG).show()
        adapter.setData(articles)
    }
}
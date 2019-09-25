package hr.ferit.matejmijic.factorynewsreader.ui.articles

import hr.ferit.matejmijic.factorynewsreader.model.Article

interface ArticleListFragmentContract {

    interface View{

        fun onArticleListReceived(articles: MutableList<Article>)

        fun onGetArticlesFailed()
    }

    interface Presenter {

        fun setView(view: View)

        fun onGetArticles()
    }
}
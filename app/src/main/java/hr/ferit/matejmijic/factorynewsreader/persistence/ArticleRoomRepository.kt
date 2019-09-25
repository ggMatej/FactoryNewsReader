package hr.ferit.matejmijic.factorynewsreader.persistence

import hr.ferit.matejmijic.factorynewsreader.App
import hr.ferit.matejmijic.factorynewsreader.db.DaoProvider
import hr.ferit.matejmijic.factorynewsreader.model.Article

class ArticleRoomRepository : ArticleRepository {

    private var db = DaoProvider.getInstance(App.getAppContext())

    private var articleDao = db.articleDao()

    override fun addArticles(articleList: MutableList<Article>) {
        articleDao.insertArticles(articleList)
    }

    override fun getArticles(): MutableList<Article> = articleDao.getAllArticles()

    override fun deleteAllArticles() {
        articleDao.deleteAllArticles()
    }
}
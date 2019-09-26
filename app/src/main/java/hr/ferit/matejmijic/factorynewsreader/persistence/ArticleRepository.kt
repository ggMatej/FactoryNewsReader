package hr.ferit.matejmijic.factorynewsreader.persistence

import hr.ferit.matejmijic.factorynewsreader.model.Article

interface ArticleRepository {

    fun addArticles(articleList: MutableList<Article>)

    fun getArticles(): MutableList<Article>

    fun deleteAllArticles()
}
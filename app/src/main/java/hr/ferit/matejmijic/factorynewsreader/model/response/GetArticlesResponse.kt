package hr.ferit.matejmijic.factorynewsreader.model.response

import hr.ferit.matejmijic.factorynewsreader.model.Article

data class GetArticlesResponse(
    val articles: MutableList<Article>? = mutableListOf()
)
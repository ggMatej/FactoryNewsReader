package hr.ferit.matejmijic.factorynewsreader.ui

import hr.ferit.matejmijic.factorynewsreader.R
import hr.ferit.matejmijic.factorynewsreader.common.showFragment
import hr.ferit.matejmijic.factorynewsreader.ui.articles.ArticleListFragment
import hr.ferit.matejmijic.factorynewsreader.ui.base.BaseActivity

class ContainerActivity : BaseActivity() {

    override fun getLayoutResourceId(): Int = R.layout.activity_articles

    override fun initUi() {
        showFragment(R.id.fragmentContainer,
            ArticleListFragment()
        )
    }
}
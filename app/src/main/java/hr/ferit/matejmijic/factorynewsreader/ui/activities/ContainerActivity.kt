package hr.ferit.matejmijic.factorynewsreader.ui.activities

import hr.ferit.matejmijic.factorynewsreader.R
import hr.ferit.matejmijic.factorynewsreader.common.showFragment
import hr.ferit.matejmijic.factorynewsreader.ui.articles.ArticleListFragment
import hr.ferit.matejmijic.factorynewsreader.ui.base.BaseActivity

class ContainerActivity : BaseActivity() {

    override fun getLayoutResourceId(): Int = R.layout.activity_container

    override fun initUi() {
        showFragment(R.id.fragmentContainer,
            ArticleListFragment(), false
        )
    }
}
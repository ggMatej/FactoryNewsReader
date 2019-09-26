package hr.ferit.matejmijic.factorynewsreader.ui.singlearticle


import android.os.Bundle
import android.view.View
import hr.ferit.matejmijic.factorynewsreader.R
import hr.ferit.matejmijic.factorynewsreader.model.Article
import hr.ferit.matejmijic.factorynewsreader.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_pager.*
import java.util.ArrayList

class ArticlesPagerFragment : BaseFragment() {

    companion object {

        private const val PAGER_LIST_EXTRA = "list_extra"
        private const val PAGER_SELECTED_ARTICLE_EXTRA = "selected_article"
        private const val PAGER_ARTICLE_POSITION = "selected_article_position"

        fun getInstance(articleList: ArrayList<Article>, selectedArticle: Article): ArticlesPagerFragment {
            val pagerFragment =
                ArticlesPagerFragment()
            val bundle = Bundle()
            bundle.putParcelableArrayList(PAGER_LIST_EXTRA, articleList)
            bundle.putParcelable(PAGER_SELECTED_ARTICLE_EXTRA, selectedArticle)
            bundle.putInt(PAGER_ARTICLE_POSITION, articleList.indexOf(selectedArticle))

            pagerFragment.arguments = bundle
            return pagerFragment
        }
    }

    private val articleList = mutableListOf<Article>()

    private val pagerAdapter by lazy {
        ArticlePagerAdapter(
            childFragmentManager
        )
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_pager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        articleList.addAll(arguments?.getParcelableArrayList(PAGER_LIST_EXTRA)!!)
        articlePager.adapter = pagerAdapter
        pagerAdapter.setArticles(articleList)
        articlePager.currentItem = arguments!!.getInt(PAGER_ARTICLE_POSITION)
    }
}
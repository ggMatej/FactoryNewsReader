package hr.ferit.matejmijic.factorynewsreader.ui.singlearticle

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import hr.ferit.matejmijic.factorynewsreader.R
import hr.ferit.matejmijic.factorynewsreader.common.loadImage
import hr.ferit.matejmijic.factorynewsreader.model.Article
import hr.ferit.matejmijic.factorynewsreader.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_article_details.*
import kotlinx.android.synthetic.main.item_article.articleImage
import kotlinx.android.synthetic.main.item_article.articleTitle

class ArticleDetailsFragment: BaseFragment() {

    companion object {
        private const val ARTICLE_EXTRA = "article_extra"

        fun getInstance(article: Article): ArticleDetailsFragment {
            val fragment =
                ArticleDetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARTICLE_EXTRA, article)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var article: Article

    override fun getLayoutResourceId(): Int = R.layout.fragment_article_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        article = arguments?.getParcelable(ARTICLE_EXTRA) as Article
        initUi()
    }

    private fun initUi() {
        articleImage.loadImage(article.image)
        articleTitle.text = article.title
        articleDetails.text = article.description
        articleDetails.movementMethod = ScrollingMovementMethod()
    }
}
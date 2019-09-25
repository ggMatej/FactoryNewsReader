package hr.ferit.matejmijic.factorynewsreader.ui.articles

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.matejmijic.factorynewsreader.R
import hr.ferit.matejmijic.factorynewsreader.common.loadImage
import hr.ferit.matejmijic.factorynewsreader.model.Article
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleListHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindData(article: Article, onItemSelected: (Article) -> Unit) {

        containerView.setOnClickListener { onItemSelected(article) }


        containerView.articleImage.loadImage(article.image)


        containerView.articleTitle.text = article.title
    }
}
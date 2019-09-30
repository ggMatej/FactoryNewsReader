package hr.ferit.matejmijic.factorynewsreader.ui.singlearticle

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import hr.ferit.matejmijic.factorynewsreader.model.Article

class ArticlePagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val articleList = mutableListOf<Article>()

    fun setArticles(articleList: MutableList<Article>){
        this.articleList.clear()
        this.articleList.addAll(articleList)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return ArticleDetailsFragment.getInstance(articleList[position])
    }

    override fun getCount(): Int = articleList.size
}
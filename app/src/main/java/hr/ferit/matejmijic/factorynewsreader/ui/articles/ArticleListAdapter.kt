package hr.ferit.matejmijic.factorynewsreader.ui.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.matejmijic.factorynewsreader.R
import hr.ferit.matejmijic.factorynewsreader.model.Article

class ArticleListAdapter(private val onItemSelected: (Article) -> Unit) : RecyclerView.Adapter<ArticleListHolder>() {

    private val data: MutableList<Article> = mutableListOf()

    fun setData(data: MutableList<Article>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ArticleListHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ArticleListHolder, position: Int) {
        holder.bindData(data[position], onItemSelected)
    }
}
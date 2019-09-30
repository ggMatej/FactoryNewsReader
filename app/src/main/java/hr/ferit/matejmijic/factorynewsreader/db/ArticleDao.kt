package hr.ferit.matejmijic.factorynewsreader.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import hr.ferit.matejmijic.factorynewsreader.model.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM Article")
    fun getAllArticles(): MutableList<Article>

    @Insert(onConflict = IGNORE)
    fun insertArticles(articles: MutableList<Article>)

    @Query("DELETE FROM Article")
    fun deleteAllArticles()
}
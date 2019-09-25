package hr.ferit.matejmijic.factorynewsreader.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Article(
    @PrimaryKey (autoGenerate = true) val id: Int,
    @SerializedName("author") val author: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("url") val url: String,
    @SerializedName("urlToImage") val image: String,
    @SerializedName("publishedAt") val publishedAt: String
)
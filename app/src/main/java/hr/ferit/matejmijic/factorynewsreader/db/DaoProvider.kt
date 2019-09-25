package hr.ferit.matejmijic.factorynewsreader.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hr.ferit.matejmijic.factorynewsreader.model.Article

@Database(entities = [Article::class], version = 1)
abstract class DaoProvider : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object {
        private var instance: DaoProvider? = null

        fun getInstance(context: Context): DaoProvider {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    DaoProvider::class.java,
                    "ArticleDb"
                ).allowMainThreadQueries().build()
            }
            return instance as DaoProvider
        }
    }
}
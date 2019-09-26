package hr.ferit.matejmijic.factorynewsreader.persistence

import android.preference.PreferenceManager
import hr.ferit.matejmijic.factorynewsreader.App

object ArticlePrefs {

    const val LAST_REQUEST_TIME = "LAST_REQUEST_TIME"

    private fun sharedPrefs() = PreferenceManager.getDefaultSharedPreferences(App.getAppContext())

    fun store(key: String, value: Long){
        sharedPrefs().edit().putLong(key,value).apply()
    }

    fun getLong(key: String, defaultValue: Long): Long? {
        return sharedPrefs().getLong(key, defaultValue)
    }

}
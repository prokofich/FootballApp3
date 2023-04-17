package com.example.football3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MAIN = this
        navController = Navigation.findNavController(this,R.id.id_nav_host)


    }

    fun getRecordEasy():Int{
        val recordEasyPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getInt(RECORD_EASY,0)
        return recordEasyPreferences ?: 0
    }

    fun getRecordMedium():Int{
        val recordMediumPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getInt(RECORD_MEDIUM,0)
        return recordMediumPreferences ?: 0
    }

    fun getRecordHard():Int{
        val recordHardPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getInt(RECORD_HARD,0)
        return recordHardPreferences ?: 0
    }

    fun setRecordEasy(record:Int){
        val recordPreferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        recordPreferences.edit()
            .putInt(RECORD_EASY,record)
            .apply()
    }

    fun setRecordMedium(record:Int){
        val recordPreferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        recordPreferences.edit()
            .putInt(RECORD_MEDIUM,record)
            .apply()
    }

    fun setRecordHard(record:Int){
        val recordPreferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        recordPreferences.edit()
            .putInt(RECORD_HARD,record)
            .apply()
    }

}
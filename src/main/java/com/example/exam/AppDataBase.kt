package com.example.exam

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Champion::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun championDao(): ChampionDao


    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "champions")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance!!
        }
    }
}
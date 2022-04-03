package com.example.exam

import androidx.room.*

@Dao
interface ChampionDao {
    @Insert
fun insert(champ: Champion)

    @Update
    fun update(champ: Champion)

    @Delete
    fun delete(champ: Champion)

    @Query("SELECT * FROM champions")
    fun getAllchamps(): MutableList<Champion>
}
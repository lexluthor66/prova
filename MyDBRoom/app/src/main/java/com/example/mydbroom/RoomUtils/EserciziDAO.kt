package com.example.mydbroom.RoomUtils


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface EserciziDAO {

    @Insert
    fun insert(esercizi: Esercizi)

    @Update
    fun update(esercizi: Esercizi)

    @Delete
    fun delete(esercizi: Esercizi)

    @Query("Select * from esercizi_table where idEsercizio=:idEsercizio")
    fun get(idEsercizio: Long) : LiveData   <Esercizi>

    @Query("Select * from esercizi_table ORDER BY  idEsercizio DESC")
    fun getALL()  : List<Esercizi>

}
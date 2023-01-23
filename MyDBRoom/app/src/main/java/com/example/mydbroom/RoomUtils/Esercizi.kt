package com.example.mydbroom.RoomUtils

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "esercizi_table")
data class Esercizi(

@PrimaryKey(autoGenerate = true)
var idEsercizio: Long = 0L  ,
@ColumnInfo(name="titolo_ese")
var titolo_Ese: String = "",
@ColumnInfo(name="ripetizioni_ese")
var ripetizioni_Ese: String = "" ,
@ColumnInfo(name="riposo_Ese")
var riposo_Ese: String = ""  ) {

}
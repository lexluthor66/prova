package com.example.mydbroom.RoomUtils


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = [Esercizi::class], version = 1 , exportSchema = false)
abstract class EserciziDatabase : RoomDatabase() {
    abstract  val eserciziDao : EserciziDAO

    companion object  {
       @Volatile
       private  var  INSTANCE : EserciziDatabase? = null

       fun getInstance (context: Context) : EserciziDatabase {
           synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder( context.applicationContext, EserciziDatabase::class.java,
                        "esercizio_database").build()
                    INSTANCE = instance
                }
                return instance
           }
       }
    }
}
package com.example.daje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = this.findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
            Toast.makeText(this, " hai clikkato tasto home", Toast.LENGTH_SHORT).show()
            finish()
            }
            R.id.back_item -> {
                Toast.makeText(this, " hai clikkato tasto back", Toast.LENGTH_SHORT).show()
                finish()
            }
            R.id.setting_item -> {
                Toast.makeText(this, " hai clikkato tasto settings", Toast.LENGTH_SHORT).show()
            }else  -> {

            }

        }
        return super.onOptionsItemSelected(item)
    }
}
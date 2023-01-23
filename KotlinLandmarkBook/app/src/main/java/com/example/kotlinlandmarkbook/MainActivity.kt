package com.example.kotlinlandmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.kotlinlandmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var landMarknames = ArrayList<String>()
        landMarknames.add("Parigi")
        landMarknames.add("Roma")
        landMarknames.add("New York")
        landMarknames.add("Praga")

        var landMarkImages = ArrayList<Bitmap>()

        landMarkImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.parigi))
        landMarkImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.colosseo_roma))
        landMarkImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.new_york))
        landMarkImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.praga))

        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landMarknames)
        var  listView = binding.idListView
        listView.adapter = arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext,DetailActivity::class.java)
            intent.putExtra("landmark",landMarknames[position])

            val bitmap = landMarkImages[position]

            val global = Globals
            global.chosenImage = bitmap

            startActivity(intent)
         }
    }
}
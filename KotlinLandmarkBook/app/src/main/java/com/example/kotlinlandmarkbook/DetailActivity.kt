package com.example.kotlinlandmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlinlandmarkbook.databinding.ActivityDetailBinding
import com.example.kotlinlandmarkbook.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val name = intent.getStringExtra("landmark")
        var  textView = binding.textView
        textView.text = name
        var  imageView = binding.imageView

        val image = Globals.Chosen.returnImage()
        imageView.setImageBitmap(image)

    }
}
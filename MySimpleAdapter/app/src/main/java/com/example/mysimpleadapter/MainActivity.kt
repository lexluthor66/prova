package com.example.mysimpleadapter


import android.os.Bundle


import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Because SimpleAdapter works with static
        // data so we need to initialize static data

        // This is the array for TitleText
        val titles = arrayOf("Distensioni panca piana", "Test2", "Test3")

        // This array is for SubtitleText
        val subtitles= arrayOf("Ripetizioni 3 x 10", "This is test2 subtitle", "This is test3 subtitle")
        val csubtitles= arrayOf("Riposo 30'", "Riposo 15'", "Riposo 40'")

        // These are the Id's of the images that will be displayed as avatar
        val images = arrayOf(R.mipmap.ic_panca_piana, R.drawable.ic_test2, R.drawable.ic_test3)

        // Instantiating our data List, which is a list of HashMap
        val data: MutableList<HashMap<String, String>> = mutableListOf()

        // Populating our data List with the
        // arrays that we have already defined
      //  for (i in titles.indices) {
        for (i in titles.indices) {
            val cur: HashMap<String, String> = HashMap()
            cur["titleText"] = titles[i]
            cur["subtitleText"] = subtitles[i]
            cur["csubtitleText"] = csubtitles[i]
            cur["avatarImage"] = "${images[i]}"
            data.add(cur)
        }

        // From and To array which will be used to map, HashMap values
        // to the Views that are defined in the XML file (in our case list_item.xml)
        val from = arrayOf("avatarImage", "titleText","subtitleText", "csubtitleText")
        val to = intArrayOf(R.id.avatarImageView, R.id.titleTextView, R.id.subtitleTextView,  R.id.csubtitleTextView)

        // Instantiating customSimpleAdapter with the above values
        val customSimpleAdapter = CustomSimpleAdapter(this, data, R.layout.list_item, from, to)

        // Getting reference of listView which is defined in activity_main.xml
        val listView = findViewById<ListView>(R.id.listView)

        // Finally, setting adapter to our customSimpleAdapter
        listView.adapter = customSimpleAdapter
    }
}

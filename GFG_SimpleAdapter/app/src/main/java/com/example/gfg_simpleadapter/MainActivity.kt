package com.example.gfg_simpleadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    // creating  a String type array
    // (fruitNames) which contains
    // names of different fruits' images
    private val fruitNames=arrayOf("Banana","Grape","Guava","Mango","Orange","Watermelon")
    private val commentName=arrayOf("buona","cattiva","discreta","orribile","non so","meglio altro")

    // creating an Integer type array (fruitImageIds) which
    // contains IDs of different fruits' images
    private val fruitImageIds=arrayOf(R.drawable.icon_beans,
        R.drawable.icon_artichoke,
        R.drawable.icon_asparagus,
        R.drawable.icon_bell_pepper,
        R.drawable.icon_peas,
        R.drawable.icon_turnip)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewBinding the ListView  of activity_main.xml file
        // with this kotlin code in MainActivity.kt
        listView=findViewById(R.id.listView)

        // creating an ArrayList of HashMap.The kEY of the HashMap is
        // a String and VALUE is of any datatype(Any)
        val list=ArrayList<HashMap<String,Any>>()

        // By a for loop, entering different types of data in HashMap,
        // and adding this map including it's datas into the ArrayList
        // as list item and this list is the second parameter of the SimpleAdapter
        for(i in fruitNames.indices){
            val map=HashMap<String,Any>()

            // Data entry in HashMap
            map["fruitName"] = fruitNames[i]
            map["fruitImage"]=fruitImageIds[i]
            map["commentName"]=commentName[i]


            // adding the HashMap to the ArrayList
            list.add(map)
        }

        // creating A string type array(from) which contains
        // column names for each View in each row of the list
        // and this array(form) is the fourth parameter of the SimpleAdapter
        val from=arrayOf("fruitName","fruitImage")

        // creating an integer type array(to) which contains
        /*id of each View in each row of the list
                and this array(form) is the fifth parameter of the SimpleAdapter*/

        val to= intArrayOf(R.id.textView,R.id.imageView)

        // creating an Object of SimpleAdapter
        // class and passing
        // all the required parameters
        val simpleAdapter= SimpleAdapter(this,list,R.layout.list_row_items,from,to)

        // now setting the simpleAdapter
        // to the ListView
        listView.adapter = simpleAdapter
    }
}
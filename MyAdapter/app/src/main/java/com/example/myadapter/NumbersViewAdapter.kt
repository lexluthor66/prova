package com.example.myadapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class NumbersViewAdapter  // invoke the suitable constructor of the ArrayAdapter class
    (context: Context, arrayList: ArrayList<NumbersView?>?) :
    ArrayAdapter<NumbersView?>(context, 0, arrayList!!) {
    override fun getView(position: Int,  convertView: View?, parent: ViewGroup): View {

        // convertView which is recyclable view
        var currentItemView = convertView

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView =
                LayoutInflater.from(context).inflate(R.layout.row, parent, false)
        }

        // get the position of the view from the ArrayAdapter
        val currentNumberPosition: NumbersView? = getItem(position)

        // then according to the position of the view assign the desired image for the same
        val numbersImage = currentItemView!!.findViewById<ImageView>(R.id.imageView)
        assert(currentNumberPosition != null)
        if (currentNumberPosition != null) {
            numbersImage.setImageResource(currentNumberPosition.getNumbersImageId())
        }

        // then according to the position of the view assign the desired TextView 1 for the same
        val textView1 = currentItemView.findViewById<TextView>(R.id.textView1)
        textView1.text = currentNumberPosition!!.getNumberInDigit()

        // then according to the position of the view assign the desired TextView 2 for the same
        val textView2 = currentItemView.findViewById<TextView>(R.id.textView2)
        textView2.text = currentNumberPosition.getNumbersInText()

        // then return the recyclable view
        return currentItemView
    }
}
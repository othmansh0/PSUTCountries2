package com.example.psutcountriesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countrySpinner: Spinner = findViewById(R.id.counrtySpinner)
        var countryImage: ImageView = findViewById(R.id.country_image)
        var button: Button = findViewById(R.id.button)
        val countries = arrayOf("USA", "Canada", "Mexico", "France", "Germany", "Spain")
        val countryImages = arrayOf(R.drawable.usaflag,R.drawable.canadaflag,R.drawable.mexicoflag,R.drawable.franceflag,R.drawable.germanyflag,R.drawable.spainflag)

        countrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCountry = parent.getItemAtPosition(position) as String
                // Do something with the selected item
        println(selectedCountry)
                val selectedImage = countryImages[position]
                countryImage.setImageResource(selectedImage)
                countryImage.visibility = View.VISIBLE
                button.visibility = View.VISIBLE
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        countrySpinner.adapter = adapter



        button.setOnClickListener {
            if (countryImage.visibility == View.VISIBLE) {
                countryImage.visibility = View.GONE
                button.text = "Show Flag"
            } else {
                countryImage.visibility = View.VISIBLE
                button.text = "Hide Flag"
            }
        }
    }



}
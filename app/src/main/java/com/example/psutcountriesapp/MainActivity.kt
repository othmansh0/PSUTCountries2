package com.example.psutcountriesapp

import CountryInfoDialogFragment
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val countries = arrayOf("USA", "Canada", "Mexico", "France", "Germany", "Spain")
    val countryDistances = arrayOf(11000, 8000, 12000, 4000, 6000, 7000)
    val countryCurrencies = arrayOf("USD", "CAD", "MXN", "EUR", "EUR", "EUR")
    val countryInfos = arrayOf("Located in North America.", "Has two official languages, English and French", "The third most populous country in Latin America", "Known for its rich history, art, and culture", "Located in Central Europe.", "Located in Southern Europe")
    var index11: Int = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var infoTextView:TextView = findViewById(R.id.textView33)
        var countrySpinner: Spinner = findViewById(R.id.counrtySpinner)
        var countryImage: ImageView = findViewById(R.id.country_image)
        var button: Button = findViewById(R.id.button)

        val countryImages = arrayOf(R.drawable.usaflag,R.drawable.canadaflag,R.drawable.mexicoflag,R.drawable.franceflag,R.drawable.germanyflag,R.drawable.spainflag)


        countrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCountry = parent.getItemAtPosition(position) as String
                index11 = position
                infoTextView.text = countryInfos[index11]
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_distance -> {
                val dialog = CountryInfoDialogFragment.newInstance(countries[index11],countryDistances[index11],countryCurrencies[index11])
                dialog.show(supportFragmentManager, "CountryInfoDialogFragment")

                return true
            }

            R.id.action_currency -> {

                var infoTextView:TextView = findViewById(R.id.textView33)
                infoTextView.text = countryInfos[index11]
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }







}
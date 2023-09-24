package com.example.pertemuan6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.pertemuan6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = arrayOf(
            "Indonesia",
            "Malaysia",
            "Brunei",
            "Filipina",
            "Timor Leste"
        )

        val cities = resources.getStringArray(R.array.cities)

        with(binding){
            val countriesAdapter = ArrayAdapter(this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,countries)

            countriesAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

                spinCountries.adapter= countriesAdapter

            val citiesAdapter = ArrayAdapter(this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,cities)

            citiesAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

            spinCities.adapter= citiesAdapter

            var selectedDate = ""
            datePick.init(datePick.year, datePick.month, datePick.dayOfMonth){
                _,year,month,day ->
                selectedDate="$day/${month+1}/$year"
                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }

            var selectedTime =""
            timePicker.setOnTimeChangedListener{_, hourOfDay, minutes ->
                selectedTime = String.format("%20d:%20d", hourOfDay, minutes)
                Toast.makeText(this@MainActivity,selectedTime, Toast.LENGTH_SHORT).show()
            }

        }
    }
}
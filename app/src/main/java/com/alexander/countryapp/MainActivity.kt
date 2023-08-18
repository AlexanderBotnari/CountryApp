package com.alexander.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alexander.countryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val countryName = binding.editTextTextPersonName.text.toString()
            val country:Country = restCountriesApi.getCountryByName(countryName).get(0)
            binding.countryNameTextView.setText(country.name)
            binding.capitalTextView.setText(country.capital)

        }
    }
}
package com.alexander.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.alexander.countryapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            lifecycleScope.launch {
                try{
                    val countryName = binding.editTextCountryName.text.toString()
                    val countries = restCountriesApi.getCountryByName(countryName)
                    val country = countries[0]
                    binding.countryNameTextView.text = country.name
                    binding.capitalTextView.text = country.capital
                    binding.areaTextView.text = formatNumber(country.area)
                    binding.populationTextView.text = formatNumber(country.population)
                    binding.languagesTextView.text = languagesToString(country.languages)
                    loadSvg(binding.flagImageView, country.flag)

                    binding.resultLayout.visibility = View.VISIBLE
                    binding.statusLayout.visibility = View.INVISIBLE
                }catch (e: Exception){
                    binding.statusImageView.setImageResource(R.drawable.ic_baseline_error_outline_24)
                    binding.statusTextView.text = "Invalid country"
                    binding.resultLayout.visibility = View.INVISIBLE
                    binding.statusLayout.visibility = View.VISIBLE
                }
            }
        }
    }
}
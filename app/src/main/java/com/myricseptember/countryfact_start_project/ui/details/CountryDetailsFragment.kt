package com.myricseptember.countryfact.ui.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myricseptember.countryfact.CountryFactApp
import com.myricseptember.countryfact.data.model.Country
import com.myricseptember.countryfact_start_project.R
import kotlinx.android.synthetic.main.fragment_country_details.*

class CountryDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_country_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val countryId = arguments?.getInt(getString(R.string.country_id))
        countryId?.let {
            val countryDetails = (activity?.application as CountryFactApp)
                .getCountryRepository()
                .findCountry(countryId)
            populateCountryDetails(countryDetails)
        }
    }

    private fun populateCountryDetails(country: Country?) {
        nameTextView.text = country?.name
        populationTextView.text = country?.population
        largestCityTextView.text = country?.largest_city
        capitalCityTextView.text = country?.capital_city
        majorLangTextView.text = country?.major_language
        majorReligionTextView.text = country?.major_religion
        monetaryUnitTextView.text = country?.monetary_unit
        (activity as AppCompatActivity).supportActionBar?.title = country?.name
    }
}
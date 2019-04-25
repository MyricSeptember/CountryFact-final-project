package com.myricseptember.countryfact.data

import android.app.Application
import com.myricseptember.countryfact.data.model.Country
import com.myricseptember.countryfact.data.network.CountryInfoProvider

class CountryRepository(application: Application) {

    fun getAllCountries(): List<Country> {
        val allCountries = CountryInfoProvider.countryList
        return allCountries.reversed()
    }

    fun findCountry(id: Int): Country? {
        for (country in CountryInfoProvider.countryList) {
            if (country.id == id) {
                return country
            }
        }
        return null
    }
}
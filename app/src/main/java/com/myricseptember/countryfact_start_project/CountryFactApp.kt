package com.myricseptember.countryfact

import android.app.Application
import com.myricseptember.countryfact.data.CountryRepository

class CountryFactApp:Application() {
    fun getCountryRepository() = CountryRepository(this)
}
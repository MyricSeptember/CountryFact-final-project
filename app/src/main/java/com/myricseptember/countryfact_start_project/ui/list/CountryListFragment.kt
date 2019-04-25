package com.myricseptember.countryfact.ui.list

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myricseptember.countryfact.CountryFactApp
import com.myricseptember.countryfact.data.model.Country
import com.myricseptember.countryfact.ui.details.CountryDetailsActivity
import com.myricseptember.countryfact_start_project.R
import kotlinx.android.synthetic.main.fragment_country_list.*

class CountryListFragment : Fragment(),
    CountryListAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()

        val country = (activity?.application as CountryFactApp).getCountryRepository().getAllCountries()


        populateCountryList(country)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    private fun populateCountryList(countryList: List<Country>) {
        countryRecyclerView.adapter = CountryListAdapter(countryList, this)
    }

    override fun onItemClick(country: Country, itemView: View) {
        val detailsIntent = Intent(context, CountryDetailsActivity::class.java)
        detailsIntent.putExtra(getString(R.string.country_id), country.id)
        startActivity(detailsIntent)
    }
}
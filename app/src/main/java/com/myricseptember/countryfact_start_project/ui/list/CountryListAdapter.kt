package com.myricseptember.countryfact.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myricseptember.countryfact.data.model.Country
import com.myricseptember.countryfact_start_project.R
import kotlinx.android.synthetic.main.layout_list_item.view.*

class CountryListAdapter(
    private val items: List<Country>,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(country: Country, itemView: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(items[position], clickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(country: Country, listener: OnItemClickListener) = with(itemView) {
            TextViewCoutryName.text = country.name

            setOnClickListener {
                listener.onItemClick(country, it)
            }
        }

    }
}
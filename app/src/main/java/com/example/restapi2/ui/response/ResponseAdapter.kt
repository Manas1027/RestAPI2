package com.example.restapi2.ui.response

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi2.R
import com.example.restapi2.model.Rezultat
import kotlinx.android.synthetic.main.item_reponse.view.*

class ResponseAdapter: RecyclerView.Adapter<ResponseAdapter.SchoolClassViewHolder>() {

    var models: List<Rezultat> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClicked: (id: Int) -> Unit = {_ ->}

    inner class SchoolClassViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populateModel(model: Rezultat?){
            itemView.tvName.text = HtmlCompat.fromHtml(model?.title!!, HtmlCompat.FROM_HTML_MODE_COMPACT)
            itemView.setOnClickListener{
                onItemClicked.invoke(model.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolClassViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_reponse, parent, false)
        return SchoolClassViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SchoolClassViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int {
        return models.size ?: 0
    }
}
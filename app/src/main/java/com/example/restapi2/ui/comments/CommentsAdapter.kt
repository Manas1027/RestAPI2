package com.example.restapi2.ui.comments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi2.R
import com.example.restapi2.model.Comment
import kotlinx.android.synthetic.main.item.view.*

class CommentsAdapter: RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {


    var models: List<Comment> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }



    inner class CommentsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populateModel(model: Comment){
            itemView.tvName.text = HtmlCompat.fromHtml(model.text, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return CommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int {
        return models.size ?: 0
    }
}
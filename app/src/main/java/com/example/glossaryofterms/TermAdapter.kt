package com.example.glossaryofterms

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TermAdapter(private val termList: MutableList<String>, private val favoriteActivity: Boolean = false):RecyclerView.Adapter<TermAdapter.TermHolder>() {
    class TermHolder(item: View,favoriteActivity: Boolean):RecyclerView.ViewHolder(item),View.OnClickListener {
        val termText:TextView = item.findViewById(R.id.termTextView)
        val addTerm:ImageView = item.findViewById(R.id.addImageView)
        var bool = favoriteActivity
        override fun onClick(p0: View?) {
            if (bool)
                Toast.makeText(p0?.context,"Term deleted from bookmarks",Toast.LENGTH_SHORT).show()
            else {
                Toast.makeText(p0?.context,"Term add to bookmarks",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int,): TermHolder {
        return if (favoriteActivity) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_term_item,parent,false)
            TermHolder(view,favoriteActivity)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.add_term_item,parent,false)
            TermHolder(view,favoriteActivity)
        }

    }

    override fun onBindViewHolder(holder: TermHolder, position: Int) {

        holder.termText.text= termList[position]
        holder.addTerm.setOnClickListener(){
            holder.onClick(holder.itemView)
            when (holder.addTerm.tag){
                "delete" ->  {
                    Log.d("Click","$position удалить")
                    termList.removeAt(position)
                    notifyDataSetChanged();
                }
                 "add" -> {
                     Log.d("Click", "$position добавить")
                 }

            }
        }
    }


    override fun getItemCount(): Int {
        return termList.size
    }

}



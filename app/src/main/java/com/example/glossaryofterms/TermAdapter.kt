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
    class TermHolder(item: View):RecyclerView.ViewHolder(item) {
        val termText:TextView = item.findViewById(R.id.termTextView)
        val addTerm:ImageView = item.findViewById(R.id.addImageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermHolder {
        return if (favoriteActivity) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_term_item,parent,false)
            TermHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.add_term_item,parent,false)
            TermHolder(view)
        }

    }

    override fun onBindViewHolder(holder: TermHolder, position: Int) {
        holder.termText.text= termList[position]
        holder.addTerm.setOnClickListener(){
            //fun onClick(view:View) {Toast.makeText(Context,"Term add to bookmark",Toast.LENGTH_SHORT).show()}
            when (holder.addTerm.tag){
                "delete" ->  {
                    Log.d("Click","$position удалить")
                    termList.removeAt(position)
                }
                 "add" -> Log.d("Click", "$position добавить")
            }
        }


    }



    override fun getItemCount(): Int {
        return termList.size
    }
}



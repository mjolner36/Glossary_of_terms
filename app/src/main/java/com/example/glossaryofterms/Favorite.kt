package com.example.glossaryofterms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.glossaryofterms.databinding.FragmentFavoriteBinding


class Favorite : Fragment() {
    var favoriteArray = mutableListOf<Int>(1,5,17,10,3,6)
    lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater,container,false);
        init()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = Favorite()
    }

    private fun init(){

        binding.apply {
            rcViewFavorite.layoutManager = LinearLayoutManager(activity)
            rcViewFavorite.adapter = TermAdapter(getTermList(),true)
        }
    }

    private fun getTermList(): MutableList<String> {
        var favoriteTermsArray = this.resources.getStringArray(R.array.Terms).toMutableList()
        var tempArray = mutableListOf<String>()
       for ((position, item) in favoriteArray.withIndex()){
           tempArray.add(position,favoriteTermsArray[item])
        }
        return tempArray
        }

}
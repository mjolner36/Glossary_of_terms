package com.example.glossaryofterms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.glossaryofterms.databinding.FragmentVocabularyBinding


class Vocabulary : Fragment() {

    lateinit var binding: FragmentVocabularyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVocabularyBinding.inflate(inflater,container,false);
        init()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Vocabulary()

    }


    private fun init(){
        val meaningList =  resources.getStringArray(R.array.Meaning).toMutableList()
        var tinydb = TinyDB(activity?.applicationContext)
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(activity)
            rcView.adapter = TermAdapter(getTermList(), meaningList = meaningList, tinyDB = tinydb)
        }
    }

    private fun getTermList(): MutableList<String> {
        return this.resources.getStringArray(R.array.Terms).toMutableList()
    }

}
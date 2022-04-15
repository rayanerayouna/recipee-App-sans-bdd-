package com.example.myapplication1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.adapter.RecipeeAdapter
import com.example.myapplication1.adapter.RecipeeAdapter2

class maps : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.fragment_maps, container, false)
        // creer une liste pour
        // recuperer le recyclerview haut
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_haut)
        horizontalRecyclerView.adapter = RecipeeAdapter()

        // recuperer le recyclerview bas
       val horizontalRecyclerView2 = view.findViewById<RecyclerView>(R.id.recyclerView_bas)
        horizontalRecyclerView2.adapter = RecipeeAdapter2()

        return view
    }



}
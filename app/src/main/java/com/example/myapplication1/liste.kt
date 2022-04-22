package com.example.myapplication1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class liste() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? { return inflater.inflate(R.layout.liste, container, false)
       /* val favoris = view?.findViewById<RecyclerView>(R.id.recycletView_favoris)
        favoris?.adapter = RecipeeAdapter3(context,)
        favoris?.layoutManager= LinearLayoutManager(context)*/

        return view
    }

}

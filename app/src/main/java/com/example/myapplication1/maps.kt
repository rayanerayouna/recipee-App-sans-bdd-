package com.example.myapplication1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.adapter.RecipeeAdapter
import com.example.myapplication1.adapter.RecipeeAdapter2
import com.example.myapplication1.dataBase.Recipe_Class

class maps() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.fragment_maps, container, false)
       //crrer une liste de recette
        val recettelist = arrayListOf<Recipe_Class>()
        // enregistrer une recette
        recettelist.add(
            Recipe_Class("mousse au chocolat", R.drawable.dessert1, true))
        recettelist.add(
            Recipe_Class("riz au poulet ", R.drawable.cat_img, false))
        recettelist.add(
            Recipe_Class("entré", R.drawable.bg_splash, true))
        recettelist.add(
            Recipe_Class("framboisier", R.drawable.dessert2, true))
        recettelist.add(
            Recipe_Class("fondant", R.drawable.soupe_au_carote, true))
        recettelist.add(
            Recipe_Class("thai", R.drawable.thai, true))
        recettelist.add(
            Recipe_Class("quiche", R.drawable.quiche, true))
        recettelist.add(
            Recipe_Class("vol_au_vent", R.drawable.vol_au_vent, true))
        recettelist.add(
            Recipe_Class("tarte_dautomne", R.drawable.tarte_dautomne, true))
        recettelist.add(
            Recipe_Class("salade_chiken", R.drawable.salade_chiken, true))
        recettelist.add(
            Recipe_Class("poulet_champignon", R.drawable.poulet_champignon, true))

        // recuperer le recyclerview haut
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_haut)
        horizontalRecyclerView.adapter = RecipeeAdapter(recettelist)

        // recuperer le recyclerview bas
       val horizontalRecyclerView2 = view.findViewById<RecyclerView>(R.id.recyclerView_bas)
        horizontalRecyclerView2.adapter = RecipeeAdapter2(recettelist)

        return view
    }



}
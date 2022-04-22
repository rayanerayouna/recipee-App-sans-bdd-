package com.example.myapplication1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.dataBase.Recipe_Class

class RecipeeAdapter2(
    private val recettelist: List<Recipe_Class>
): RecyclerView.Adapter<RecipeeAdapter2.ViewHolder>(){

    class  ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val recetteImage = view.findViewById<ImageView>(R.id.img_item)
        val recettename : TextView?= view.findViewById(R.id.text_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meal2,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //recuperer les informations de la liste
        val currentRecette = recettelist[position]
        // recuperer l'image a partir de son lien
        holder.recetteImage.setImageResource(currentRecette.image)
        // mettre a jour le nom de l'image
        holder.recettename?.text = currentRecette.nom
    }
    override fun getItemCount(): Int = recettelist.size
}
package com.example.myapplication1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.dataBase.Recipe_Class


class RecipeeAdapter(
    private val recetteliste: List<Recipe_Class>):RecyclerView.Adapter<RecipeeAdapter.ViewHolder>(){

    class  ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val recetteImage = view.findViewById<ImageView>(R.id.img_item)
        val recettename: TextView? = view.findViewById(R.id.text_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meal,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //recuperer les informations de la liste
        val currentRecette = recetteliste[position]
        //recuperer  l'image à  partir de son lien
        holder.recetteImage.setImageResource(currentRecette.image)
        // mettre a jour le nom de l'image
        holder.recettename?.text = currentRecette.nom
        // verifier si la photo  a éte liké
        if(currentRecette.liked){
            holder.starIcon.setImageResource(R.drawable.ic_star)
        }else{
            holder.starIcon.setImageResource(R.drawable.ic_unstar)
        }
        /*
        // clicklistener sur l'item1
        holder.itemView.setOnClickListener{
            recipe_detail(this).show()
        }*/
    }
    override fun getItemCount(): Int = recetteliste.size
}



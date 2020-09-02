package com.example.pruebakotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.pojo.Superheores

class SuperheroesAdaptador (var list: List<Superheores>):RecyclerView.Adapter<SuperheroesAdaptador.SuperheroeHolder>(){

    fun updateData(listSuperheroes: List<Superheores>) {
        Log.d("ACTUALIZA", "update ${listSuperheroes.size}")
        list = listSuperheroes

        //metodo del recyclerView
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroeHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.contendor_items,parent,false)
        return SuperheroeHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SuperheroeHolder, position: Int) {

        val superheroe=list[position]
        holder.id.text=superheroe.id.toString()
        holder.nombre.text=superheroe.name
        holder.slug.text=superheroe.slug

    }

    class SuperheroeHolder(view:View):RecyclerView.ViewHolder(view){

        val id:TextView=itemView.findViewById(R.id.textoID)
        val nombre:TextView=itemView.findViewById(R.id.textoName)
        val slug:TextView=itemView.findViewById(R.id.textoSlug)

    }//class ViewHolder

}//class adaptador
package com.example.pruebakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.pojo.Superheores
import com.example.pruebakotlin.vistamodelo.SuperheroeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var listaSuper= ArrayList<Superheores>()
    lateinit var viewAdapter:SuperheroesAdaptador
    lateinit var mViewModel :SuperheroeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView=findViewById(R.id.recycler)
        recyclerView.layoutManager=LinearLayoutManager(this)

        //iniciando el view model
        mViewModel=ViewModelProvider(this).get(SuperheroeViewModel::class.java)

        //recibe respuesta de retrofit y se ingresan datos a la database
        mViewModel.fetchFromServer()

        //iniciando el adaptador
        viewAdapter= SuperheroesAdaptador(listaSuper)

        //pasando adaptador al recycler
        recyclerView.adapter=viewAdapter

        mViewModel.getDataFromDB().observe(this, Observer {
            viewAdapter.updateData(it)
        })


    }//onCreate
}//class
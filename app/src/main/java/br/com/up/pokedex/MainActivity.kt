package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.adapter.PokeAdapter
import br.com.up.pokedex.network.Api

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView =
            findViewById(R.id.recycler_pokemons)

        recyclerView.layoutManager =
            GridLayoutManager(this, 3)

        Api().getPokemons{ pokemons ->
            if(pokemons != null){
                recyclerView.adapter  =
                    PokeAdapter(pokemons) { pokemon ->

                    }
            }else{
                //TODO Error
            }
        }
    }

}
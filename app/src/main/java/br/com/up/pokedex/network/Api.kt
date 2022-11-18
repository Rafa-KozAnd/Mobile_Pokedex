package br.com.up.pokedex.network

import br.com.up.pokedex.model.PokeListApiResponse
import br.com.up.pokedex.model.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {

    private var retrofit:Retrofit? = null
    private var service:PokeApiService? = null

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

        service = retrofit?.create(PokeApiService::class.java)
    }

    fun getPokemons(listener:(pokemons:List<Pokemon>?) -> Unit){

        service?.getPokemons()?.enqueue(

            object : Callback<PokeListApiResponse>{
                override fun onResponse(
                    call: Call<PokeListApiResponse>,
                    response: Response<PokeListApiResponse>
                ) {
                    listener(response.body()?.pokemons)
                }

                override fun onFailure(call: Call<PokeListApiResponse>, t: Throwable) {
                    listener(null)
                }
            }
        )
    }
}
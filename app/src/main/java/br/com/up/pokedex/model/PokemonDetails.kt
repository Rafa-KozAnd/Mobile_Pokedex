package br.com.up.pokedex.model

data class PokemonDetails(
    val name:String,
    val types:List<Types>,
    val stats:List<Stats>,
    val abilities:List<Abilities>,
    val moves:List<Moves>
)

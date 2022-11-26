package br.com.up.pokedex.model

data class Moves(
    val move:JsonCommonReturn,
    val version_group_details:List<Versao>
)

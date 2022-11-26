package br.com.up.pokedex.model

data class Versao(
    val level_learned_at: String,
    val move_learn_method: JsonCommonReturn,
    val version_group: JsonCommonReturn
)

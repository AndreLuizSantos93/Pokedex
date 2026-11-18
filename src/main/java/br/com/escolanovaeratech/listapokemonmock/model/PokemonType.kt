package br.com.escolanovaeratech.listapokemonmock.model

import android.hardware.lights.Light
import androidx.annotation.ColorRes
import br.com.escolanovaeratech.listapokemonmock.R

enum class PokemonType (
    val displayNome: String,
    @param:ColorRes val colorRes: Int,
    @param:ColorRes val headerColorRes: Int,
    val isLightHeader: Boolean
){
    GRAMA(displayNome = "Grama", colorRes = R.color.type_grass, headerColorRes = R.color.header_grass, true),
    VENENO(displayNome = "Veneno", colorRes = R.color.type_poison, headerColorRes = R.color.header_poison, false),
    FOGO(displayNome = "Fogo", colorRes = R.color.type_fire, headerColorRes = R.color.header_fire, false),
    AGUA(displayNome = "Água", colorRes = R.color.type_water, headerColorRes = R.color.header_water, false),
    ELETRICO(displayNome = "Elétrico", colorRes = R.color.type_electric, headerColorRes = R.color.header_electric, true),
    NORMAL(displayNome = "Normal", colorRes = R.color.type_normal, headerColorRes = R.color.header_normal, true),

    FADA(displayNome = "Fada", colorRes = R.color.type_fairy, headerColorRes = R.color.header_fairy, true),
    FANTASMA(displayNome = "Fantasma", colorRes = R.color.type_ghost, headerColorRes = R.color.header_ghost, false),

}
package cuevas.jorge.composepokedex.utilities

import androidx.compose.ui.graphics.Color
import cuevas.jorge.composepokedex.domain.Pokemon
import cuevas.jorge.composepokedex.ui.theme.Bug
import cuevas.jorge.composepokedex.ui.theme.Electric
import cuevas.jorge.composepokedex.ui.theme.Fairy
import cuevas.jorge.composepokedex.ui.theme.Fight
import cuevas.jorge.composepokedex.ui.theme.Fire
import cuevas.jorge.composepokedex.ui.theme.Flying
import cuevas.jorge.composepokedex.ui.theme.Ghost
import cuevas.jorge.composepokedex.ui.theme.Ground
import cuevas.jorge.composepokedex.ui.theme.Normal
import cuevas.jorge.composepokedex.ui.theme.Poison
import cuevas.jorge.composepokedex.ui.theme.Psych
import cuevas.jorge.composepokedex.ui.theme.Rock
import cuevas.jorge.composepokedex.ui.theme.Water

fun getColorByType(pokemon: Pokemon): Pair<Color, Color> {
    var color: Color = Color.White // Se recomienda inicializar para evitar errores
    var dark = true

    when {
        pokemon.type.lowercase().contains("normal") -> color = Normal
        pokemon.type.lowercase().contains("electric") -> {
            color = Electric
            dark = false
        }
        pokemon.type.lowercase().contains("water") -> {
            color = Water
        }
        pokemon.type.lowercase().contains("fire") -> color = Fire
        pokemon.type.lowercase().contains("fairy") -> {
            color = Fairy
            dark = false
        }
        pokemon.type.lowercase().contains("psychic") -> {
            color = Psych
        }
        pokemon.type.lowercase().contains("fighting") -> {
            color = Fight
            dark = false
        }
        pokemon.type.lowercase().contains("ghost") -> color = Ghost
        pokemon.type.lowercase().contains("bug") -> color = Bug
        pokemon.type.lowercase().contains("poison") -> color = Poison
        pokemon.type.lowercase().contains("ground") -> color = Ground
        pokemon.type.lowercase().contains("rock") -> color = Rock
        pokemon.type.lowercase().contains("flying") -> {
            color = Flying
            dark = false
        }
    }

    val textColor = if (dark) Color.White else Color.Black
    return Pair(color, textColor)
}
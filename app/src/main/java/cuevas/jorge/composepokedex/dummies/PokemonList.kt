package cuevas.jorge.composepokedex.dummies

import cuevas.jorge.composepokedex.R
import cuevas.jorge.composepokedex.domain.Pokemon

val bulbasaur = Pokemon("Bulbasaur", 1, "Grass/Poison",
    "There is a plant seed on its back from the day this Pokémon is born.",
    0.7f, 6.9f, false, "Overgrow", R.drawable.bulbasaur)

val ivysaur = Pokemon("Ivysaur", 2, "Grass/Poison",
    "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs.",
    1.0f, 13.0f, false, "Overgrow", R.drawable.ivysaur)

val venusaur = Pokemon("Venusaur", 3, "Grass/Poison",
    "The plant blooms when it is absorbing solar energy.",
    2.0f, 100.0f, false, "Overgrow", R.drawable.venusaur)

val charmander = Pokemon("Charmander", 4, "Fire",
    "The flame on its tail shows the strength of its life force.",
    0.6f, 8.5f, true, "Blaze", R.drawable.charmander)

val charmeleon = Pokemon("Charmeleon", 5, "Fire",
    "It lashes about with its tail to knock down its foe.",
    1.1f, 19.0f, false, "Blaze", R.drawable.charmeleon)

val charizard = Pokemon("Charizard", 6, "Fire/Flying",
    "Spits fire that is hot enough to melt boulders.",
    1.7f, 90.5f, true, "Blaze", R.drawable.charizard)

val squirtle = Pokemon("Squirtle", 7, "Water",
    "After birth, its back swells and hardens into a shell.",
    0.5f, 9.0f, false, "Torrent", R.drawable.squirtle)

val wartortle = Pokemon("Wartortle", 8, "Water",
    "Often hides in water to stalk unwary prey.",
    1.0f, 22.5f, false, "Torrent", R.drawable.wartortle)

val blastoise = Pokemon("Blastoise", 9, "Water",
    "A brutal Pokémon with pressurized water jets on its shell.",
    1.6f, 85.5f, false, "Torrent", R.drawable.blastoise)

val pikachu = Pokemon("Pikachu", 25, "Electric",
    "When several of these Pokémon gather, their electricity could build and cause lightning storms.",
    0.4f, 6.0f, true, "Static", R.drawable.pikachu)

val raichu = Pokemon("Raichu", 26, "Electric",
    "Its tail discharges electricity into the ground.",
    0.8f, 30.0f, true, "Static", R.drawable.raichu)

val jigglypuff = Pokemon("Jigglypuff", 39, "Normal/Fairy",
    "Uses its alluring eyes to enrapture its foe.",
    0.5f, 5.5f, false, "Cute Charm", R.drawable.jigglypuff)

val gengar = Pokemon("Gengar", 94, "Ghost/Poison",
    "Under a full moon, this Pokémon likes to mimic shadows.",
    1.5f, 40.5f, true, "Cursed Body", R.drawable.gengar)

val snorlax = Pokemon("Snorlax", 143, "Normal",
    "Its stomach is said to be so strong that it can even eat moldy food.",
    2.1f, 460.0f, false, "Immunity", R.drawable.snorlax)

val mewtwo = Pokemon("Mewtwo", 150, "Psychic",
    "Created by a scientist after years of DNA experiments.",
    2.0f, 122.0f, true, "Pressure", R.drawable.mewtwo)

val lucario = Pokemon("Lucario", 448, "Fighting/Steel",
    "By catching the aura emanating from others, it can read thoughts.",
    1.2f, 54.0f, true, "Steadfast", R.drawable.lucario)

val mimikyu = Pokemon("Mimikyu", 778, "Ghost/Fairy",
    "Its actual appearance is unknown.",
    0.2f, 0.7f, false, "Disguise", R.drawable.mimikyu)


val pokemonList = listOf(
    bulbasaur, ivysaur, venusaur,
    charmander, charmeleon, charizard,
    squirtle, wartortle, blastoise,
    pikachu, raichu,
    jigglypuff,
    gengar,
    snorlax,
    mewtwo,
    lucario,
    mimikyu
).apply {
    bulbasaur.evolutions = listOf(ivysaur, venusaur)
    ivysaur.evolutions = listOf(venusaur)

    charmander.evolutions = listOf(charmeleon, charizard)
    charmeleon.evolutions = listOf(charizard)

    squirtle.evolutions = listOf(wartortle, blastoise)
    wartortle.evolutions = listOf(blastoise)

    pikachu.evolutions = listOf(raichu)
}

fun showAllPokemon(): List<Pokemon> {
    return pokemonList
}

fun returnOnePokemon(): Pokemon{
    return pokemonList.get((0..9).random())
}

fun getPokemon(id:Int): Pokemon{
    return pokemonList.filter { pokemon -> pokemon.number == id }.get(0)
}
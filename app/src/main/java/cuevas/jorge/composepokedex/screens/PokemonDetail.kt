package cuevas.jorge.composepokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import cuevas.jorge.composepokedex.R
import cuevas.jorge.composepokedex.components.Ability
import cuevas.jorge.composepokedex.components.Chip
import cuevas.jorge.composepokedex.components.PokemonHeader
import cuevas.jorge.composepokedex.components.PokemonNavigation
import cuevas.jorge.composepokedex.domain.Pokemon
import cuevas.jorge.composepokedex.dummies.returnOnePokemon
import cuevas.jorge.composepokedex.ui.theme.ComposePokedexTheme
import cuevas.jorge.composepokedex.ui.theme.ElectricYellow
import cuevas.jorge.composepokedex.ui.theme.OffWhite
import cuevas.jorge.composepokedex.utilities.getColorByType


@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {
    ComposePokedexTheme {
        val pokemonEjemplo = returnOnePokemon()

        PokemonDetailScreen(
            pokemon = pokemonEjemplo,
            neighbors = Pair(returnOnePokemon(), returnOnePokemon()),
            onNavigate = { id -> /* No hace nada en el preview */ }
        )
    }
}
@Composable
fun PokemonDetailScreen(pokemon: Pokemon, neighbors: Pair<Pokemon?, Pokemon?>, onNavigate: (Int) -> Unit, modifier: Modifier = Modifier) {
    //cambiar color
    Column(Modifier.background(getColorByType(pokemon).first, RectangleShape)) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(pokemon, neighbors, onNavigate)

    }
}



@Composable
fun PokemonCard(pokemon: Pokemon, neighbors: Pair<Pokemon?, Pokemon?>, onNavigate: (Int) -> Unit){
    Box(contentAlignment = Alignment.TopCenter){
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = pokemon.name,
            modifier = Modifier
                .offset(x = 0.dp, y = -80.dp)
                .zIndex(2f)
                .size(130.dp),
            contentScale = ContentScale.Fit
        )
        Card(Modifier.fillMaxWidth().fillMaxHeight(), elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = OffWhite)){
            Column(Modifier.fillMaxWidth()) {
                Chip(pokemon.type, getColorByType(pokemon).first, Modifier.padding(top = 70.dp).align(Alignment.CenterHorizontally))
                Row(modifier = Modifier.fillMaxWidth(.8f).align(Alignment.CenterHorizontally).padding(top = 15.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                    Column() {
                        Ability("row", "Altura" ,"${pokemon.height}m")
                        Ability("row", "Peso" ,"${pokemon.weight}kg")

                    }
                    Ability("column", "Habilidad", "${pokemon.ability}")
                }
                Row(Modifier.fillMaxWidth(.8f).align(Alignment.CenterHorizontally).padding(25.dp)) {
                    Text(pokemon.description)

                    Spacer(modifier = Modifier.weight(1f))

                }
                Spacer(modifier = Modifier.weight(1f))

                // NAVEGACION
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .padding(bottom = 50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PokemonNavigation("left", neighbors.first, onNavigate)
                    Spacer(modifier = Modifier.weight(1f))
                    PokemonNavigation("right", neighbors.second, onNavigate)
                }

            }


        }
    }

}
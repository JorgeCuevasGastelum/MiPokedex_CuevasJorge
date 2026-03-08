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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.style.TextAlign
import cuevas.jorge.composepokedex.components.Ability
import cuevas.jorge.composepokedex.components.Chip
import cuevas.jorge.composepokedex.components.PokemonHeader
import cuevas.jorge.composepokedex.components.PokemonNavigation
import cuevas.jorge.composepokedex.domain.Pokemon
import cuevas.jorge.composepokedex.dummies.returnOnePokemon
import cuevas.jorge.composepokedex.ui.theme.ComposePokedexTheme
import cuevas.jorge.composepokedex.ui.theme.OffWhite
import cuevas.jorge.composepokedex.utilities.getColorByType


@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {
    ComposePokedexTheme {
        val pokemonEjemplo = returnOnePokemon()

        PokemonDetailScreen(
            pokemon = pokemonEjemplo,
            //EN EL PREVIEW SON ALEATORIOS NO ESTAN EN ORDEN
            neighbors = Pair(returnOnePokemon(), returnOnePokemon()),
            onNavigate = { id -> },
            onBack = {}
        )
    }
}
@Composable
fun PokemonDetailScreen(pokemon: Pokemon, neighbors: Pair<Pokemon?, Pokemon?>, onNavigate: (Int) -> Unit,  modifier: Modifier = Modifier, onBack: () -> Unit) {
    Column(Modifier.background(getColorByType(pokemon).first, RectangleShape)) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav, onBack)
        PokemonCard(pokemon, neighbors, onNavigate)

    }
}



@Composable
fun PokemonCard(pokemon: Pokemon, neighbors: Pair<Pokemon?, Pokemon?>, onNavigate: (Int) -> Unit) {
    Box(contentAlignment = Alignment.TopCenter) {
        // IMAGEN PRINCIPAL
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = pokemon.name,
            modifier = Modifier
                .offset(x = 0.dp, y = -80.dp)
                .zIndex(2f)
                .size(150.dp),
            contentScale = ContentScale.Fit
        )

        Card(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = OffWhite)
        ) {
            Column(Modifier.fillMaxWidth()) {
                // CABECERA
                Chip(pokemon.type, getColorByType(pokemon).first, Modifier.padding(top = 70.dp).align(Alignment.CenterHorizontally))

                Row(modifier = Modifier.fillMaxWidth(.8f).align(Alignment.CenterHorizontally).padding(top = 15.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Column {
                        Ability("row", "Altura", "${pokemon.height}m")
                        Ability("row", "Peso", "${pokemon.weight}kg")
                    }
                    Ability("column", "Habilidad", pokemon.ability)
                }

                Text(
                    text = pokemon.description,
                    modifier = Modifier.fillMaxWidth(.8f).align(Alignment.CenterHorizontally).padding(25.dp)
                )

                // EVOLUCIONES
                if (pokemon.evolutions.isNotEmpty()) {
                    Text(
                        text = "Evoluciones",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(horizontal = 25.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(pokemon.evolutions) { evolution ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = evolution.image),
                                    contentDescription = evolution.name,
                                    modifier = Modifier.size(60.dp)
                                )
                                Spacer(Modifier.width(16.dp))
                                Text(text = evolution.name, fontSize = 16.sp)
                            }
                        }
                    }
                } else {
                    //si no tiene evoluciones agregamos spacer nomas
                    Spacer(modifier = Modifier.weight(1f))
                }

                // NAVEGACION
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .padding(bottom = 50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // El Spacer en medio empuja los botones a los extremos automaticamente
                    PokemonNavigation("left", neighbors.first, onNavigate)
                    Spacer(modifier = Modifier.weight(1f))
                    PokemonNavigation("right", neighbors.second, onNavigate)
                }
            }
        }
    }
}
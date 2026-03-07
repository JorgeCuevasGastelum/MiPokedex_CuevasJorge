package cuevas.jorge.composepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
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
import cuevas.jorge.composepokedex.components.Ability
import cuevas.jorge.composepokedex.components.Chip
import cuevas.jorge.composepokedex.components.PokemonHeader
import cuevas.jorge.composepokedex.components.PokemonNavigation
import cuevas.jorge.composepokedex.domain.Pokemon
import cuevas.jorge.composepokedex.navigation.MyApp
import cuevas.jorge.composepokedex.screens.PokemonCard
import cuevas.jorge.composepokedex.ui.theme.ComposePokedexTheme
import cuevas.jorge.composepokedex.ui.theme.ElectricYellow
import cuevas.jorge.composepokedex.ui.theme.OffWhite

class MainActivity : ComponentActivity() {

    val pokemon = Pokemon("Pikachu", 25, "Eléctrico", "Descripción", 0.4f, 6.0f, true, "Estática", R.drawable.pikachu)

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                    MyApp()
                }
            }
        }
    }


@Composable
fun PokemonHeader(name: String, number: Int, fav: Boolean){
    Row(Modifier.fillMaxWidth().padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween){
        Column() {
            Text(name)
            Text("#${number}", modifier = Modifier.align(Alignment.End))
        }
        Box {
            Image(painter = painterResource(R.drawable.pokeball), "pokeball image", contentScale = ContentScale.Fit, modifier = Modifier.size(130.dp).offset(30.dp, 20.dp))
            Image(painter = painterResource(if(fav)R.drawable.star_filled else R.drawable.star_outline), contentDescription = if(fav) "star filled" else "star outline", modifier = Modifier.align(Alignment.TopEnd))
        }
    }
}

@Composable
fun PokemonCard(name: String, weight: Float, height: Float, descripcion: String, ability: String, type: String, image: Int){
    Box(contentAlignment = Alignment.TopCenter){
        Image(
            painter = painterResource(id = image),
            contentDescription = name,
            modifier = Modifier
                .offset(x = 0.dp, y = -80.dp)
                .zIndex(2f)
                .size(130.dp),
            contentScale = ContentScale.Fit
        )
        Card(Modifier.fillMaxWidth().fillMaxHeight(), elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = OffWhite)){
            Column(Modifier.fillMaxWidth()) {
                Chip(type, ElectricYellow, Modifier.padding(top = 70.dp).align(Alignment.CenterHorizontally))
            Row(modifier = Modifier.fillMaxWidth(.8f).align(Alignment.CenterHorizontally).padding(top = 15.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                Column() {
                    Ability("row", "Altura" ,"${height}m")
                    Ability("row", "Peso" ,"${weight}kg")

                }
                Ability("column", "Habilidad", "${ability}")
            }
                Row(Modifier.fillMaxWidth(.8f).align(Alignment.CenterHorizontally).padding(25.dp)) {
                    Text(descripcion)

                    Spacer(modifier = Modifier.weight(1f))

                }
                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp).padding(bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //Crear objeto pokemon y enviarlo como parametro se podria hacer aqui
                    PokemonNavigation(
                        position = "left",
                        image = R.drawable.arbok,
                        name = "Arbok",
                        number = 24
                    )

                    PokemonNavigation(
                        position = "right",
                        image = R.drawable.raichu,
                        name = "Raichu",
                        number = 26
                    )
                }

            }


        }
    }

}

@Preview(showBackground = true)
@Composable
fun PokemonHeaderPreview(){
    ComposePokedexTheme(){
        val pokemon = Pokemon("Pikachu", 25, "Eléctrico", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 0.4f, 6.0f, true, "Estática", R.drawable.pikachu)
        Greeting(pokemon)
    }
}

@Composable
fun Greeting(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(Modifier.background(ElectricYellow, RectangleShape)) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(pokemon.name,pokemon.weight, pokemon.height, pokemon.description, pokemon.ability, pokemon.type, pokemon.image)

    }
}

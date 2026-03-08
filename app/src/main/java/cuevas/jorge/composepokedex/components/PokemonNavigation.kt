package cuevas.jorge.composepokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cuevas.jorge.composepokedex.R
import cuevas.jorge.composepokedex.domain.Pokemon
import cuevas.jorge.composepokedex.dummies.returnOnePokemon


@Preview(showBackground = true)
@Composable
fun PokemonNavigationPreview(){
    PokemonNavigation(
        position = "right",
        returnOnePokemon(),
        onNavigate = { id -> /* No hace nada en el preview */ }
    )

}
@Composable
fun PokemonNavigation(
    position: String,
    pokemon: Pokemon?, // Recibe el objeto completo
    onNavigate: (Int) -> Unit // Accion de navegación
) {

    if (pokemon == null) return

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (position == "left") {
            IconButton(
                onClick = { onNavigate(pokemon.number) },
                modifier = Modifier
                    .size(36.dp)
                    .background(Color.DarkGray, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Left",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier.size(70.dp)
            )

            Text("${pokemon.name} N.° ${"%04d".format(pokemon.number)}")
        }

        Spacer(modifier = Modifier.width(8.dp))

        if (position == "right") {
            IconButton(
                onClick = { onNavigate(pokemon.number) },
                modifier = Modifier
                    .size(36.dp)
                    .background(Color.DarkGray, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow Right",
                    tint = Color.White
                )
            }
        }
    }
}
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


@Preview(showBackground = true)
@Composable
fun PokemonNavigationPreview(){
    PokemonNavigation(
        position = "left",
        image = R.drawable.arbok,
        name = "Arbok",
        number = 24
    )

}
@Composable
fun PokemonNavigation(
    position: String,
    image: Int,
    name: String,
    number: Int
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (position == "left") {
            IconButton(
                onClick = { },
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
                painter = painterResource(id = image),
                contentDescription = name,
                modifier = Modifier.size(70.dp)
            )

            Text("$name N.° ${"%04d".format(number)}")
        }

        Spacer(modifier = Modifier.width(8.dp))

        if (position == "right") {
            IconButton(
                onClick = { },
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
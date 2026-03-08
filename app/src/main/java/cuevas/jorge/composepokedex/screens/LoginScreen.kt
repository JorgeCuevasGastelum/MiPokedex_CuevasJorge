package cuevas.jorge.composepokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import cuevas.jorge.composepokedex.R
import cuevas.jorge.composepokedex.ui.theme.ComposePokedexTheme
import cuevas.jorge.composepokedex.ui.theme.OffWhite


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposePokedexTheme() {
        LoginScreen(
            onLoginSuccess = { },
            onGoToRegister = { }
        )
    }
}
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onGoToRegister: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(OffWhite)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //LOGO
        Image(
            painter = painterResource(R.drawable.pokeball),
            contentDescription = "logo",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 20.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "POKEDEX",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 30.dp)
        )

        // CAMPOS DE TEXTO (SOLO VISUALES)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Usuario") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 25.dp)
        )

        // BOTON ENTRAR
        Button(
            onClick = onLoginSuccess,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp)
        ) {
            Text("Entrar")
        }

        // BOTON REGISTRAR
        TextButton(
            onClick = onGoToRegister,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text("¿No tienes cuenta? Regístrate")
        }
    }
}
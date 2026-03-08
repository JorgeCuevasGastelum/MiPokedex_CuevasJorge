package cuevas.jorge.composepokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import cuevas.jorge.composepokedex.R
import cuevas.jorge.composepokedex.ui.theme.ComposePokedexTheme
import cuevas.jorge.composepokedex.ui.theme.OffWhite


@Preview(showBackground = true, name = "Registro View")
@Composable
fun RegisterScreenPreview() {
    ComposePokedexTheme() {
        RegisterScreen(
            onBackToLogin = { }
        )
    }
}

@Composable
fun RegisterScreen(onBackToLogin: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(OffWhite)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // LOGO
        Image(
            painter = painterResource(R.drawable.pokeball),
            contentDescription = "logo",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 15.dp),
            contentScale = ContentScale.Fit
        )

        Text(
            text = "NUEVO USUARIO",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 25.dp)
        )

        // CAMPOS DE TEXTO (SOLO VISUALES)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Nombre Completo") },
            modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = OffWhite,
                focusedContainerColor = OffWhite
            )
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Correo Electrónico") },
            modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = OffWhite,
                focusedContainerColor = OffWhite
            )
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = OffWhite,
                focusedContainerColor = OffWhite
            )
        )

        // BOTON CREAR
        Button(
            onClick = onBackToLogin, // Regresa al login al crear
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp)
        ) {
            Text("Crear Cuenta")
        }

        // BOTON PARA VOLVER
        TextButton(
            onClick = onBackToLogin,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text("¿Ya tienes cuenta? Inicia Sesión")
        }
    }
}
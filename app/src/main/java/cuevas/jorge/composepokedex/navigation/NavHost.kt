package cuevas.jorge.composepokedex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cuevas.jorge.composepokedex.dummies.getPokemon
import cuevas.jorge.composepokedex.dummies.showAllPokemon
import cuevas.jorge.composepokedex.screens.LoginScreen
import cuevas.jorge.composepokedex.screens.PokedexMenuScreen
import cuevas.jorge.composepokedex.screens.PokemonDetailScreen
import cuevas.jorge.composepokedex.screens.RegisterScreen


@Composable
fun MyApp() {
    val navController = rememberNavController()
    val allPokemon = showAllPokemon() // Obtenemos la lista de dummies

    NavHost(navController = navController, startDestination = Login) { // Login como inicio

        //LOGIN
        composable<Login> {
            LoginScreen (
                onLoginSuccess = { navController.navigate(PokemonList) },
                onGoToRegister = { navController.navigate(Register) }
            )
        }
        //REGISTER
        composable<Register> {
            RegisterScreen (onBackToLogin = { navController.popBackStack() })
        }

        //MENU
        composable<PokemonList> {
            PokedexMenuScreen(allPokemon) { id ->
                navController.navigate(PokemonDetail(id))
            }
        }
        composable<PokemonDetail> { backStackEntry ->
            val route: PokemonDetail = backStackEntry.toRoute()
            val pokemon = getPokemon(route.id)

            // tupla (Anterior y Siguiente)
            val currentIndex = allPokemon.indexOfFirst { it.number == route.id }
            val prev = allPokemon.getOrNull(currentIndex - 1)
            val next = allPokemon.getOrNull(currentIndex + 1)

            PokemonDetailScreen(
                pokemon = pokemon,
                neighbors = Pair(prev, next),
                onNavigate = { newId -> navController.navigate(PokemonDetail(newId)) },
                onBack = { navController.popBackStack() } // Esto regresa a la pantalla anterior (el menu)
            )
        }
    }
}
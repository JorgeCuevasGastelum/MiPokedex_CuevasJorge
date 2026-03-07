package cuevas.jorge.composepokedex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cuevas.jorge.composepokedex.dummies.getPokemon
import cuevas.jorge.composepokedex.dummies.showAllPokemon
import cuevas.jorge.composepokedex.screens.PokedexMenuScreen
import cuevas.jorge.composepokedex.screens.PokemonDetailScreen



@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PokemonList) {
        composable<PokemonList> {
            PokedexMenuScreen(showAllPokemon(), onNavigationDetail = {id -> navController.navigate(route = PokemonDetail(id = id))})
        }
        composable<PokemonDetail> { backStackEntry ->
            val pokemon: PokemonDetail = backStackEntry.toRoute()
            PokemonDetailScreen(getPokemon(pokemon.id))
        }
    }
}
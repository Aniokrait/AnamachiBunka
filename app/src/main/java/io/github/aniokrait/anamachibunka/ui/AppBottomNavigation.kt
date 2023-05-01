package io.github.aniokrait.anamachibunka.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.github.aniokrait.anamachibunka.logic.viewmodel.HeritageViewModel
import io.github.aniokrait.anamachibunka.ui.page.HeritageDetailPage

@Composable
fun MyScaffold() {
    val items = listOf(
        Screen.Home,
        Screen.Account,
    )
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                Home(navigate = { heritageId ->
                    navController.navigate(
                        "heritageDetail/$heritageId"
                    )
                })
            }
            composable(Screen.Account.route) { Account(navController) }
            composable(
                Screen.HeritageDetail.route,
                arguments = listOf(navArgument("heritageId") { type = NavType.StringType })
            ) { backStackEntry ->
                val heritageViewModel: HeritageViewModel = hiltViewModel()
                HeritageDetailPage(backStackEntry.arguments?.getString("heritageId"),
                    { id -> heritageViewModel.getHeritageById(id) },
                    heritageViewModel.heritageDetailState

                )
            }
        }
    }
}

@Composable
fun Home(
    heritageViewModel: HeritageViewModel = hiltViewModel(),
    navigate: (Int) -> Unit
) {
    LaunchedEffect(Unit) {
        heritageViewModel.getHeritages()
    }

    Column {
        val heritage = heritageViewModel.uiState.collectAsState().value.heritages
        if(heritage.isNotEmpty()) {
            Button(onClick = { navigate(heritage[0].id) }) {
                Text("${heritage[0].name}")
            }
        }
    }

}

@Composable
fun Account(navController: NavController) {
    println("account")
    Text("Account")
}

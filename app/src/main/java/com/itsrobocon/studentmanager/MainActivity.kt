package com.itsrobocon.studentmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.itsrobocon.studentmanager.nav.HomeScreenRoute
import com.itsrobocon.studentmanager.nav.SplashScreenRoute
import com.itsrobocon.studentmanager.nav.UpsertStudentScreenRoute
import com.itsrobocon.studentmanager.ui.screen.HomeScreen
import com.itsrobocon.studentmanager.ui.screen.SplashScreen
import com.itsrobocon.studentmanager.ui.screen.UpsertStudentScreen
import com.itsrobocon.studentmanager.ui.theme.StudentManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudentManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = SplashScreenRoute
                    ) {
                        composable<SplashScreenRoute> {
                            SplashScreen(
                                modifier = Modifier.padding(innerPadding),
                                onChangePage = { navController.navigate(HomeScreenRoute) }
                            )
                        }

                        composable<HomeScreenRoute> {
                            HomeScreen(
                                modifier = Modifier.padding(innerPadding),
                                onNavigateToUpsert = { nim ->
                                    navController.navigate(UpsertStudentScreenRoute(nim = nim))
                                }
                            )
                        }

                        composable<UpsertStudentScreenRoute> { backStackEntry ->
                            val route: UpsertStudentScreenRoute = backStackEntry.toRoute()
                            UpsertStudentScreen(
                                modifier = Modifier.padding(innerPadding),
                                nim = route.nim,
                                onNavigateBack = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StudentManagerTheme {
        Greeting("Android")
    }
}

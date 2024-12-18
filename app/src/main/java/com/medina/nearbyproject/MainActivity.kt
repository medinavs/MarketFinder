package com.medina.nearbyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.medina.nearbyproject.data.model.NearbyMarket
import com.medina.nearbyproject.ui.screen.home.HomeScreen
import com.medina.nearbyproject.ui.screen.home.HomeViewModel
import com.medina.nearbyproject.ui.screen.market_details.MarketDetailsScreen
import com.medina.nearbyproject.ui.screen.splash.SplashScreen
import com.medina.nearbyproject.ui.screen.welcome.WelcomeScreen
import com.medina.nearbyproject.ui.route.Home
import com.medina.nearbyproject.ui.route.QRCodeScanner
import com.medina.nearbyproject.ui.route.Splash
import com.medina.nearbyproject.ui.route.Welcome
import com.medina.nearbyproject.ui.screen.market_details.MarketDetailsUiEvent
import com.medina.nearbyproject.ui.screen.market_details.MarketDetailsViewModel
import com.medina.nearbyproject.ui.screen.qrcode_scanner.QRCodeScannerScreen
import com.medina.nearbyproject.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()

                val homeViewModel by viewModels<HomeViewModel>()
                val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()

                val marketDetailsViewModel by viewModels<MarketDetailsViewModel>()
                val marketDetailsUiState by marketDetailsViewModel.uiState.collectAsStateWithLifecycle()

                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }

                    composable<Welcome> {
                        WelcomeScreen(onNavigateToHome = {
                            navController.navigate(Home)
                        })
                    }

                    composable<Home> {
                        HomeScreen(
                            onNavigateToMarketDetails = { selectedMarket ->
                                navController.navigate(selectedMarket)
                            },
                            uiState = homeUiState,
                            onEvent = homeViewModel::onEvent
                        )
                    }

                    composable<NearbyMarket> {
                        val selectedMarket = it.toRoute<NearbyMarket>()

                        MarketDetailsScreen(
                            market = selectedMarket,
                            uiState = marketDetailsUiState,
                            onEvent = marketDetailsViewModel::onEvent,
                            onNavigateToQRCodeScanner = {
                                navController.navigate(QRCodeScanner)
                            },
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }

                    composable<QRCodeScanner> {
                        QRCodeScannerScreen(onCompletedScan = { qrCodeContent ->
                            if (!qrCodeContent.isEmpty()) {
                                marketDetailsViewModel.onEvent(
                                    MarketDetailsUiEvent.OnFetchCoupon(
                                        qrCodeContent = qrCodeContent
                                    )
                                )
                            }
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}
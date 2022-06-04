package repleyva.dev.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import repleyva.dev.cryptocurrency.presentation.generics.CryptoCurrencyApp
import repleyva.dev.cryptocurrency.presentation.routes.Navigations

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CryptoCurrencyApp { Navigations() } }
    }
}
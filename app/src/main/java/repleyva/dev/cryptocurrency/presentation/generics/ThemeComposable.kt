package repleyva.dev.cryptocurrency.presentation.generics

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import repleyva.dev.cryptocurrency.presentation.ui.theme.CryptoCurrencyTheme

@Composable
fun CryptoCurrencyApp(content: @Composable () -> Unit) =
    CryptoCurrencyTheme {
        Surface(color = MaterialTheme.colors.background) { content() }
    }
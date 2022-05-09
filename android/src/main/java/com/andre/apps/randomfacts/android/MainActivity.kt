package com.andre.apps.randomfacts.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontStyle
import androidx.lifecycle.coroutineScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ShowText()
            }
        }
    }

    @Composable
    private fun ShowText() {
        val factText: String by vm.getText().collectAsStateLifecycleAware(
            initial = "",
            context = lifecycle.coroutineScope.coroutineContext
        )
        Text(
            factText,
            fontStyle = FontStyle.Italic
        )
    }
}
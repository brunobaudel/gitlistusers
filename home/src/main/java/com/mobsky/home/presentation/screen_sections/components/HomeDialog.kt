package com.mobsky.home.presentation.screen_sections.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ComposableDialog(
    onConfirmButton: () -> Unit = {},
    onDismissButton: () -> Unit = {}
) {

    val shouldShowDialog = remember { mutableStateOf(true) }

    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = { shouldShowDialog.value = false },
            confirmButton = {
                TextButton(onClick = {
                    onConfirmButton()
                    shouldShowDialog.value = false
                }) {
                    Text("Apagar")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    onDismissButton()
                    shouldShowDialog.value = false
                }) {
                    Text("Cancelar")
                }
            },
            icon = { Icon(Icons.Filled.Info, null) },
            title = { Text(text = "Apagar dados de navegação?", fontSize = 20.sp) },
            text = null, //{ Text(text = "Isso vai fazer com que seu histórico de navegação seja completamente apagado.") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
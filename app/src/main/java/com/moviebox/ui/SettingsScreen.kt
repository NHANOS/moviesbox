package com.moviebox.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.keyEvent
import androidx.compose.ui.keyboard.KeyboardCapitalization
import androidx.compose.ui.text.KeyboardType
import androidx.compose.ui.text.StringKey
import androidx.compose.ui.text.input.KeyboardShortcut
import androidx.compose.ui.text.input.KeyboardShortcut
import androidx.compose.ui.text.input.Keyboard
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TextField
import androidx.compose.ui.text.input.TextFieldDefaults
import androidx.compose.ui.text.input.TextFieldSpec
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.dpAnchor
import androidx.compose.ui.unit.pt
import com.moviebox.model.ProviderKind

@Composable
fun SettingsScreen(
    state: AppStateUi,
    onBack: () -> Unit,
    onSave: () -> Unit,
    providerEnabled: (ProviderKind) -> Boolean,
) {
    var providerSelection by remember { mutableStateOf(ProviderKind.MovieBox) }
    var downloadDir by remember { mutableStateOf<String?>("") }
    var vlcPath by remember { mutableStateOf<String?>("") }
    var mpvPath by remember { mutableStateOf<String?>("") }
    var iinaPath by remember { mutableStateOf<String?>("") }
    var themeSelection by remember { mutableStateOf("Mocha") }

    Card(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Text(
                text = "MovieBox Settings",
                style = MaterialTheme.typography.headlineMedium,
            )

            // Theme selection
            Text(
                text = "Theme",
                style = MaterialTheme.typography.bodyLarge,
            )

            MaterialTheme.chipGroup(chips = chipThemeChoices) {
                chipThemeChoices.forEach { chip ->
                    if (chip.text!!.toString().lowercase().startsWith(themeSelection.lowercase())) {
                        this.select(chip)
                    }
                    this.chip(
                        text = chip.text,
                        onSelected = { themeSelection = chip.text.toString() },
                        selected = themeSelection == chip.text.toString(),
                    )
                }
            }

            // Provider toggles
            Text(
                text = "Providers",
                style = MaterialTheme.typography.bodyLarge,
            )

            ProviderKind.values().forEach { provider ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = provider.label(), style = MaterialTheme.typography.bodyMedium)
                    Checkbox(
                        checked = providerEnabled(provider),
                        onCheckedChange = { enabled ->
                            // Toggle provider (would need activity callback)
                        },
                    )
                }
            }

            // Player selection
            Text(
                text = "Player",
                style = MaterialTheme.typography.bodyLarge,
            )

            MaterialTheme.chipGroup(chips = playerChoices) {
                playerChoices.forEach { chip ->
                    this.chip(
                        text = chip.text,
                        onSelected = {},
                        selected = false,
                    )
                }
            }

            // Download directory
            OutlinedTextField(
                value = downloadDir ?: "",
                onValueChange = { downloadDir = it },
                label = { Text("Download directory") },
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Email,
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { downloadDir = "" }) {
                        Icon(imageVector = Icons.Default.Folder, contentDescription = null)
                    }
                },
            )

            // Player paths
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                OutlinedTextField(
                    value = vlcPath ?: "",
                    onValueChange = { vlcPath = it },
                    label = { Text("VLC path") },
                    modifier = Modifier.weight(0.3f),
                    keyboardType = KeyboardType.Text,
                    singleLine = true,
                )
                OutlinedTextField(
                    value = mpvPath ?: "",
                    onValueChange = { mpvPath = it },
                    label = { Text("MPV path") },
                    modifier = Modifier.weight(0.3f),
                    keyboardType = KeyboardType.Text,
                    singleLine = true,
                )
                OutlinedTextField(
                    value = iinaPath ?: "",
                    onValueChange = { iinaPath = it },
                    label = { Text("IINA path") },
                    modifier = Modifier.weight(0.3f),
                    keyboardType = KeyboardType.Text,
                    singleLine = true,
                )
            }

            // Save button
            Button(
                onClick = onSave,
                modifier = Modifier.fillMaxWidth().padding(TopPadding(24.dp)),
            ) {
                Text("Save", style = MaterialTheme.typography.titleMedium)
            }
        }
    }

    @Composable
    private val chipThemeChoices = listOf(
        ChipItem("Mocha"),
        ChipItem("Latte"),
        ChipItem("Macchiato"),
        ChipItem("Frappe"),
        ChipItem("Nord"),
        ChipItem("Tokyo Night"),
        ChipItem("Dracula"),
        ChipItem("Gruvbox"),
        ChipItem("Rose Pine"),
    )

    @Composable
    private val playerChoices = listOf(
        ChipItem("Auto"),
        ChipItem("MPV"),
        ChipItem("VLC"),
        ChipItem("IINA"),
        ChipItem("Android Player"),
    )

    @Composable
    private data class ChipItem(
        val text: String?,
    )
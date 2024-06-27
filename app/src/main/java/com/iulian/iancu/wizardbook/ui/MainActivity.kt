package com.iulian.iancu.wizardbook.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.iulian.iancu.elixirs.ui.AllElixirs
import com.iulian.iancu.spells.ui.AllSpells
import com.iulian.iancu.wizardbook.ui.theme.WizardBookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WizardBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val tabs = listOf(
                        TabItem("Spells", Icons.Filled.Star),
                        TabItem("Elixirs", Icons.Filled.ShoppingCart)
                    )
                    var selectedTabIndex by remember { mutableIntStateOf(0) }

                    Column(modifier = Modifier.padding(innerPadding)) {

                        ScrollableTabRow(
                            selectedTabIndex = selectedTabIndex,
                            edgePadding = 16.dp,
                            contentColor = Color.Gray,
                            indicator = { tabPositions ->
                                TabRowDefaults.Indicator(
                                    color = Color.Black,
                                    modifier = Modifier
                                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                                        .fillMaxWidth()
                                )
                            }
                        ) {
                            tabs.forEachIndexed { index, tab ->
                                Tab(
                                    selected = selectedTabIndex == index,
                                    onClick = { selectedTabIndex = index },
                                    modifier = Modifier.padding(8.dp),
                                    content = {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                imageVector = tab.icon,
                                                contentDescription = tab.title,
                                                modifier = Modifier.size(20.dp)
                                            )
                                            Text(
                                                text = tab.title,
                                                modifier = Modifier
                                                    .padding(8.dp),
                                                color = if (selectedTabIndex == index) Color.Black else Color.Gray
                                            )
                                        }
                                    }
                                )
                            }
                        }
                        when (selectedTabIndex) {
                            0 -> {
                                val elixirs = viewModel.elixirsList.collectAsState()
                                AllElixirs(elixirs = elixirs.value)
                            }

                            1 -> {
                                val spells = viewModel.spellsList.collectAsState()
                                AllSpells(spells = spells.value)
                            }
                        }
                    }
                }
            }
        }
    }
}


data class TabItem(val title: String, val icon: ImageVector)
package com.iulian.iancu.elixirs.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iulian.iancu.elixirs.R
import com.iulian.iancu.elixirs.domain.Elixir

@Composable
fun AllElixirs(elixirs: List<Elixir>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(elixirs) { item ->
            Card(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .background(Color.White)
                    .wrapContentHeight(align = Alignment.Top),
                elevation = CardDefaults.cardElevation(8.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    ElixirImage()
                    ElixirContent(item)
                }
            }
        }
    }
}

@Composable
fun ElixirImage() {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = Color.Red
        ),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.baseline_blender_24),
            contentDescription = "",
            modifier = Modifier.size(70.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ElixirContent(elixir:Elixir) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(text = elixir.name, style = MaterialTheme.typography.bodyLarge)
        elixir.effect?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        elixir.time?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        elixir.sideEffects?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        elixir.difficulty?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        elixir.characteristics?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        LazyColumn {
            items(elixir.ingredients){
                Text(text = it.name, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
@Preview
fun Preview() {
    AllElixirs(
        listOf(
            Elixir("Test", "Test", "TEst", "Test", "Test", "Test", emptyList())
        )
    )
}
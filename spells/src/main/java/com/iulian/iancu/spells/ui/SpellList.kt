package com.iulian.iancu.spells.ui

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
import androidx.compose.ui.unit.dp
import com.iulian.iancu.spells.R
import com.iulian.iancu.spells.domain.Spell

@Composable
fun AllSpells(spells: List<Spell>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(spells) { item ->
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
                    SpellImage()
                    SpellContent(item)
                }
            }
        }
    }
}

@Composable
fun SpellImage() {
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
            painter = painterResource(R.drawable.baseline_mode_edit_24),
            contentDescription = "",
            modifier = Modifier.size(70.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SpellContent(spell: Spell) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(text = "Name: ${spell.name}", style = MaterialTheme.typography.bodyLarge)
        spell.effect?.let {
            Text(
                text = "Effect: $it",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        spell.type?.let {
            Text(
                text = "Magic type: $it",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        spell.incantation?.let {
            Text(
                text = "Incantation: \"$it\"",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        spell.light?.let {
            Text(
                text = "Light: $it",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Text(
            text = "Can be verbal: ${spell.canBeVerbal}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

package com.example.starwarschallenge.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwarschallenge.R
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun CharacterRow(
    id: String,
    name: String,
    description: String,
    isFavorite: MutableStateFlow<Boolean>,
    callBack: (String) -> Unit,
    favoriteCallBack: (String) -> Unit
) {
    val isThisCharacterFavorite by isFavorite.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(start = 16.dp)
            .clickable { callBack(id) },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(69.dp)
                .background(color = Color.White)
                .padding(end = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
            ) {
                Text(
                    text = name,
                    color = Color.Black,
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.h1,
                    fontWeight = FontWeight.W700,
                    lineHeight = 20.29.sp,
                    letterSpacing = 0.25.sp
                )
                Text(
                    text = description,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.W400,
                    lineHeight = 16.71.sp,
                    letterSpacing = 0.25.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        id = if (isThisCharacterFavorite) R.drawable.star_filled else R.drawable.star_empty
                    ),
                    contentDescription = "Favorite Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 16.dp)
                        .clickable { favoriteCallBack(id) }
                )
                Image(
                    painter = painterResource(
                        R.drawable.chevron_right
                    ),
                    contentDescription = "Chevron Right",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(12.dp)
                        .width(7.4.dp)
                )
            }
        }
        Divider(color = Color.LightGray, thickness = 1.dp)
    }

}

@Preview
@Composable
fun CharacterRowPreviewFilled() {
    MaterialTheme() {
        Row(
            modifier = Modifier
                .width(375.dp)
                .height(69.dp),
        ) {
            CharacterRow(
                id = "Luke",
                name = "Luke",
                description = "Jedi",
                isFavorite = MutableStateFlow(true),
                callBack = {}) {}
        }
    }
}

@Preview
@Composable
fun CharacterRowPreviewEmpty() {
    MaterialTheme() {
        Row(
            modifier = Modifier
                .width(375.dp)
                .height(69.dp),
        ) {
            CharacterRow(
                id = "Luke",
                name = "Luke",
                description = "Jedi",
                isFavorite = MutableStateFlow(false),
                callBack = {}) {}
        }
    }
}


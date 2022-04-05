package com.luke.jetpackcomposelazycolumn

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation

@ExperimentalFoundationApi
@Composable
fun GridView(context: Context) {

    LazyVerticalGrid(cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp), modifier = Modifier.fillMaxWidth()) {
        items(items = getData(context)) {movie ->
            Card(
                modifier = Modifier.padding(4.dp),
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = movie.imageUrl,

                        builder = {
                            scale(Scale.FILL)
                            placeholder(R.drawable.placeholder)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = movie.desc
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun GridViewPreview() {
    GridView(context = LocalContext.current)
}
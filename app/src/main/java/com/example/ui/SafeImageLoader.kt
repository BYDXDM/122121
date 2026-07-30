package com.example.ui

import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage

/**
 * Safe version of Image(painter = painterResource(id)) that uses Coil's AsyncImage
 * to load drawable resources safely, avoiding the painterResource → imageResource
 * crash when resources are LayerDrawable instead of BitmapDrawable.
 */
@Composable
fun SafeImage(
    drawableRes: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    val context = LocalContext.current
    val uri = remember(drawableRes) {
        "android.resource://${context.packageName}/$drawableRes"
    }
    AsyncImage(
        model = uri,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale
    )
}

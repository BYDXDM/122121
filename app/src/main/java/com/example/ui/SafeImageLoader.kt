package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

/**
 * Safely loads a drawable resource as a Painter, catching
 * NullPointerException/ClassCastException when resources wrapped
 * in layer-list or adaptive-icon containers fail to cast to BitmapDrawable.
 */
@Composable
fun SafePainterResource(id: Int): Painter? {
    return try {
        painterResource(id = id)
    } catch (e: Exception) {
        null
    }
}

/**
 * Safe version of Image(painter = painterResource(id)) that won't crash
 * on resources that return non-BitmapDrawable types.
 */
@Composable
fun SafeImage(
    drawableRes: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    val painter = SafePainterResource(id = drawableRes)
    if (painter != null) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale
        )
    }
}

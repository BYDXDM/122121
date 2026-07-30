package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun SafePainterResource(id: Int, fallbackId: Int? = null): Painter? {
    return try {
        painterResource(id = id)
    } catch (e: Exception) {
        if (fallbackId != null) {
            try { painterResource(id = fallbackId) } catch (e2: Exception) { null }
        } else null
    }
}

@Composable
fun SafeImage(
    drawableRes: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    fallbackRes: Int? = null
) {
    val painter = SafePainterResource(id = drawableRes, fallbackId = fallbackRes)
    if (painter != null) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale
        )
    }
}
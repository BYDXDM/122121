package com.example.ui

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

/**
 * Safe version of painterResource that won't crash on resources
 * that return non-BitmapDrawable types.
 * Uses remember + Android resource APIs to bypass the Compose layer.
 */
@Composable
fun SafePainterResource(id: Int): Painter? {
    val context = LocalContext.current
    return remember(id) {
        try {
            val res = context.resources
            val drawable = res.getDrawable(id, context.theme)
            if (drawable != null) {
                // Compose can handle any Drawable type via rememberDrawablePainter
                @Suppress("DEPRECATION")
                androidx.compose.ui.graphics.painter.rememberDrawablePainter(drawable)
            } else {
                painterResource(id = id)
            }
        } catch (e: Exception) {
            try {
                painterResource(id = id)
            } catch (e2: Exception) {
                null
            }
        }
    }
}

/**
 * Safe version of Image(painter = painterResource(id)) that won't crash.
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

package app.harry.multiplatformassemble.android.ui.styles

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(content : @Composable () -> Unit) {

    MaterialTheme(
        colors = if (isSystemInDarkTheme()) darkColors else lightColors,
        content = content
    )

}
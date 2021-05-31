package app.harry.multiplatformassemble.android.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.harry.multiplatformassemble.android.ui.components.InsetAwareTopAppBar

@Composable
fun MultiplatformAssembleApp(viewModel: MainActivityViewModel) {
    val members by viewModel.android.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            InsetAwareTopAppBar(title = { Text("MultiplatformAssemble") })
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(members) {
                MemberItemUi(member = it)
            }
        }
    }
}
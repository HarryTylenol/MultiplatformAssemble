package app.harry.multiplatformassemble.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.getViewModel

@Composable
fun MainUi(viewModel: MainActivityViewModel) {
    val members by viewModel.android.collectAsState()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(members) {
            MemberItemUi(member = it)
        }
    }
}
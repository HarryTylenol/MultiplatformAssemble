package app.harry.multiplatformassemble.android

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.harry.multiplatformassemble.domain.Member

@Composable
fun MemberItemUi(member: Member) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(member.name, style = MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.height(10.dp))
        Text(member.level, style = MaterialTheme.typography.subtitle2)
    }
}
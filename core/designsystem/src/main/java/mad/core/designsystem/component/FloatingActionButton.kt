package mad.core.designsystem.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import mad.core.designsystem.icon.CVForgeIcons

@Composable
fun CvForgeFAB(
    modifier: Modifier = Modifier,
    isVisible: Boolean = true,
    isExpanded: Boolean = true,
    onFabClick: () -> Unit,
) {
    AnimatedVisibility(modifier = modifier, visible = isVisible) {
        ExtendedFloatingActionButton(
            onClick = { onFabClick() },
            expanded = isExpanded,
            icon = { Icon(CVForgeIcons.Preview, "Preview Action Button") },
            text = { Text(text = "Preview") },
        )
    }
}


@Composable
fun NavRailFAB(
    modifier: Modifier = Modifier,
    isVisible: Boolean = true,
    onFabClick: () -> Unit,
) {
    AnimatedVisibility(modifier = modifier, visible = isVisible) {
        FloatingActionButton(
            onClick = { onFabClick() }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(CVForgeIcons.Preview, "Preview Action Button")
                Text("Preview")
            }
        }
    }

}


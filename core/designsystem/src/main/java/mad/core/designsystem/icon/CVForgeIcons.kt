package mad.core.designsystem.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Preview
import androidx.compose.material.icons.rounded.Diamond
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings

object CVForgeIcons {
    val Person = Icons.Rounded.Person
    val Settings = Icons.Rounded.Settings
    val Premium = Icons.Rounded.Diamond
    val Preview = Icons.Filled.Preview
    val Error = Icons.Filled.Error
    val ArrowDropDown = Icons.Filled.ArrowDropDown
    val ArrowDropUp = Icons.Filled.ArrowDropUp
}

object CVForgeIconIds {
    const val ID_ICON_PERSON = 0
    const val ID_ICON_SETTINGS = 1
    const val ID_ICON_PREMIUM = 2
    const val ID_ICON_PREVIEW = 3
    const val ID_ICON_ARROW_DROP_DOWN = 4
    const val ID_ICON_ARROW_DROP_UP = 5
}

fun getIconById(id: Int) = when (id) {
    CVForgeIconIds.ID_ICON_PERSON -> CVForgeIcons.Person
    CVForgeIconIds.ID_ICON_SETTINGS -> CVForgeIcons.Settings
    CVForgeIconIds.ID_ICON_PREMIUM -> CVForgeIcons.Premium
    CVForgeIconIds.ID_ICON_PREVIEW -> CVForgeIcons.Preview
    CVForgeIconIds.ID_ICON_ARROW_DROP_DOWN -> CVForgeIcons.ArrowDropDown
    CVForgeIconIds.ID_ICON_ARROW_DROP_UP -> CVForgeIcons.ArrowDropUp
    else -> CVForgeIcons.Error

}
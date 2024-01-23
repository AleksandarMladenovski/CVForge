package mad.feature.resume

import android.widget.GridView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mad.core.designsystem.component.CvForgeFAB
import mad.core.model.template.CvForgeTemplate
import mad.core.model.template.state.TemplateUiState
import mad.feature.preview.PreviewScreen
import mad.feature.preview.PreviewScreenLayout

@Composable
internal fun ResumeRoute(
    isOnePageLayout: Boolean,
    isPreviewEnabled: Boolean,
    onNavigateToPreview: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ResumeViewModel = hiltViewModel(),
) {
    val templateUiState by viewModel.templateUiState.collectAsStateWithLifecycle()
    ResumeScreen(
        templateUiState = templateUiState,
        isOnePageLayout = isOnePageLayout,
        isPreviewEnabled = isPreviewEnabled,
        onNavigateToPreview = onNavigateToPreview,
        modifier = modifier
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ResumeScreen(
    templateUiState: TemplateUiState,
    isOnePageLayout: Boolean,
    isPreviewEnabled: Boolean,
    onNavigateToPreview: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    when(templateUiState){
        TemplateUiState.Loading -> TODO()
        is TemplateUiState.Success -> {

            Column(modifier = modifier.fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxSize()) {
                    ProfileInfoScreen(template = templateUiState.template)
                    CvForgeFAB(
                        isVisible = isOnePageLayout,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(12.dp)
                    ) {
                        val templateId = "1"
                        onNavigateToPreview(templateId)
                    }
                }
                if (!isOnePageLayout and isPreviewEnabled) {
                    PreviewScreenLayout(template = templateUiState.template)
                }
            }
        }
    }
}

@Composable
fun ProfileInfoScreen(template: CvForgeTemplate) {
    Box{
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
        ){
            template.items.forEach { section->
                item(
                    key = section.sectionId
                ){
                   Box(
                       modifier = Modifier
                           .fillMaxWidth()
                           .clickable { }
                   ) {
                   }
                }
                Box{
                    item {  }
                }
            }


        }

        //TODO EXPAND Fab WHEN ITEM IS 0
//        val expandFAB by remember {
//            derivedStateOf {
//                listState.firstVisibleItemIndex > 0
//            }
//        }
    }

}
@Composable
fun ExpandableCard(
    card: ExpandableCardModel,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
) {
    val transitionState = remember {
        MutableTransitionState(expanded).apply {
            targetState = !expanded
        }
    }
    val transition = updateTransition(transitionState, label = "transition")
//    val cardBgColor by transition.animateColor({
//        tween(durationMillis = EXPANSTION_TRANSITION_DURATION)
//    }, label = "bgColorTransition") {
//        if (expanded) cardExpandedBackgroundColor else cardCollapsedBackgroundColor
//    }
    val cardPaddingHorizontal by transition.animateDp({
        tween(durationMillis = 450)
    }, label = "paddingTransition") {
        if (expanded) 48.dp else 24.dp
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = 450)
    }, label = "elevationTransition") {
        if (expanded) 24.dp else 4.dp
    }

    Card(
        elevation = cardElevation,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = cardPaddingHorizontal,
                vertical = 8.dp
            )
    ) {
        Column {
            Box {
                IconButton(
                    onClick = onClick,
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_expand_less_24),
                            contentDescription = "Expandable Arrow",
                            modifier = Modifier.rotate(degrees),
                        )
                    }
                )
                CardTitle(title = card.title)
            }
            ExpandableContent(visible = expanded)
        }
    }
}
//
//@Composable
//fun CollapsibleLayout(modifier: Modifier) {
//    var expanded by remember {
//        mutableStateOf(true)
//    }
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .clickable { expanded = !expanded }
//            .padding(16.dp)
//            .border(1.dp, Color.Gray)
//    )
//    {
//        Column {
//            Box(){
//                CardArrow
//            }
//        }
//        CollapsibleList()
//        ListItem(
//            trailingContent = {
//                Icon(
//                    Icons.Filled.Favorite,
//                    contentDescription = "Localized description",
//                )
//            },
//            headlineContent = { /*TODO*/ })
//    }
//}



@Composable
fun ExpandableContent(
    visible: Boolean = false,
) {
    val enterTransition = remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(450)
        ) + fadeIn(
            initialAlpha = 0.3f,
            animationSpec = tween(450)
        )
    }
    val exitTransition = remember {
        shrinkVertically(
            // Expand from the top.
            shrinkTowards = Alignment.Top,
            animationSpec = tween(450)
        ) + fadeOut(
            // Fade in with the initial alpha of 0.3f.
            animationSpec = tween(450)
        )
    }
    AnimatedVisibility(
        visible = visible,
        enter = enterTransition,
        exit = exitTransition
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Spacer(modifier = Modifier.heightIn(100.dp))
            Text(
                text = "Expandable content here",
                textAlign = TextAlign.Center
            )
        }

    }
}
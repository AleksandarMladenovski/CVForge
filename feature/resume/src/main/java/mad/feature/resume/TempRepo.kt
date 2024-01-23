package mad.feature.resume

import kotlinx.coroutines.flow.flow
import mad.core.model.template.item.ProgressType
import mad.core.model.template.item.TextItem
import mad.core.model.template.item.TextProgressItem
import mad.core.model.template.CvForgeSection
import mad.core.model.template.CvForgeTemplate

object TempRepo {
    fun getTextItems(): List<TextItem> {
        return listOf(
            TextItem(
                "your-email@gmail.com",
                1,
                null
            ),
            TextItem(
                "+38978665556",
                2,
                null
            ), TextItem(
                "LinkedIn",
                3,
                "www.linkedin.com"
            )
        )
    }

    fun getTextProgressItems(): List<TextProgressItem> {
        return listOf(
            TextProgressItem("Html", 0.55f, ProgressType.PROGRESS_BAR),
            TextProgressItem("Android", 0.95f, ProgressType.PROGRESS_BAR),
            TextProgressItem("Html", 0.5f, ProgressType.SLIDER),
            TextProgressItem("Android", 0.95f, ProgressType.SLIDER),
        )
    }

    fun getSections(): List<CvForgeSection> {
        return listOf(
            CvForgeSection(
                items = getTextItems(),
                title = "Contact",
                bottomTitleDivider = true
            ),
            CvForgeSection(
                items = getTextProgressItems(),
                title = "Skills",
                bottomTitleDivider = true
            )
        )
    }

    fun getTestTemplate() = flow {
        kotlinx.coroutines.delay(1000)
        emit(
            CvForgeTemplate(getSections())
        )

    }

}
package mad.core.model.template

import mad.core.model.template.item.CvForgeItem

data class CvForgeSection(
    val sectionId: Int,
    val title: String? = null,
    val items: List<CvForgeItem> = emptyList(),
    val itemsPositionType: ItemsPositionType = ItemsPositionType.SINGLE_LINE,
    val divider: DividerPosition? = null,
) {
    fun getItemsColumnNum() = if (itemsPositionType == ItemsPositionType.SINGLE_LINE) 1 else 2
    fun getItemsChunked() = items.chunked((items.size + 1) / 2)
}

enum class ItemsPositionType {
    SINGLE_LINE, DOUBLE_LINE
}

enum class DividerPosition {
    UNDER_TITLE, UNDER_SECTION
}

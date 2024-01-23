package mad.core.model.template

data class CvForgeTemplate(
    val items: List<CvForgeSection> = emptyList(),
    val numColumns: Int = 1,
    val firstColumnSize:Int = 100
)
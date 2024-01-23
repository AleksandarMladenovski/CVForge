package mad.core.model.template.item

data class TextItem(
    override val id: Int,
    val title: String?,
    val subTitle: String?,
    val text: String,
    val iconId: Int?,
    val linkUri: String?,
) : CvForgeItem(id = id)
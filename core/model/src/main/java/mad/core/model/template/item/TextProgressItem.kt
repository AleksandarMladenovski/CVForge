package mad.core.model.template.item

data class TextProgressItem(
    override val id: Int,
    val text: String,
    val progress: Float = 0f,
    val progressType: ProgressType?
) : CvForgeItem(id)

enum class ProgressType {
    PROGRESS_BAR, SLIDER
}
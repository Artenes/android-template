package xyz.artenes.template.utils

/**
 * This one is useful to send events from the ViewModel to the View
 * such as when the view needs to be finished or to display a snack bar
 */
class Event(private val name: String? = null) {

    private var consumed: Boolean = false

    fun consume(consumer: (String) -> Unit) {
        if (!consumed && name != null) {
            consumer(name)
            consumed = true
        }
    }

}
package xyz.artenes.template.utils

class Event(private val name: String? = null) {

    private var consumed: Boolean = false

    fun consume(consumer: () -> Unit) {
        if (!consumed && name != null) {
            consumer()
            consumed = true
        }
    }

}
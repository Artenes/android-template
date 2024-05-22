package xyz.artenes.template.core.models

/**
 * This one is useful to send events from the ViewModel to the View
 * such as when the view needs to be finished or to display a snack bar
 */
interface Event<T> {

    fun consume(consumer: (T) -> Unit)

}

class EmptyEvent<T> : Event<T> {

    override fun consume(consumer: (T) -> Unit) {
        //ignore
    }

}

class PendingEvent<T>(private val payload: T) : Event<T> {

    private var consumed = false

    override fun consume(consumer: (T) -> Unit) {
        if (!consumed) {
            consumer(payload)
            consumed = true
        }
    }

}
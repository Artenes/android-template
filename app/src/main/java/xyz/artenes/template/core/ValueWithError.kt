package xyz.artenes.template.core

/**
 * This is useful for when you want to expose a value from your ViewModel
 * that can have an error state as such:
 *
 *     private val _description = MutableStateFlow(ValueWithError())
 *     val description: StateFlow<ValueWithError> = _description
 *
 * With this you have just one member variable in the ViewModel instead of two
 * to represent the value and the error message
 */
data class ValueWithError(
    val value: String = "",
    val error: String? = null
) {

    fun hasError() = error != null

}
package xyz.artenes.template.core.models

data class SelectableItem<T>(
    val value: T,
    val label: String,
    val selected: Boolean = false,
    val isInvalid: Boolean = false,
    val position: Int = -1
)
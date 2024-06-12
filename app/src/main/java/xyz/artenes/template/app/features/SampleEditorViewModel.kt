package xyz.artenes.template.app.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import xyz.artenes.template.core.interfaces.DataRepository
import xyz.artenes.template.core.interfaces.ValuesRepository
import xyz.artenes.template.core.models.SampleModel
import xyz.artenes.template.core.models.foundation.DataState
import xyz.artenes.template.core.models.foundation.Event
import xyz.artenes.template.core.models.foundation.ValueWithError
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

class SampleEditorViewModel(
    private val id: UUID? = null,
    private val repository: DataRepository,
    private val valuesRepository: ValuesRepository
) : ViewModel() {

    private val _state = MutableStateFlow<DataState<State>>(DataState.Loading)
    val state: StateFlow<DataState<State>> = _state

    data class State(
        val field: ValueWithError<String>,
        val deleteEvent: Event<Nothing>,
        val saveEvent: Event<SampleModel>
    )

    @Suppress("UNCHECKED_CAST")
    @Singleton
    class Factory @Inject constructor(
        private val repository: DataRepository,
        private val valuesRepository: ValuesRepository
    ) {

        fun make(id: UUID?): ViewModelProvider.Factory {

            return object : ViewModelProvider.Factory {

                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SampleEditorViewModel(
                        id,
                        repository,
                        valuesRepository
                    ) as T
                }

            }

        }

    }

}
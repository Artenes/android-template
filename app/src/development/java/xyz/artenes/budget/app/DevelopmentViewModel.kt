package xyz.artenes.budget.app

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import xyz.artenes.template.core.models.EmptyEvent
import xyz.artenes.template.core.models.Event
import javax.inject.Inject

@HiltViewModel
class DevelopmentViewModel @Inject constructor() : ViewModel() {

    private val _showSnackBar = MutableStateFlow(EmptyEvent<String>())
    val showSnackBar: StateFlow<Event<String>> = _showSnackBar

}
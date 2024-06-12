package xyz.artenes.template.di

import xyz.artenes.template.app.features.SampleEditorViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
data class FactoryLocatorMapping @Inject constructor(
    val sampleEditorViewModel: SampleEditorViewModel.Factory,
)

object FactoryLocator {

    lateinit var instance: FactoryLocatorMapping

}
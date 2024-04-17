package xyz.artenes.template.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
class AppRepository @Inject constructor(
    private val database: AppDatabase,
    private val dispatcher: CoroutineContext = Dispatchers.IO
) {

    suspend fun save(entity: SampleEntity) {
        withContext(dispatcher) {

        }
    }

}
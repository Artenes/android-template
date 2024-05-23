package xyz.artenes.template.core.interfaces

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    suspend fun save(key: String, value: String)

    suspend fun get(key: String, default: String = ""): String

    fun listen(key: String, default: String = ""): Flow<String>

}
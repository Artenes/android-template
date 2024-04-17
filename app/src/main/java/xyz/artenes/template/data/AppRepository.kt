package xyz.artenes.template.data

import xyz.artenes.template.core.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(private val database: AppDatabase) : Repository {



}
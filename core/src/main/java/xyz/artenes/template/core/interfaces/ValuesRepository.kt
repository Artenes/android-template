package xyz.artenes.template.core.interfaces

interface ValuesRepository {

    fun get(id: Int, vararg args: Any): String

}
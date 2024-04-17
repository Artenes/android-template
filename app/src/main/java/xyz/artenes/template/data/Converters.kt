package xyz.artenes.template.data

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

class Converters {

    private val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    @TypeConverter
    fun fromLocalDate(localDate: LocalDate?): String? {
        return localDate?.format(dateFormat)
    }

    @TypeConverter
    fun stringToLocalDate(string: String?): LocalDate? {
        if (string == null) {
            return null
        }
        return LocalDate.parse(string, dateFormat)
    }

    @TypeConverter
    fun fromOffset(offset: OffsetDateTime?): Long? {
        return offset?.toInstant()?.toEpochMilli()
    }

    @TypeConverter
    fun longToOffset(long: Long?): OffsetDateTime? {
        if (long == null) {
            return null
        }
        return Instant.ofEpochMilli(long).atOffset(OffsetDateTime.now().offset)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }

    @TypeConverter
    fun toUUID(value: String?): UUID? {
        if (value == null) {
            return null
        }
        return UUID.fromString(value)
    }

}
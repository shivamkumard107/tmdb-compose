package com.dev.sk.compose.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object Converters {
    @TypeConverter
    fun fromListToString(list: List<String?>?): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringToList(data: String?): List<String>? {
        if (data == null) {
            return null
        }
        val gson = Gson()
        val listType = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(data, listType)
    }
}

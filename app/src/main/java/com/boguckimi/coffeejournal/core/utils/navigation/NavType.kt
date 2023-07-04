package com.boguckimi.coffeejournal.core.utils.navigation

import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object NavTypeRegistry {

    val typeRegistry = mutableMapOf<String, NavType<*>>()

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T> getType() =
        typeRegistry[T::class.java.name] as? NavType<T> ?: addNewNavTypeToRegistry()

    inline fun <reified T> addNewNavTypeToRegistry() = object : NavType<T>(false) {
        /**
         * Puts the value into the bundle using the specified key.
         */
        override fun put(bundle: Bundle, key: String, value: T) =
            bundle.putString(key, serializeAsValue(value))

        /**
         * Retrieves the value from the bundle using the specified key.
         */
        override fun get(bundle: Bundle, key: String) =
            bundle.getString(key)?.let { parseValue(it) }

        /**
         * Parses the value from the serialized string representation.
         */
        override fun parseValue(value: String): T =
            Json.decodeFromString(value)

        /**
         * Serializes the value to a string representation.
         */
        override fun serializeAsValue(value: T): String =
            Json.encodeToString(value)
    }.also { typeRegistry[T::class.java.name] = it }
}
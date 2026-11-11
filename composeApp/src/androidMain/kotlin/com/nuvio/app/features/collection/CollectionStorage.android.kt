package com.nuvio.app.features.collection

import android.content.Context
import android.content.SharedPreferences
import com.nuvio.app.core.storage.ProfileScopedKey

actual object CollectionStorage {
    private const val preferencesName = "nuvio_collections"
    private const val payloadKey = "collections_payload"

    private var preferences: SharedPreferences? = null
    private var defaultAssetPayload: String? = null

    fun initialize(context: Context) {
        preferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
        if (defaultAssetPayload == null) {
            defaultAssetPayload = runCatching {
                context.assets.open("default_collections.json").bufferedReader().use { it.readText() }
            }.getOrNull()
        }
    }

    actual fun loadPayload(): String? {
        val saved = preferences?.getString(ProfileScopedKey.of(payloadKey), null)
        return if (saved.isNullOrBlank() || saved == "[]") defaultAssetPayload else saved
    }

    actual fun savePayload(payload: String) {
        preferences
            ?.edit()
            ?.putString(ProfileScopedKey.of(payloadKey), payload)
            ?.apply()
    }
}

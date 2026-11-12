package com.nuvio.app.features.tmdb

data class TmdbSettings(
    var enabled: Boolean = true,
    var apiKey: String = "2bc5af27d4d4ec4a98bc0bb8249dfafc",
    var language: String = "pt-BR",
    val useTrailers: Boolean = true,
    val useArtwork: Boolean = true,
    val useBasicInfo: Boolean = true,
    val useDetails: Boolean = true,
    val useCredits: Boolean = true,
    val useProductions: Boolean = true,
    val useNetworks: Boolean = true,
    val useEpisodes: Boolean = true,
    val useSeasonPosters: Boolean = true,
    val useMoreLikeThis: Boolean = true,
    val useCollections: Boolean = true,
) {
    init {
        if (apiKey.isBlank()) {
            apiKey = "2bc5af27d4d4ec4a98bc0bb8249dfafc"
        }
        enabled = true
        if (language.isBlank() || language == "en") {
            language = "pt-BR"
        }
    }
}
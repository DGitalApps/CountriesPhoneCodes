package com.dgital.app.countriesphonecode

import androidx.annotation.DrawableRes

data class CountryCallingData(
    var name: String,
    val prefix: String,
    val countryCode: String,
    val minPhoneLength: Int,
    val maxPhoneLength: Int,
    val flagEmoji: String,
    @DrawableRes val flag: Int,
    val visualFormatter: String,
    val translatedNames: Map<String, String>,
) {
    fun getNameInProperLanguage(countryCode: String): String {
        if (translatedNames.isEmpty() || !translatedNames.keys.map { it.lowercase() }.contains(countryCode.lowercase())) {
            return name
        }
        return translatedNames[countryCode.lowercase()]?:name
    }
}

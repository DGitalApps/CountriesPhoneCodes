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
    val translatedNames: List<Pair<String, String>>,
) {
    fun getNameInProperLanguage(countryCode: String): String {
        if (translatedNames.isEmpty() || !translatedNames.map { it.first }.contains(countryCode)) {
            return name
        }
        return translatedNames.first { it.first == countryCode }.second.takeIf { it.isNotEmpty() }?:name
    }
}

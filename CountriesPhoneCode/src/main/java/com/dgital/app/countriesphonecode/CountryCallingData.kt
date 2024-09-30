package com.example.easyphoneprefixes

import android.util.Log
import androidx.annotation.DrawableRes

data class CountryCallingData(
    var name: String,
    val prefix: String,
    val countryCode: String,
    val minPhoneLength: Int,
    val maxPhoneLength: Int,
    @DrawableRes val flag: Int,
    val translatedNames: List<Pair<String, String>>,
) {
    fun getNameInProperLanguage(countryCode: String): String {
        if (!translatedNames.map { it.first }.contains(countryCode)) {
            Log.i("CountryPhoneData", "${countryCode} is not supported yet or used wrong country code")
            return name
        }
        return translatedNames.first { it.first == countryCode }.second
    }
}

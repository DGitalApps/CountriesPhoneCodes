package com.example.easyphoneprefixes

object PhonePrefixesLibrary {
    fun getAllPhones(): List<CountryPhoneData> = countries

    fun getTranslated(code: String): List<CountryPhoneData> {
        return getAllPhones().map { countryPhoneData ->
            CountryPhoneData(name = countryPhoneData.getNameInProperLanguage(code), prefix = countryPhoneData.prefix, flag = countryPhoneData.flag, translatedNames = countryPhoneData.translatedNames)
        }.sortedBy { it.name }
    }
}
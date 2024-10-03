package com.dgital.app.countriesphonecode

object CountryCallingUtil {
    /**
     * Retrieves all countries data in default configuration
     *
     * @return All raw data.
     * **/
    fun getAllPhones(): List<CountryCallingData> = countries

    /**
     * Retrieves countries list with "name" parameter translated to language passed in param (if exist). Check CountriesTranslations enum to see supported languages.
     *
     * @param code:  language code
     * @return: Data with translated names based on language code; return EN name if translation not found
     */
    fun getTranslated(code: String): List<CountryCallingData> {
        return getAllPhones().map { countryPhoneData ->
            CountryCallingData(
                name = countryPhoneData.getNameInProperLanguage(code),
                prefix = countryPhoneData.prefix,
                flag = countryPhoneData.flag,
                flagEmoji = countryPhoneData.flagEmoji,
                countryCode = countryPhoneData.countryCode,
                minPhoneLength = countryPhoneData.minPhoneLength,
                maxPhoneLength = countryPhoneData.maxPhoneLength,
                visualFormatter = countryPhoneData.visualFormatter,
                translatedNames = countryPhoneData.translatedNames)
        }.sortedBy { it.name }
    }

    /**
     * Retrieves contry if exist by passed country code
     *
     * @param code: Country code (ex. "PL", "EN") to return. Need be iSO2 format.
     * @param translated: If true, then data will be translated in code language (if exist).
     * @param inLanguage: Country code in which data should be returned (if translated).
     * @return Data of country if exist.
     * **/
    fun getCountryData(code: String, translated: Boolean = false, inLanguage: String = ""): CountryCallingData? {
        return when {
            inLanguage.isNotEmpty() -> {
               getTranslated(inLanguage.uppercase()).find { it.countryCode == code.uppercase() }
            }
            translated -> {
                getTranslated(code.uppercase()).find { it.countryCode == code.uppercase() }
            }
            else -> {
                getAllPhones().find { it.countryCode == code.uppercase() }
            }
        }
    }
}
package com.dgital.app.countriesphonecode

object CountryCallingUtil {
    /**
     * @return All raw data.
     * **/
    fun getAllPhones(): List<CountryCallingData> = countries

    /**
     * @param: code - language code
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
}
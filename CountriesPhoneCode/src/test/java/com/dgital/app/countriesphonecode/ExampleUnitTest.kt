package com.dgital.app.countriesphonecode

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun `check if found correct contry via code`() {
        val poland = CountryCallingUtil.getAllPhones().find { it.countryCode == "PL" }
        val usa = CountryCallingUtil.getAllPhones().find { it.countryCode == "US" }
        val ukraine = CountryCallingUtil.getAllPhones().find { it.countryCode == "UA" }

        assertEquals("Poland", poland?.name)
        assertEquals("USA", usa?.name)
        assertEquals("Ukraine", ukraine?.name)
    }

    @Test
    fun `Check if get in EN transaction works`() {
        val countriesAll = CountryCallingUtil.getAllPhones()
        val countriesEN = CountryCallingUtil.getTranslated("en")

        assertEquals("American Samoa", countriesAll.find { it.countryCode ==  "AS"}?.name)
        assertEquals("American Samoa", countriesEN.find { it.countryCode ==  "AS"}?.name)
    }
    @Test
    fun `Check if get in PL transaction works`() {
        val countriesPL = CountryCallingUtil.getTranslated("pl")
        assertEquals("Samoa Amerykańskie", countriesPL.find { it.countryCode ==  "AS"}?.name)
    }

    @Test
    fun `Check if get in UA transaction works`() {
        val countriesPL = CountryCallingUtil.getTranslated("ua")
        assertEquals("Американське Самоа", countriesPL.find { it.countryCode ==  "AS"}?.name)
    }

    @Test
    fun `Check if return correnty name when missing translation`() {
        val fakeCountry = CountryCallingData(
            name = "Fake Country",
            prefix = "+999",
            flag = -1,
            flagEmoji = "XX",
            minPhoneLength = 10,
            maxPhoneLength = 10,
            countryCode = "XX",
            translatedNames = listOf(
                Pair("en", "Fake Country"),
                Pair("pl", "Udawane Państwo"),
                Pair("ua", "")
            )
        )
        val fakeCountryEmptyTranslation = CountryCallingData(
            name = "Fake Country empty",
            prefix = "+999",
            flag = -1,
            flagEmoji = "XX",
            minPhoneLength = 10,
            maxPhoneLength = 10,
            countryCode = "XX",
            translatedNames = listOf()
        )

        assertEquals("Fake Country", fakeCountry.getNameInProperLanguage("en"))
        assertEquals("Udawane Państwo", fakeCountry.getNameInProperLanguage("pl"))
        assertEquals("Fake Country empty", fakeCountryEmptyTranslation.getNameInProperLanguage("ua"))
        assertEquals("Fake Country empty", fakeCountryEmptyTranslation.getNameInProperLanguage("en"))
    }
    @Test
    fun `Check if list return correct country name if city is missing tranlation`() {
        val list = CountryCallingUtil.getAllPhones().apply {  }
    }
}
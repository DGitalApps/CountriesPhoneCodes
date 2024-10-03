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
            visualFormatter = "",
            translatedNames = mapOf(
                "en" to "Fake Country",
                "pl" to "Udawane Państwo",
                "ua" to  ""
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
            visualFormatter = "",
            translatedNames = mapOf()
        )

        assertEquals("Fake Country", fakeCountry.getNameInProperLanguage("en"))
        assertEquals("Udawane Państwo", fakeCountry.getNameInProperLanguage("pl"))
        assertEquals("Fake Country empty", fakeCountryEmptyTranslation.getNameInProperLanguage("ua"))
        assertEquals("Fake Country empty", fakeCountryEmptyTranslation.getNameInProperLanguage("en"))
    }
    @Test
    fun `Check translation via CountriesTranslation`() {
        val countriesPL = CountryCallingUtil.getTranslated(CountriesTranslations.PL.countryCode)
        val countriesEN = CountryCallingUtil.getTranslated(CountriesTranslations.EN.countryCode)
        val countriesFR = CountryCallingUtil.getTranslated(CountriesTranslations.FR.countryCode)

        assertEquals("Polska", countriesPL.find { it.countryCode ==  CountriesTranslations.PL.countryCode.uppercase()}?.name)
        assertEquals("Poland", countriesEN.find { it.countryCode ==  CountriesTranslations.PL.countryCode.uppercase()}?.name)
        assertEquals("Pologne", countriesFR.find { it.countryCode ==  CountriesTranslations.PL.countryCode.uppercase()}?.name)
    }

    @Test
    fun `Check get country and with translation`() {
        val poland = CountryCallingUtil.getCountryData("pl")
        val poland2 = CountryCallingUtil.getCountryData("PL")
        val poland3 = CountryCallingUtil.getCountryData("Pl")

        val polandTranslated = CountryCallingUtil.getCountryData("pl", true)
        val polandTranslated2 = CountryCallingUtil.getCountryData("PL", true)
        val polandTranslated3 = CountryCallingUtil.getCountryData("Pl", true)

        val polandTranslatedDE = CountryCallingUtil.getCountryData("pl", true, "de")

        assertEquals("Poland", poland?.name)
        assertEquals("Poland", poland2?.name)
        assertEquals("Poland", poland3?.name)

        assertEquals("Polska", polandTranslated?.name)
        assertEquals("Polska", polandTranslated2?.name)
        assertEquals("Polska", polandTranslated3?.name)

        assertEquals("Polen", polandTranslatedDE?.name)
    }

    @Test
    fun `Check if null returned for missing country`() {
        val unexistingCountry = CountryCallingUtil.getCountryData("XX")

        assertEquals(null, unexistingCountry?.name)
        assertEquals(null, unexistingCountry)
    }
}
## CountriesPhoneCodes [![](https://jitpack.io/v/DGitalApps/CountriesPhoneCodes.svg)](https://jitpack.io/#DGitalApps/CountriesPhoneCodes)
## Introduction
Helper to create own phone number prefix calling phone picker. Create for Android's apps.
## Use Library
Gradle dependency
 ```kts
    maven { url = uri("https://jitpack.io") }
  ```
In app Module: 
  ```kts
     implementation 'com.github.DGitalApps:CountriesPhoneCodes:x.x.x' //where x.x.x is current version
  ```
## Usage
 ```kts
    val countriesData = CountryCallingUtil.getAllPhones() // get all data
    val countriesDataTrasnlated = CountryCallingUtil.getTranslated("pl") //get all data in polish language (country name)
  ```
## Functionalities
List of countries with:
- Country name
- Calling prefix
- Flag as drawable resource (for Android)
- Flag as String (emoji)
- Minimum phone lenght for country
- Maximum phone lenght for country
- Phone's mask (pattern)
- Country names translation:
  - English,
  - Polsish,
  - Ukrainian,
  - Chinese,
  - German,
  - Spanish,
  - French
  - Japanese
  - Korean
  - Portugal
 
## License
Licensed under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
 ```
 Copyright (C) 2012-2022 ZXing authors, Journey Mobile

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
  ```

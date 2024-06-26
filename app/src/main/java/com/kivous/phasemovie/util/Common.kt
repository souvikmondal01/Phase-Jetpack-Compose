package com.kivous.phasemovie.util

object Common {
    private val languageMap = mapOf(
        "xx" to "N/A",
        "aa" to "Afar",
        "af" to "Afrikaans",
        "ak" to "Akan",
        "an" to "Aragonese",
        "as" to "Assamese",
        "av" to "Avaric",
        "ae" to "Avestan",
        "ay" to "Aymara",
        "az" to "Azerbaijani",
        "ba" to "Bashkir",
        "bm" to "Bambara",
        "bi" to "Bislama",
        "bo" to "Tibetan",
        "br" to "Breton",
        "ca" to "Catalan",
        "cs" to "Czech",
        "ce" to "Chechen",
        "cu" to "Slavic",
        "cv" to "Chuvash",
        "kw" to "Cornish",
        "co" to "Corsican",
        "cr" to "Cree",
        "cy" to "Welsh",
        "da" to "Danish",
        "de" to "German",
        "dv" to "Divehi",
        "dz" to "Dzongkha",
        "eo" to "Esperanto",
        "et" to "Estonian",
        "eu" to "Basque",
        "fo" to "Faroese",
        "fj" to "Fijian",
        "fi" to "Finnish",
        "fr" to "French",
        "fy" to "Frisian",
        "ff" to "Fulah",
        "gd" to "Gaelic",
        "ga" to "Irish",
        "gl" to "Galician",
        "gv" to "Manx",
        "gn" to "Guarani",
        "gu" to "Gujarati",
        "ht" to "Haitian; Haitian Creole",
        "ha" to "Hausa",
        "sh" to "Serbo-Croatian",
        "hz" to "Herero",
        "ho" to "Hiri Motu",
        "hr" to "Croatian",
        "hu" to "Hungarian",
        "ig" to "Igbo",
        "io" to "Ido",
        "ii" to "Yi",
        "iu" to "Inuktitut",
        "ie" to "Interlingue",
        "ia" to "Interlingua",
        "id" to "Indonesian",
        "ik" to "Inupiaq",
        "is" to "Icelandic",
        "it" to "Italian",
        "jv" to "Javanese",
        "ja" to "Japanese",
        "kl" to "Kalaallisut",
        "kn" to "Kannada",
        "ks" to "Kashmiri",
        "kr" to "Kanuri",
        "kk" to "Kazakh",
        "km" to "Khmer",
        "ki" to "Kikuyu",
        "rw" to "Kinyarwanda",
        "ky" to "Kirghiz",
        "kv" to "Komi",
        "kg" to "Kongo",
        "ko" to "Korean",
        "kj" to "Kuanyama",
        "ku" to "Kurdish",
        "lo" to "Lao",
        "la" to "Latin",
        "lv" to "Latvian",
        "li" to "Limburgish",
        "ln" to "Lingala",
        "lt" to "Lithuanian",
        "lb" to "Letzeburgesch",
        "lu" to "Luba-Katanga",
        "lg" to "Ganda",
        "mh" to "Marshall",
        "ml" to "Malayalam",
        "mr" to "Marathi",
        "mg" to "Malagasy",
        "mt" to "Maltese",
        "mo" to "Moldavian",
        "mn" to "Mongolian",
        "mi" to "Maori",
        "ms" to "Malay",
        "my" to "Burmese",
        "na" to "Nauru",
        "nv" to "Navajo",
        "nr" to "Ndebele",
        "nd" to "Ndebele",
        "ng" to "Ndonga",
        "ne" to "Nepali",
        "nl" to "Dutch",
        "nn" to "Norwegian Nynorsk",
        "nb" to "Norwegian Bokmål",
        "no" to "Norwegian",
        "ny" to "Chichewa; Nyanja",
        "oc" to "Occitan",
        "oj" to "Ojibwa",
        "or" to "Oriya",
        "om" to "Oromo",
        "os" to "Ossetian; Ossetic",
        "pi" to "Pali",
        "pl" to "Polish",
        "pt" to "Portuguese",
        "qu" to "Quechua",
        "rm" to "Raeto-Romance",
        "ro" to "Romanian",
        "rn" to "Rundi",
        "ru" to "Russian",
        "sg" to "Sango",
        "sa" to "Sanskrit",
        "si" to "Sinhalese",
        "sk" to "Slovak",
        "sl" to "Slovenian",
        "se" to "Northern Sami",
        "sm" to "Samoan",
        "sn" to "Shona",
        "sd" to "Sindhi",
        "so" to "Somali",
        "st" to "Sotho",
        "es" to "Spanish",
        "sq" to "Albanian",
        "sc" to "Sardinian",
        "sr" to "Serbian",
        "ss" to "Swati",
        "su" to "Sundanese",
        "sw" to "Swahili",
        "sv" to "Swedish",
        "ty" to "Tahitian",
        "ta" to "Tamil",
        "tt" to "Tatar",
        "te" to "Telugu",
        "tg" to "Tajik",
        "tl" to "Tagalog",
        "th" to "Thai",
        "ti" to "Tigrinya",
        "to" to "Tonga",
        "tn" to "Tswana",
        "ts" to "Tsonga",
        "tk" to "Turkmen",
        "tr" to "Turkish",
        "tw" to "Twi",
        "ug" to "Uighur",
        "uk" to "Ukrainian",
        "ur" to "Urdu",
        "uz" to "Uzbek",
        "ve" to "Venda",
        "vi" to "Vietnamese",
        "vo" to "Volapük",
        "wa" to "Walloon",
        "wo" to "Wolof",
        "xh" to "Xhosa",
        "yi" to "Yiddish",
        "za" to "Zhuang",
        "zu" to "Zulu",
        "ab" to "Abkhazian",
        "zh" to "Mandarin",
        "ps" to "Pushto",
        "am" to "Amharic",
        "ar" to "Arabic",
        "bg" to "Bulgarian",
        "cn" to "Cantonese",
        "mk" to "Macedonian",
        "el" to "Greek",
        "fa" to "Persian",
        "he" to "Hebrew",
        "hi" to "Hindi",
        "hy" to "Armenian",
        "en" to "English",
        "ee" to "Ewe",
        "ka" to "Georgian"
    )

    fun getLanguageName(code: String) = languageMap[code] ?: "N/A"

    private val genres = mapOf(
        28 to "Action",
        12 to "Adventure",
        16 to "Animation",
        35 to "Comedy",
        80 to "Crime",
        99 to "Documentary",
        18 to "Drama",
        10751 to "Family",
        14 to "Fantasy",
        36 to "History",
        27 to "Horror",
        10402 to "Music",
        9648 to "Mystery",
        10749 to "Romance",
        878 to "Science Fiction",
        10770 to "TV Movie",
        53 to "Thriller",
        10752 to "War",
        37 to "Western"
    )

    fun getGenres(id: Int) = genres[id] ?: "N/A"

}
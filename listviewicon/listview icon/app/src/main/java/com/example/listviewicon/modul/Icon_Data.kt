package com.example.listviewicon.modul

import com.example.listviewicon.R


object Icon_Data {
        private val iconName = arrayOf(
            "dendeng batotok",
            "pecel lele",
            "Papeda",
            "rendang",
            "soto padang"
        )
    private val detail = arrayOf(
        "Dendeng batokok adalah masakan khas Sumatra Barat dibuat dari irisan tipis dan lebar. Setelah daging sapi diiris tipis melebar, lalu dipukul-pukul dengan batu cobek supaya daging nya menjadi lembut.",
        "Pecel lele adalah nama sebuah makanan khas Jawa yang terdiri dari ikan lele dan sambal (bumbu) pecak. Biasanya yang dimaksud adalah ikan lele yang digoreng kering dengan minyak lalu disajikan dengan sambal tomat dan lalapan. Lalapan biasa terdiri dari kemangi, kubis, mentimun, dan kacang panjang..",
        "Papeda adalah makanan berupa bubur sagu khas Maluku dan Papua yang biasanya disajikan dengan ikan tongkol atau mubara yang dibumbui dengan kunyit..",
        "Rendang adalah adalah masakan daging dengan bumbu rempah-rempah yang berasal dari Minangkabau. Masakan ini dihasilkan dari proses memasak yang dipanaskan berulang-ulang menggunakan santan sampai kuahnya kering sama sekali.",
        "Soto Padang adalah hidangan berkuah kaldu sapi dengan bahan irisan daging sapi yang sudah digoreng kering, bihun (mie dari tepung beras), ditambah perkedel kentang dan dihidangkan panas-panas.."
    )
    private val iconPoster = intArrayOf(
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3,
        R.drawable.pic4,
        R.drawable.pic5
    )
    val listicon: ArrayList<Icon>
        get() {
            val list = arrayListOf<Icon>()
            for (position in iconName.indices) {
                val icon = Icon()
                icon.name = iconName[position]
                icon.detail = detail[position]
                icon.poster = iconPoster[position]
                list.add(icon)
            }
            return list
        }
}
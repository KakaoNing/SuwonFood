package com.example.myapplication

class Data(string: String, string1: String, string2: String) {
    private var RCP_NM // 영화이름
            : String? = null
    private var RCP_PARTS_DTLS // 누적관객수
            : String? = null
    private var RCP_WAY2: String? = null

    fun getRCP_NM(): String? {
        return RCP_NM
    }

    fun setRCP_NM(RCP_NM: String?) {
        this.RCP_NM = RCP_NM!!
    }

    fun getRCP_PARTS_DTLS(): String? {
        return RCP_PARTS_DTLS
    }

    fun setRCP_PARTS_DTLS(RCP_PARTS_DTLS: String?) {
        this.RCP_PARTS_DTLS = RCP_PARTS_DTLS!!
    }


    fun getRCP_WAY2(): String? {
        return RCP_WAY2
    }

    fun setRCP_WAY2(RCP_WAY2: String?) {
        this.RCP_WAY2 = RCP_WAY2!!
    }


    fun Data(RCP_NM: String?, RCP_PARTS_DTLS: String?, RCP_WAY2: String?) {
        this.RCP_NM = RCP_NM!!
        this.RCP_PARTS_DTLS = RCP_PARTS_DTLS!!
        this.RCP_WAY2 = RCP_WAY2!!
    }

    fun Data() {
        RCP_NM = RCP_NM
        RCP_PARTS_DTLS = RCP_PARTS_DTLS
        RCP_WAY2 = RCP_WAY2
    }

}
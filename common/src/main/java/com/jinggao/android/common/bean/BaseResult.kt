
package com.jinggao.android.common.bean

import com.jinggao.android.common.net.NetworkHeaderParams
import java.io.Serializable

class BaseResult <T> : Serializable {
    var male: MutableList <T>? = null
    var female: MutableList <T>? = null
    var epub: MutableList <T>? = null
    var picture: MutableList <T>? = null
    var ranking: T? = null
    var ok: Boolean? = null
    var msg: String? = null
}
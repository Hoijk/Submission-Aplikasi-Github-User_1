package com.dicoding.fundamentl_subs

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sandwhiches (
    var Username: String,
    var Name: String,
    var Avatar: Int,
    var Company: String,
    var Followers: String,
    var Following: String,
    var Location: String,
    var Repository: String
) : Parcelable
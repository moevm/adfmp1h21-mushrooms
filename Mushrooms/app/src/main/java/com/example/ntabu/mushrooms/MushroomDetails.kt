package com.example.ntabu.mushrooms

import android.os.Parcel
import android.os.Parcelable

class MushroomDetails(var name : String?, var description : String?, var pictureId : Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(pictureId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MushroomDetails> {
        override fun createFromParcel(parcel: Parcel): MushroomDetails {
            return MushroomDetails(parcel)
        }

        override fun newArray(size: Int): Array<MushroomDetails?> {
            return arrayOfNulls(size)
        }
    }
}
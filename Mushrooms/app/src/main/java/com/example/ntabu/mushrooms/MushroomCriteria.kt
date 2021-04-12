package com.example.ntabu.mushrooms

import android.os.Parcel
import android.os.Parcelable

class MushroomCriteria : Parcelable {

    var topColor: String?
    var growPlace: String?
    var found: String?
    var roundColor: String?
    var roundKind: String?
    var sliceKind: String?
    var hatWidth: Int
    var specials: String?
    var legColor: String?
    var legHeight: Int
    var legDiameter: Int
    var legRing: String?

    constructor(
        topColor: String? = null,
        growPlace: String? = null,
        found: String? = null,
        roundColor: String? = null,
        roundKind: String? = null,
        sliceKind: String? = null,
        hatWidth: Int = 0,
        specials: String? = null,
        legColor: String? = null,
        legHeight: Int = 0,
        legDiameter: Int = 0,
        legRing: String? = null
    ) {
        this.topColor = topColor
        this.growPlace = growPlace
        this.found = found
        this.roundColor = roundColor
        this.roundKind = roundKind
        this.sliceKind = sliceKind
        this.hatWidth = hatWidth
        this.specials = specials
        this.legColor = legColor
        this.legHeight = legHeight
        this.legDiameter = legDiameter
        this.legRing = legRing
    }

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(topColor)
        parcel.writeString(growPlace)
        parcel.writeString(found)
        parcel.writeString(roundColor)
        parcel.writeString(roundKind)
        parcel.writeString(sliceKind)
        parcel.writeInt(hatWidth)
        parcel.writeString(specials)
        parcel.writeString(legColor)
        parcel.writeInt(legHeight)
        parcel.writeInt(legDiameter)
        parcel.writeString(legRing)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MushroomCriteria> {
        override fun createFromParcel(parcel: Parcel): MushroomCriteria {
            return MushroomCriteria(parcel)
        }

        override fun newArray(size: Int): Array<MushroomCriteria?> {
            return arrayOfNulls(size)
        }
    }
}
package com.hadi.dogsapi.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName


class DataClasses {

    data class DataState(var isFailed: Boolean)

    data class DogApiResponse(@SerializedName("message")var result: JsonObject?)

    data class DogApiImageResponse(@SerializedName("message") var result: JsonArray?)

    data class Breed(val name: String, val subBreeds: List<String>): Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.createStringArrayList()!!
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeStringList(subBreeds)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Breed> {
            override fun createFromParcel(parcel: Parcel): Breed {
                return Breed(parcel)
            }

            override fun newArray(size: Int): Array<Breed?> {
                return arrayOfNulls(size)
            }
        }
    }
}
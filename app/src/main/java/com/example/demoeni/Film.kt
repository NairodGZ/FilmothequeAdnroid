package com.example.demoeni

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Film(var id : Int = 0, var title : String = "", var synopsis : String = "", var duration : String = "", var year : String = "") :
    Parcelable {

    override fun toString(): String {
        return "le titre : $title - synopsis : $synopsis";
    }

    fun fixFilm(){
        println("TEST");
    }

    override fun equals(other: Any?): Boolean {
        if (other is Film){
            title == other.title;
        }
        return super.equals(other)
    }
}
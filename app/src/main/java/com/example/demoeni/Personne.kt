package com.example.demoeni

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Personne( var pseudo : String = "", var email  : String = "", var motDePasse : String = "" ,var codePostal : String = "", var ville : String = "", var numero : String = "") :
    Parcelable {


    override fun toString(): String {
        return "le pseudo : $pseudo - Email : $email";
    }

    fun fixPerson(){
        println("TEST");
    }

    override fun equals(other: Any?): Boolean {
        if (other is Personne){
            email == other.email;
        }
        return super.equals(other)
    }

}
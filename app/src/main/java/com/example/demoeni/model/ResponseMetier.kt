package com.example.demoeni.model

class ResponseMetier<T> {

    var code: String = "";
    var message: String = "";
    var data : T? = null;
}
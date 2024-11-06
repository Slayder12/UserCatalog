package com.example.usercatalog

import java.io.Serializable

class User(val name: String, val age: Int): Serializable {

    override fun toString(): String {
        return "$name, Возраст: $age"
    }

}




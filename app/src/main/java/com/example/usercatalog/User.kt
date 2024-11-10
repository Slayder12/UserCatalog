package com.example.usercatalog

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import java.io.Serializable

class User(val name: String, val age: Int): Serializable {

    override fun toString(): String {
        return "$name, Возраст: $age"
    }

}

class UserInputValidation(private val context: Context, private val user: User){
    fun isValid(): Boolean {
        if (user.name.isEmpty() || user.age.toString().isEmpty() || user.age == 0) {
            Toast.makeText(context, context.getString(R.string.filled_in_text), Toast.LENGTH_SHORT).show()
            return false
        }
        if (user.name.length !in 2..32) {
            Toast.makeText(context, context.getString(R.string.valid_name_text), Toast.LENGTH_SHORT).show()
            return false
        }
        if (user.age !in 1..120) {
            Toast.makeText(context, context.getString(R.string.valid_age_text), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}

class ClearTextOnClick(val nameET: EditText, val ageET: EditText) {
    fun clear() {
        nameET.setOnClickListener{
            nameET.text.clear()
        }
        ageET.setOnClickListener{
            ageET.text.clear()
        }
    }
}




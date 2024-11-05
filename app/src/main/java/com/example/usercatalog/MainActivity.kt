package com.example.usercatalog

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private val userData: MutableList<User> = mutableListOf()

    private lateinit var toolbarMain: Toolbar
    private lateinit var listViewLV: ListView
    private lateinit var nameET: EditText
    private lateinit var ageET: EditText
    private lateinit var saveBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameET = findViewById(R.id.nameET)
        ageET = findViewById(R.id.ageET)
        saveBTN = findViewById(R.id.saveBTN)
        listViewLV = findViewById(R.id.listViewLV)
        toolbarMain = findViewById(R.id.toolbarMain)
        title = ""
        setSupportActionBar(toolbarMain)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, userData)
        listViewLV.adapter = adapter


        saveBTN.setOnClickListener {
            val user = User(nameET.text.toString(), ageET.text.toString().toIntOrNull() ?: 0)
            if (!userInputValidation(user)) return@setOnClickListener
            userData.add(user)
            nameET.text.clear()
            ageET.text.clear()
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Пользователь ${user.name} добавлен", Toast.LENGTH_SHORT).show()
        }

        listViewLV.onItemClickListener =
            AdapterView.OnItemClickListener{
                    _, _, position, _ ->

                Toast.makeText(this, "Пользователь ${userData[position].name} удален", Toast.LENGTH_SHORT).show()
                val user = adapter.getItem(position)
                adapter.remove(user)

            }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.exitMenuMain) {
            Toast.makeText(this, "Вы вышли из приложения", Toast.LENGTH_SHORT).show()
            finish()
        }
        return super.onOptionsItemSelected(item)

    }

    private fun userInputValidation(user: User): Boolean {
        if (user.name.isEmpty() || user.age.toString().isEmpty() || user.age == 0) {
            Toast.makeText(this, "Необходимо заполнить все поля", Toast.LENGTH_SHORT).show()
            return false
        }
        if (user.name.length !in 2..32) {
            Toast.makeText(this, "Имя должно быть от 2 до 32 символов", Toast.LENGTH_SHORT).show()
            return false
        }
        if (user.age !in 1..120) {
            Toast.makeText(this, "Возраст должен быть от 1 до 120 лет", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}
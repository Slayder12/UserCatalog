package com.example.usercatalog

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
            Toast.makeText(this, getString(R.string.user_add_text, user.name), Toast.LENGTH_SHORT).show()
        }

        nameET.setOnClickListener{
            nameET.text.clear()
        }

        ageET.setOnClickListener{
            ageET.text.clear()
        }

        listViewLV.onItemClickListener =
            MyDialog.createDialog(this, adapter)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.exitMenuMain) {
            Toast.makeText(this, getString(R.string.logged_text), Toast.LENGTH_SHORT).show()
            finish()
        }
        return super.onOptionsItemSelected(item)

    }

    private fun userInputValidation(user: User): Boolean {
        if (user.name.isEmpty() || user.age.toString().isEmpty() || user.age == 0) {
            Toast.makeText(this, getString(R.string.filled_in_text), Toast.LENGTH_SHORT).show()
            return false
        }
        if (user.name.length !in 2..32) {
            Toast.makeText(this, getString(R.string.valid_name_text), Toast.LENGTH_SHORT).show()
            return false
        }
        if (user.age !in 1..120) {
            Toast.makeText(this, getString(R.string.valid_age_text), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}
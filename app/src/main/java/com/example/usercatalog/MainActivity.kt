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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), Removable {

    private val userData: MutableList<User> = mutableListOf()
    private var adapter: ArrayAdapter<User>? = null
    private lateinit var userLiveData: UserViewModel

    private lateinit var toolbarMain: Toolbar
    private lateinit var listViewLV: ListView
    private lateinit var nameET: EditText
    private lateinit var ageET: EditText
    private lateinit var saveBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userLiveData = ViewModelProvider(this)[UserViewModel::class.java]

        nameET = findViewById(R.id.nameET)
        ageET = findViewById(R.id.ageET)
        saveBTN = findViewById(R.id.saveBTN)
        listViewLV = findViewById(R.id.listViewLV)
        toolbarMain = findViewById(R.id.toolbarMain)
        title = ""
        setSupportActionBar(toolbarMain)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, userData)
        listViewLV.adapter = adapter

        userLiveData.userLiveData.observe(this, Observer { users ->
            adapter?.clear()
            adapter?.addAll(users)
            adapter?.notifyDataSetChanged()
        })

        saveBTN.setOnClickListener {
            val user = User(nameET.text.toString(), ageET.text.toString().toIntOrNull() ?: 0)
            if (!UserInputValidation(this, user).isValid()) return@setOnClickListener

            val currentList = userLiveData.userLiveData.value ?: mutableListOf()
            currentList.add(user)
            userLiveData.userLiveData.value = currentList

            nameET.text.clear()
            ageET.text.clear()

            Toast.makeText(this, getString(R.string.user_add_text, user.name), Toast.LENGTH_SHORT).show()
        }

        ClearTextOnClick(nameET, ageET).clear()

        listViewLV.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val userPosition = adapter!!.getItem(position)
                val dialog = MyDialog()
                val args = Bundle()
                args.putSerializable("user", userPosition)
                dialog.arguments = args
                dialog.show(supportFragmentManager, "custom")

            }
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

    override fun remove(user: User?) {
        val currentList = userLiveData.userLiveData.value ?: mutableListOf()
        currentList.remove(user)
        userLiveData.userLiveData.value = currentList

    }
}
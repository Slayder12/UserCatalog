package com.example.usercatalog

import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MyDialog {
    companion object {
        fun createDialog(context: Context, adapter: ArrayAdapter<User>) =
            AdapterView.OnItemClickListener { _, _, position, _ ->

                val builder = AlertDialog.Builder(context)
                builder.setTitle(context.getString(R.string.confirm_deletion_text))
                    .setMessage(context.getString(R.string.remove_text))
                    .setCancelable(true)
                    .setNegativeButton(context.getString(R.string.yes_text)) { dialog, witch ->
                        dialog.cancel()
                    }
                    .setPositiveButton(context.getString(R.string.no_text)) { dialog, witch ->
                        val user = adapter.getItem(position)
                        adapter.remove(user)
                        Toast.makeText(context,
                            context.getString(R.string.user_text, user), Toast.LENGTH_SHORT).show()
                    }.create().show()
            }

    }
}
package com.example.usercatalog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyDialog: DialogFragment() {
    private var removable: Removable? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        removable = context as Removable?

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val user = arguments?.get("user") as? User
        val builder = AlertDialog.Builder(
            requireActivity()
        )

        return builder.setTitle(getString(R.string.confirm_deletion_text))
            .setMessage(getString(R.string.remove_user_text, user))
            .setIcon(R.drawable.ic_delete)
            .setCancelable(true)
            .setPositiveButton(getString(R.string.yes_text)) { _, _ ->
                removable?.remove(user)
                Toast.makeText(context, getString(R.string.user_deleted_text, user), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(getString(R.string.no_text)) { _, _ -> }
                .create()

    }

}
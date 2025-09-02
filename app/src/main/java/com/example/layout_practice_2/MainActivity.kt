package com.example.layout_practice_2

import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val CONTACTS_PERMISSION_REQUEST_CODE = 100
    private lateinit var contactsListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactsListView = findViewById(R.id.contactsListView)

        // Check and request permission
        if (checkContactsPermission()) {
            loadContacts()
        } else {
            requestContactsPermission()
        }
    }

    private fun checkContactsPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.READ_CONTACTS
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestContactsPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.READ_CONTACTS),
            CONTACTS_PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CONTACTS_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadContacts()
            } else {
                Toast.makeText(this, "Contacts permission denied", Toast.LENGTH_SHORT).show()
                showDummyContacts()
            }
        }
    }

    private fun loadContacts() {
        val contactsList = mutableListOf<String>()

        // Query the contacts
        val cursor: Cursor? = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.Contacts.DISPLAY_NAME
        )

        cursor?.use {
            val nameColumnIndex = it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)

            while (it.moveToNext()) {
                if (nameColumnIndex != -1) {
                    val name = it.getString(nameColumnIndex)
                    if (name != null) {
                        contactsList.add(name)
                    }
                }
            }
        }

        cursor?.close()

        // Display contacts in ListView
        if (contactsList.isNotEmpty()) {
            val adapter = ArrayAdapter(
                this,
                R.layout.contact_list_item,
                R.id.contactNameTextView,
                contactsList
            )
            contactsListView.adapter = adapter
        } else {
            showDummyContacts()
        }
    }

    private fun showDummyContacts() {
        // Fallback dummy data
        val dummyContacts = listOf(
            "Suraj",
            "Sandeep",
            "Satyam",
            "Krishna",
            "Akhil",
            "Enable contacts permission to see real contacts"
        )

        val adapter = ArrayAdapter(
            this,
            R.layout.contact_list_item,
            R.id.contactNameTextView,
            dummyContacts
        )
        contactsListView.adapter = adapter
    }
}
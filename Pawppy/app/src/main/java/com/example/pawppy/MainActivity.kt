package com.example.pawppy

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var goButton: Button

    companion object {
        const val SHARED_PREFS = "pawppyPrefs"
        const val USER_NAME_KEY = "userName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.nameInput)
        goButton = findViewById(R.id.goButton)

        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        goButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            if (name.isNotEmpty()) {
                // Save name in SharedPreferences
                sharedPreferences.edit().putString(USER_NAME_KEY, name).apply()

                // Pass name to SecondActivity
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("userName", name) // <--- pass name here
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

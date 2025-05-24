package com.example.pawppy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val welcomeTextView = findViewById<TextView>(R.id.selectText)
        val buttonDog = findViewById<Button>(R.id.buttonDog)
        val buttonCat = findViewById<Button>(R.id.buttonCat)
        val buttonBird = findViewById<Button>(R.id.buttonBird)

        // Get the user's name from Intent
        val userName = intent.getStringExtra("userName") ?: "User"
        welcomeTextView.text = "Welcome, $userName! \n Get to know your pets more!"

        // Set up buttons to go to pet activities
        buttonDog.setOnClickListener {
            startActivity(Intent(this, DogActivity::class.java))
        }

        buttonCat.setOnClickListener {
            startActivity(Intent(this, CatActivity::class.java))
        }

        buttonBird.setOnClickListener {
            startActivity(Intent(this, BirdActivity::class.java))
        }
    }
}

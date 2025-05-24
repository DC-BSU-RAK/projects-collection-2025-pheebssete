package com.example.pawppy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class DogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)

        val infoButton = findViewById<ImageButton>(R.id.infoButton)

        infoButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Grooming🐾")
            builder.setMessage("Going over the dog with a pin brush once or twice a week, more often if needed, to keep the coat free of mats, tangles, dirt, and debris. ")
            builder.setPositiveButton("Got it!") { dialog, _ ->
                dialog.dismiss()
            }
            builder.create().show()
        }

        val buttonBack = findViewById<Button>(R.id.buttonBack)

        buttonBack.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}

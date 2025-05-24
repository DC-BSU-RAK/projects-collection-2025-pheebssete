package com.example.petcompatibility

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnAdventurous: ImageButton
    private lateinit var btnHomebody: ImageButton
    private lateinit var btnIntrovert: ImageButton
    private lateinit var btnFriendly: ImageButton
    private lateinit var btnFindPet: Button
    private lateinit var txtResult: TextView
    private lateinit var imgPetResult: ImageView

    // One trait from each group
    private var traitGroup1: String? = null
    private var traitGroup2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoButton = findViewById<ImageButton>(R.id.infoButton)

        infoButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("🐾 Welcome!")
            builder.setMessage("\uD83E\uDDE0 Choose two traits that best describe your personality. The app will suggest the pet that best matches you! Enjoy matching your vibe with your future furry friend!🐾")
            builder.setPositiveButton("Got it!") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

        // UI references
        btnAdventurous = findViewById(R.id.btnAdventurous)
        btnHomebody = findViewById(R.id.btnHomebody)
        btnIntrovert = findViewById(R.id.btnIntrovert)
        btnFriendly = findViewById(R.id.btnFriendly)
        btnFindPet = findViewById(R.id.btnFindPet)
        txtResult = findViewById(R.id.txtResult)
        imgPetResult = findViewById(R.id.imgPetResult)

        // Group 1: Adventurous / Homebody
        btnAdventurous.setOnClickListener {
            traitGroup1 = "Adventurous"
            highlightGroup1(btnAdventurous)
        }

        btnHomebody.setOnClickListener {
            traitGroup1 = "Homebody"
            highlightGroup1(btnHomebody)
        }

        // Group 2: Introvert / Friendly
        btnIntrovert.setOnClickListener {
            traitGroup2 = "Introvert"
            highlightGroup2(btnIntrovert)
        }

        btnFriendly.setOnClickListener {
            traitGroup2 = "Friendly"
            highlightGroup2(btnFriendly)
        }

        // Button to find pet
        btnFindPet.setOnClickListener {
            val (petName, petImage) = when {
                traitGroup1 == "Adventurous" && traitGroup2 == "Friendly" ->
                    "🐶 Border Collie" to R.drawable.border_collie
                traitGroup1 == "Homebody" && traitGroup2 == "Introvert" ->
                    "🐱 British Shorthair Cat" to R.drawable.british_shorthair
                traitGroup1 == "Homebody" && traitGroup2 == "Friendly" ->
                    "🐶 Golden Retriever" to R.drawable.golden_retriever
                traitGroup1 == "Adventurous" && traitGroup2 == "Introvert" ->
                    "🐶 Shih Tzu" to R.drawable.shih_tzu
                else ->
                    null to null
            }

            if (petName != null && petImage != null) {
                txtResult.text = petName
                imgPetResult.setImageResource(petImage)
                imgPetResult.visibility = View.VISIBLE
            } else {
                txtResult.text = "Please select one option from each category."
                imgPetResult.visibility = View.GONE
            }
        }
    }

    // Only one active selection in Group 1
    private fun highlightGroup1(selected: ImageButton) {
        val group1 = listOf(btnAdventurous, btnHomebody)
        group1.forEach { it.alpha = 0.5f }
        selected.alpha = 1.0f
    }

    // Only one active selection in Group 2
    private fun highlightGroup2(selected: ImageButton) {
        val group2 = listOf(btnIntrovert, btnFriendly)
        group2.forEach { it.alpha = 0.5f }
        selected.alpha = 1.0f
    }
}

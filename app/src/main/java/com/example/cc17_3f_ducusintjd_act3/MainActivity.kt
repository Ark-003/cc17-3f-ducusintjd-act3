package com.example.cc17_3f_ducusintjd_act3

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage: ImageView
    private lateinit var rollButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views
        diceImage = findViewById(R.id.imageView)
        rollButton = findViewById(R.id.button)
        resultTextView = findViewById(R.id.textView)

        rollButton.setOnClickListener {
            rollDice()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
    }
    private fun rollDice() {
        val randomNumber = Random.nextInt(1, 7) // Generates a random number between 1 and 6
        val drawableResource = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1 // Fallback (should not happen)
        }

        // Update the ImageView and TextView
        diceImage.setImageResource(drawableResource)
        resultTextView.text = "You Rolled $randomNumber!"
    }
}
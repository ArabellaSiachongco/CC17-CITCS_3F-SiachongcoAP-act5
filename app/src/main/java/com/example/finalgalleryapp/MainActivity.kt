package com.example.finalgalleryapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Artwork data list
    private val artworks = listOf(
        Artwork(
            R.drawable.sunshine,
            "Starry Night",
            "Vincent van Gogh",
            "A famous painting that depicts a swirling night sky with glowing stars over a small town. Date: 1889"
        ),
        Artwork(
            R.drawable.oxbow,
            "Mona Lisa",
            "Leonardo da Vinci",
            "A portrait of a woman with a mysterious smile, widely recognized as a masterpiece of the Renaissance. Date: 1503–1506"
        ),
        Artwork(
            R.drawable.waterlily,
            "The Persistence of Memory",
            "Salvador Dalí",
            "A surreal painting featuring melting clocks, symbolizing the fluidity of time. Date: 1931"
        ),
        Artwork(
            R.drawable.hay_wain,
            "The Scream",
            "Edvard Munch",
            "An iconic expressionist work depicting a figure with an agonized face against a tumultuous sky. Date: 1893"
        ),
        Artwork(
            R.drawable.starrynight,
            "Girl with a Pearl Earring",
            "Johannes Vermeer",
            "A portrait of a girl with a striking pearl earring, often referred to as the 'Mona Lisa of the North.' Date: 1665"
        )
    )

    // Track the current artwork index
    private var currentIndex = 0

    // Declare views
    private lateinit var imageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var authorTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        imageView = findViewById(R.id.artImageView)
        titleTextView = findViewById(R.id.artTitleTextView)
        authorTextView = findViewById(R.id.artAuthorTextView)
        descriptionTextView = findViewById(R.id.artDescriptionTextView)
        prevButton = findViewById(R.id.prevButton)
        nextButton = findViewById(R.id.nextButton)

        // Display the first artwork
        updateArtwork()

        // Set click listener for previous button
        prevButton.setOnClickListener {
            currentIndex = when {
                currentIndex > 0 -> currentIndex - 1   // Go to the previous artwork if not at the first
                else -> artworks.size - 1              // Wrap around to the last artwork
            }
            updateArtwork()
        }

        // Set click listener for next button
        nextButton.setOnClickListener {
            currentIndex = when {
                currentIndex < artworks.size - 1 -> currentIndex + 1   // Go to the next artwork
                else -> 0                                              // Wrap around to the first artwork
            }
            updateArtwork()
        }
    }

    // Update the displayed artwork based on the current index
    private fun updateArtwork() {
        val artwork = artworks[currentIndex]
        imageView.setImageResource(artwork.imageResId)
        titleTextView.text = artwork.title
        authorTextView.text = artwork.author
        descriptionTextView.text = artwork.description
    }
}

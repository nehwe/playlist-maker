package com.kayna.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonSearch = findViewById<Button>(R.id.search)

        val buttonLibrary = findViewById<Button>(R.id.library)

        val buttonSettings = findViewById<Button>(R.id.settings)

        // реализация через анонимный класс
        val buttonClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                when (p0?.id) {

                    R.id.search -> {
                        val searchIntent = Intent(this@MainActivity,
                            SearchActivity::class.java)
                        startActivity(searchIntent)
                    }

                    R.id.library -> {
                        val libraryIntent = Intent(this@MainActivity,
                            LibraryActivity::class.java)
                        startActivity(libraryIntent)
                    }
                }
            }
        }

        buttonSearch.setOnClickListener(buttonClickListener)

        buttonLibrary.setOnClickListener(buttonClickListener)

        // реализация через лямбду
        buttonSettings.setOnClickListener {
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingsIntent)
        }
    }

}
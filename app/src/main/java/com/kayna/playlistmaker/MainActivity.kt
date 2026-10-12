package com.kayna.playlistmaker

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

        setContentView(R.layout.activity_main)

        val buttonsAnonymous = listOf(
            findViewById<Button>(R.id.search),
            findViewById<Button>(R.id.library)
        )

        val buttonLambda = findViewById<Button>(R.id.settings)
        // реализация через анонимный класс
        val buttonClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                when (p0?.id) {

                    R.id.search -> {
                        Toast.makeText(
                            this@MainActivity,
                            "нажали кнопку [Поиск]",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    R.id.library -> {
                        Toast.makeText(
                            this@MainActivity,
                            "нажали кнопку [Медиатека]",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        buttonsAnonymous.forEach {
            it.setOnClickListener(buttonClickListener)
        }
        // реализация через лямбду
        buttonLambda.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "нажали кнопку [Настройки]",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}
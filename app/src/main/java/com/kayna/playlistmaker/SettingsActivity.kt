package com.kayna.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.settings)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonBack = findViewById<ImageButton>(R.id.back)

        val buttonShare = findViewById<LinearLayout>(R.id.share)

        val buttonSupport = findViewById<LinearLayout>(R.id.support)

        val buttonUserAgreement = findViewById<LinearLayout>(R.id.userAgreement)

        val buttonClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                when (p0?.id) {

                    R.id.back -> {
                        finish()
                    }

                    R.id.share -> {
                        val shareLink = getString(R.string.share_link)

                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, shareLink)
                            putExtra(Intent.EXTRA_TITLE,
                                getString(R.string.share_title))
                        }

                        val chooserIntent = Intent.createChooser(shareIntent,
                            getString(R.string.share_title))
                        startActivity(chooserIntent)
                    }

                    R.id.support -> {
                        val message = getString(R.string.email_text)
                        val shareIntent = Intent(Intent.ACTION_SENDTO)
                        shareIntent.data = Uri.parse("mailto:")
                        shareIntent.putExtra(Intent.EXTRA_EMAIL,
                            arrayOf(getString(R.string.email)))
                        shareIntent.putExtra(Intent.EXTRA_TEXT,
                            message)
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT,
                            getString(R.string.email_subject))
                        startActivity(shareIntent)
                    }

                    R.id.userAgreement -> {
                        val shareIntent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(getString(R.string.offer))
                        }
                        startActivity(shareIntent)
                    }
                }
            }
        }

        buttonBack.setOnClickListener(buttonClickListener)
        buttonShare.setOnClickListener(buttonClickListener)
        buttonSupport.setOnClickListener(buttonClickListener)
        buttonUserAgreement.setOnClickListener(buttonClickListener)
    }
}
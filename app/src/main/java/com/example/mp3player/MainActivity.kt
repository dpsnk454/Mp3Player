package com.example.mp3player

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
        findViewById<Button>(R.id.playbtn).setOnClickListener{
            Intent(applicationContext, MyService::class.java).putExtra("Service1","PlayPause" ).apply {
                startService(this)
            }
        }
        findViewById<Button>(R.id.stopbtn).setOnClickListener {
            Intent(applicationContext, MyService::class.java).putExtra("Service2", "Stop").apply {
                stopService(this)
            }
        }
    }
}
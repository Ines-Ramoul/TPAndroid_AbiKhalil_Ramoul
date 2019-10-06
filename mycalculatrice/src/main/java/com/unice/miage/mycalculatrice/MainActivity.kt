package com.unice.miage.mycalculatrice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Context context = MyFirstActivity.this, getContext;
        Intent intent = new Intent(context, MySecondActivity.class);
        startActivity(intent);*/

        val buttonCalculatrice = findViewById(R.id.buttonCalculatrice) as Button
        buttonCalculatrice.setOnClickListener {
            val context = this@MainActivity
            val getContext: Context
            val intent = Intent(context, MyCalculatrice::class.java)
            startActivity(intent)
        }

        val buttonTutoieMoi = findViewById(R.id.buttonCliqueMoi) as Button
        buttonTutoieMoi.setOnClickListener {
            val bonjourText = findViewById(R.id.myFirstActivityText) as TextView
            bonjourText.text = "Bonjour Amosse !"
            val tutoieText = findViewById(R.id.textView2) as TextView
            tutoieText.text = "Comment vas-TU ?"
            val amosseImage = findViewById(R.id.imageView2) as ImageView
            amosseImage.visibility = View.VISIBLE
            val buttonCalculatrice = findViewById(R.id.buttonCalculatrice) as Button
            buttonCalculatrice.visibility = View.VISIBLE
            buttonTutoieMoi.visibility = View.INVISIBLE
        }


    }
}

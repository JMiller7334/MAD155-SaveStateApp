package com.example.mad155_keepstateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var button: Button //variables with no values yet.
    lateinit var textLabel: TextView
    lateinit var textLabel2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // variables MUST be set under the set contentview
        button = findViewById<Button>(R.id.saveButton)//giving variables values
        textLabel = findViewById<TextView>(R.id.saveTextView)
        textLabel2 = findViewById(R.id.TextView2)

        button.setOnClickListener {
            textLabel.text = ("Button clicked!")
            textLabel2.text = ("Save state - this text, above text, button text.")
            button.text = ("Pressed")
        }
    }
    override fun onSaveInstanceState(outState: Bundle) { //The function that saves the info and data.
        super.onSaveInstanceState(outState)
        outState.putString("savedTextLabel", textLabel.text.toString()) //save the value of textLabels Text to be loaded later
        //not that savedTextLabel is the key in this case.
        outState.putString("savedTextLabel2", textLabel2.text.toString())
        outState.putString("savedTextButton", button.text.toString())




    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { //The restore function, fires when data will be loaded
        super.onRestoreInstanceState(savedInstanceState)

        textLabel.setText(savedInstanceState.getString("savedTextLabel")) //load the data using the key.
        textLabel2.setText(savedInstanceState.getString("savedTextLabel2"))
        button.text = (savedInstanceState.getString("savedTextButton"))
    }
}
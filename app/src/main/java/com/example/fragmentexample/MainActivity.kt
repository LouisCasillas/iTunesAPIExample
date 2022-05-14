package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

    // lateinit and lazy are for initializing a variable later in the code
    // lateinit a promise to give this variable a value later
    // the value is null
//    lateinit var btnLoadFragment: Button

    // lateinit can't be used with primitives
    //lateinit var test : Boolean
    lateinit var test : Objects


    // by lazy, the variable is not given value
    // until it is first called
    // you can put other logic and code inside the lazy block as long as the last thing
    // executed returns the expected data type
    private val btnLoadFragment : Button by lazy {
        if (true) {
            findViewById(R.id.btn_load_fragment)
        }
        else
        {
            findViewById(R.id.btn_load_fragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoadFragment = findViewById(R.id.btn_load_fragment)
        btnLoadFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frag_dynamic, DynamicFragment())
                .commit()
        }
    }
}
package com.aziqazmi.lab23backupdata

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aziqazmi.lab23backupdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var prefs : SharedPreferences? = null
    private var edit : SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Initialize the shared preferences
        //Context.MODE_PRIVATE hanya boleh dibaca di projek ini
        prefs = getSharedPreferences("messages", Context.MODE_PRIVATE)

        edit = prefs?.edit()

        binding.buttonSave.setOnClickListener {
            edit?.putString("mesej", binding.savedData.text.toString())
            edit?.commit()
        }

        binding.buttonRetrieve.setOnClickListener {
            var savedString = prefs?.getString("mesej","")

            binding.retrieveData.setText(savedString)
        }

    }
}
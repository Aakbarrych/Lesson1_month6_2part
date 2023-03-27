package com.example.lesson1_month62hw

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson1_month62hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    object Key {
        const val DATA_KEY = "key for data"
    }

    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                binding.editTextFirst.setText(result.data?.getStringExtra(Key.DATA_KEY))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
    }

    private fun onClick() {
        binding.goInBtn.setOnClickListener {
            if (binding.editTextFirst.text.toString().isNotEmpty()){
                getContent.launch(
                    Intent(this, SecondActivity::class.java).apply {
                        putExtra(Key.DATA_KEY, binding.editTextFirst.text.toString())
                    }
                )
            } else{
                Toast.makeText(this, getString(R.string.Empty_input), Toast.LENGTH_LONG).show()
            }
        }
    }
}
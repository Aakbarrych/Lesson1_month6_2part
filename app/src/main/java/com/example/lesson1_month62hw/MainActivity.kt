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

    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                binding.editTextFirst.setText(result.data?.getStringExtra(SecondActivity.Key.VALUE_KEY))
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
                        putExtra(SecondActivity.Key.VALUE_KEY, binding.editTextFirst.text.toString())
                    }
                )
            } else{
                Toast.makeText(this, "This input shouldn't be empty", Toast.LENGTH_LONG).show()
            }
        }
    }
}
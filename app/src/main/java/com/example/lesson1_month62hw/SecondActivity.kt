package com.example.lesson1_month62hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson1_month62hw.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
    }

    private fun onClick() {
        binding.goBackBtn.setOnClickListener{
            if (binding.editTextSecond.text.toString().isNotEmpty()){
                setResult(RESULT_OK, Intent().putExtra(MainActivity.Key.DATA_KEY, binding.editTextSecond.text.toString()))
                finish()
            } else{
                Toast.makeText(this, getString(R.string.Empty_input), Toast.LENGTH_LONG).show()
            }
        }
    }
}
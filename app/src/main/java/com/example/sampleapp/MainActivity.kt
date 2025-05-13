package com.example.sampleapp
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.sampleapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listener = View.OnClickListener { view ->
            val input = binding.inputEditText.text.toString()

            if (!isValidInput(input)) {
                binding.errorTextView.isVisible = true
                binding.outputTextView.text = ""
                return@OnClickListener
            } else {
                binding.errorTextView.isVisible = false
            }

            when (view.id) {
                R.id.btnLength -> {
                    val length = if (input.trim().isEmpty()) 0 else input.length
                    binding.outputTextView.text = length.toString()
                }
                R.id.btnReverse -> {
                    binding.outputTextView.text = if (input.trim().isEmpty()) "" else input.reversed()
                }
                R.id.btnAppend -> {
                    binding.outputTextView.text = "Hello $input"
                }
                R.id.btnNumeric -> {
                    binding.outputTextView.text = if (input.matches(Regex("\\d+"))) "Yes" else "No"
                }
                R.id.btnClear -> {
                    binding.inputEditText.text.clear()
                    binding.outputTextView.text = ""
                    binding.errorTextView.isVisible = false
                }
            }
        }

        binding.btnLength.setOnClickListener(listener)
        binding.btnReverse.setOnClickListener(listener)
        binding.btnAppend.setOnClickListener(listener)
        binding.btnNumeric.setOnClickListener(listener)
        binding.btnClear.setOnClickListener(listener)
    }

    private fun isValidInput(input: String): Boolean {
        return input.matches(Regex("[a-zA-Z0-9 ]*"))
    }
}

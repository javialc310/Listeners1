package com.example.listeners

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.listeners.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sumar.setOnClickListener {
            sumarValor()
        }
        binding.restar.setOnClickListener {
            restarValor()
        }

        escribirNum()
        cambiarColor()
    }

    fun sumarValor(){
        if(binding.textView.text.isNotEmpty())
            binding.textView.text= (binding.textView.text.toString().toInt()+1).toString()
    }

    fun restarValor(){
        if (binding.textView.text.toString() != "0" && binding.textView.text.isNotEmpty())
            binding.textView.text= (binding.textView.text.toString().toInt()-1).toString()
    }

    fun cambiarColor(){
        binding.editTextTextPersonName.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus){
                binding.restar.setBackgroundColor(Color.parseColor("#FF0000"))
                binding.sumar.setBackgroundColor(Color.parseColor("#FF0000"))
            }else{
                binding.restar.setBackgroundColor(Color.parseColor("#FF3700B3"))
                binding.sumar.setBackgroundColor(Color.parseColor("#FF3700B3"))
            }
        }
    }

    fun escribirNum(){
        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.textView.text = binding.editTextTextPersonName.text
                if (binding.textView.text.isEmpty())
                    binding.textView.text= "0"
            }
        })
    }
}
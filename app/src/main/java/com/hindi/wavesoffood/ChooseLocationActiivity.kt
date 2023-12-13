package com.hindi.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.hindi.wavesoffood.databinding.ActivityChooseLocationActiivityBinding

class ChooseLocationActiivity : AppCompatActivity() {
    private val binding: ActivityChooseLocationActiivityBinding by lazy {
        ActivityChooseLocationActiivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val locationList = arrayOf("jaipur" , "Odisha", "Bundi", "Sikar")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }
}
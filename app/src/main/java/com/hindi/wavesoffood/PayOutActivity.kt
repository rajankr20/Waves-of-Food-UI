package com.hindi.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hindi.wavesoffood.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeMyOrder.setOnClickListener {
            val bottomSheetDialog = CongrratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
    }
}
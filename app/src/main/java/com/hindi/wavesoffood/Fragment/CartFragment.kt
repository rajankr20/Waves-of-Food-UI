package com.hindi.wavesoffood.Fragment

import android.content.Intent
import  android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hindi.wavesoffood.CongrratsBottomSheet
import com.hindi.wavesoffood.PayOutActivity
import com.hindi.wavesoffood.R
import com.hindi.wavesoffood.adapter.CartAdapter
import com.hindi.wavesoffood.databinding.CartItemBinding
import com.hindi.wavesoffood.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)


        val cartFoodName = listOf("Burger", "sandwich", "momo", "item", "momo", "item")
        val cartItemPrice = listOf("$5", "$6", "$7", "$5", "$6", "$7")
        val cartImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu5,
            R.drawable.menu4,
            R.drawable.menu6,
        )

        val adapter =
            CartAdapter(ArrayList(cartFoodName), ArrayList(cartItemPrice), ArrayList(cartImage))
        binding.cartRecyclearView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclearView.adapter = adapter

        binding.proceedButton.setOnClickListener {
            val intent = Intent(requireContext(), PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }

    companion object {
    }
}
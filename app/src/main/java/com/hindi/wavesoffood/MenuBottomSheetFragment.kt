package com.hindi.wavesoffood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hindi.wavesoffood.adapter.MenuAdapter
import com.hindi.wavesoffood.databinding.FragmentMenuBottomSheetBinding


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
   private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener{
            dismiss()
        }

        val menuFoodName = listOf("Burger", "sandwich", "momo", "item", "momo", "item", "sandwich", "momo", "item", "momo", "item")
        val menuItemPrice = listOf("$5", "$6", "$7", "$5", "$6", "$7", "$6", "$7", "$5", "$6", "$7")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu5,
            R.drawable.menu4,
            R.drawable.menu6,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu5,
            R.drawable.menu4,
            R.drawable.menu6,
        )

        val adapter = MenuAdapter(
            ArrayList(menuFoodName),
            ArrayList(menuItemPrice),
            ArrayList(menuImage), requireContext()
        )
        binding.menuRecyclearView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclearView.adapter =adapter
//        binding.menuRecyclearView.Layou = LinearLayoutManager(requireContext())
//        binding.menuRecyclearView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}
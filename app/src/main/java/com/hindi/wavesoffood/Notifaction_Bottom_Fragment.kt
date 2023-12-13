package com.hindi.wavesoffood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hindi.wavesoffood.adapter.NotificationAdapter
import com.hindi.wavesoffood.databinding.FragmentNotifactionBottomBinding


class Notifaction_Bottom_Fragment : BottomSheetDialogFragment(){
     private lateinit var binding: FragmentNotifactionBottomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotifactionBottomBinding.inflate(layoutInflater,container, false)
        val notifications = listOf("your order has been Canceled SuccessFully", "Order has been taken by the driver", "Congrats your oredr")
        val notificationImages = listOf(R.drawable.sademoji, R.drawable.truck, R.drawable.congrats)

        val adapter = NotificationAdapter(ArrayList(notifications), ArrayList(notificationImages))

        binding.notificaionRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificaionRecyclerView.adapter = adapter
        return  binding.root
    }

    companion object {

    }
}
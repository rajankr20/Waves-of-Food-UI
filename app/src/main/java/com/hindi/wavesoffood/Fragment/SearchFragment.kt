package com.hindi.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.hindi.wavesoffood.R
import com.hindi.wavesoffood.adapter.MenuAdapter
import com.hindi.wavesoffood.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val orignalMenuFoodName = listOf("Burger", "sandwich", "momo", "item", "momo", "item", "sandwich", "momo", "item", "momo", "item")
    private val orignalMenuItemPrice = listOf("$5", "$6", "$7", "$5", "$6", "$7", "$6", "$7", "$5", "$6", "$7")

    private val orignalMenuImage = listOf(
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice =mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage, requireContext())
        binding.menuRecyclearView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclearView.adapter = adapter

        // setup for search views
        setupSearchVies()

        // show all menu items
        showAllMenu()

        return  binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(orignalMenuFoodName)
        filteredMenuItemPrice.addAll(orignalMenuItemPrice)
        filteredMenuImage.addAll(orignalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchVies() {
        binding.searchView.setOnQueryTextListener( object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        orignalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query.toString(),ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(orignalMenuItemPrice[index])
                filteredMenuImage.add(orignalMenuImage[index])
            }
        }

        adapter.notifyDataSetChanged()

    }

    companion object {
    }
}

private fun <E> MutableList<E>.add(element: String) {

}

private fun <E> MutableList<E>.add(element: List<E>) {

}

package com.hindi.wavesoffood



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.hindi.wavesoffood.Fragment.CartFragment
import com.hindi.wavesoffood.Fragment.HistoryFragment
import com.hindi.wavesoffood.Fragment.HomeFragment
import com.hindi.wavesoffood.Fragment.SearchFragment
import com.hindi.wavesoffood.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
 private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navController = findNavController(R.id.fragmentContainerView)
//        val bottomnav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        bottomnav.setupWithNavController(navController)

        replaceFragment(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {

           when(it.itemId){
               R.id.homeFragment -> replaceFragment(HomeFragment())
               R.id.profileFragment -> replaceFragment(HomeFragment())
               R.id.searchFragment -> replaceFragment(SearchFragment())
               R.id.historyFragment -> replaceFragment(HistoryFragment())
               R.id.cartFragment -> replaceFragment(CartFragment())
               else ->{
               }
           }
            true
        }

        binding.notificationButton.setOnClickListener {
            val bottomSheetDialog = Notifaction_Bottom_Fragment()
            bottomSheetDialog.show(supportFragmentManager, "Test")
        }
    }
    private fun replaceFragment(fragment : Fragment){
       val fragmentManager =supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
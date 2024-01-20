package com.example.bottomnavigation_viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.bottomnavigation_viewpager.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback
import com.google.android.material.navigation.NavigationBarView

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private val mOnNavigationSelectedLitener = NavigationBarView.OnItemSelectedListener {
        item ->
        when(item.itemId)
        {
            R.id.menu_1 ->{
                binding.viewPager.currentItem = 0
                return@OnItemSelectedListener true
            }
            R.id.menu_2 ->{
                binding.viewPager.currentItem = 1
                return@OnItemSelectedListener true
            }
            R.id.menu_3 ->{
                binding.viewPager.currentItem = 2
                return@OnItemSelectedListener true
            }


        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.viewPager.adapter = viewPagerAdapter
        binding.navigationBar.setOnItemSelectedListener(mOnNavigationSelectedLitener)
        binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position)
                {
                    1->binding.navigationBar.menu.findItem(R.id.menu_1).isChecked = true
                    2->binding.navigationBar.menu.findItem(R.id.menu_2).isChecked = true
                    3->binding.navigationBar.menu.findItem(R.id.menu_3).isChecked = true
                }
            }
        })
    }
}
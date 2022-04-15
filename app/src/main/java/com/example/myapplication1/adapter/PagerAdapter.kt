package com.example.myapplication1.adapter

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication1.liste
import com.example.myapplication1.maps

class PagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { maps() }
            1 -> { liste() }
            else -> {
                throw Resources.NotFoundException("position non trouvée")
            }
        }
    }
}

package com.example.myapplication1


import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.adapter.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        view_pager_2.adapter= PagerAdapter(this)

        TabLayoutMediator(tab_layout,view_pager_2){tab,position->
            when(position){
                0->{
                    tab.text="maps"
                }
                1->{
                    tab.text="liste" }
                else->{
                    throw Resources.NotFoundException("position non trouvé")
                }

            }
        }.attach()


    }
}




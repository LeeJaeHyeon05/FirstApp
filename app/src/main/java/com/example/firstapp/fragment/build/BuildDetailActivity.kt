package com.example.firstapp.fragment.build

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityBuildDetailBinding
import com.example.firstapp.fragment.build.detail.DetailViewPagerAdapter
import com.example.firstapp.fragment.build.detail.mybuild.AddMyBuildFragment
import com.example.firstapp.fragment.build.detail.mybuild.DetailMyBuildFragment
import com.example.firstapp.fragment.build.detail.mybuild.dialog.ItemBuildDialogFragment
import com.example.firstapp.fragment.build.detail.mybuild.dialog.SkillBuildDialogFragment
import com.google.android.material.tabs.TabLayoutMediator

class BuildDetailActivity : AppCompatActivity() {

    val binding by lazy { ActivityBuildDetailBinding.inflate(layoutInflater) }
    private lateinit var addMyBuildFragment : AddMyBuildFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = DetailViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        val tabTitles = arrayListOf("빌드", "프로 빌드", "기타 빌드" , "통계", "카운터", "팁", "내 빌드")
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab , position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    fun openAddMyBuild(){
        addMyBuildFragment = AddMyBuildFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.buildDetailContainer, addMyBuildFragment)
            .addToBackStack(null)
            .commit()
    }

    fun closeAddMyBuild(){
        supportFragmentManager.beginTransaction()
            .remove(addMyBuildFragment)
            .commit()
        //fragment refresh 해주기
    }

    fun showSkillBuildDialog(){
        val dialog = SkillBuildDialogFragment()
        dialog.show(supportFragmentManager, "Skill Build")
    }

    fun showItemBuildDialog(){
        val dialog = ItemBuildDialogFragment()
        dialog.show(supportFragmentManager, "Item Build")
    }
}
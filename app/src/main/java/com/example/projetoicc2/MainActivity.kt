package com.example.projetoicc2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.projetoicc2.databinding.ActivityMainBinding
import mehdi.sakout.aboutpage.AboutPage


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        handleFilter(R.id.image_home)

        binding.imageHome.setOnClickListener(this)
        binding.imageMusic.setOnClickListener(this)
        binding.imageBook.setOnClickListener(this)
        binding.imageAnotation.setOnClickListener(this)
        binding.imageInfo.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.image_home -> {
                handleFilter(view.id)
            }
            R.id.image_music -> {
                handleFilter(view.id)
            }
            R.id.image_book -> {
                handleFilter(view.id)
            }
            R.id.image_anotation -> {
                handleFilter(view.id)
            }
            R.id.image_info -> {
                return startActivity(Intent(this, InfoActivity::class.java))
                handleFilter(view.id)
            }
        } /*if (view.id in listOf(
                R.id.image_home,
                R.id.image_music,
                R.id.image_book,
                R.id.image_anotation,
            )
        ){
            handleFilter(view.id)
        }*/
    }

    private fun handleFilter(id: Int) {

        binding.imageHome.setColorFilter(ContextCompat.getColor(this, R.color.white))
        binding.imageMusic.setColorFilter(ContextCompat.getColor(this, R.color.white))
        binding.imageBook.setColorFilter(ContextCompat.getColor(this, R.color.white))
        binding.imageAnotation.setColorFilter(ContextCompat.getColor(this, R.color.white))
        binding.imageInfo.setColorFilter(ContextCompat.getColor(this, R.color.white))

        when (id) {
            R.id.image_home -> {
                binding.imageHome.setColorFilter(ContextCompat.getColor(this, R.color.darkGray))
            }
            R.id.image_music -> {
                binding.imageMusic.setColorFilter(ContextCompat.getColor(this, R.color.darkGray))
            }
            R.id.image_book -> {
                binding.imageBook.setColorFilter(ContextCompat.getColor(this, R.color.darkGray))
            }
            R.id.image_anotation -> {
                binding.imageAnotation.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.darkGray
                    )
                )
            }
            R.id.image_info -> {
                binding.imageInfo.setColorFilter(ContextCompat.getColor(this, R.color.darkGray))
            }
        }
    }
}
package com.dicoding.fundamentl_subs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.dicoding.fundamentl_subs.databinding.ActivityClickedItemDetailBinding

class ClickedItemDetail : AppCompatActivity() {

    private lateinit var binding: ActivityClickedItemDetailBinding

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickedItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sand = intent.getParcelableExtra<Sandwhiches>(EXTRA_DATA) as Sandwhiches
        binding.imgItemPhoto.setImageResource(sand.Avatar)
        binding.tvItemName.text = sand.Name
        binding.tvItemUName.text = sand.Username
        binding.tvItemCompany.text = sand.Company
        binding.tvItemFollowers.text = sand.Followers
        binding.tvItemFollowing.text = sand.Following
        binding.tvItemLocation.text = sand.Location
        binding.tvItemRepo.text = sand.Repository
    }
}
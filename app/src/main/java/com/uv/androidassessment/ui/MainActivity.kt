package com.uv.androidassessment.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.uv.androidassessment.databinding.ActivityMainBinding
import com.uv.androidassessment.ui.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchUser()

        viewModel.userData.observe(this) { user ->
            if (user != null) {
                binding.tvName.text = user.name
                binding.tvUsername.text = user.username
                binding.tvLocation.text = "${user.location.city}, ${user.location.country}"
                binding.tvFollowers.text = "Followers: ${user.statistics.followers}"
                binding.tvFollowing.text = "Following: ${user.statistics.following}"

                // Load image using Glide
                Glide.with(this)
                    .load(user.avatar)
                    .into(binding.ivAvatar)
            } else {
                binding.tvName.text = "Error loading user"
            }
        }
    }
}

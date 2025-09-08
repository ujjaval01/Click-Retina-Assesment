package com.uv.androidassessment.ui

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
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
                // Basic Info
                binding.tvName.text = user.name
                binding.tvUsername.text = user.username
                binding.tvLocation.text = "${user.location.city}, ${user.location.country}"

                // Statistics
                binding.tvFollowers.text = "${user.statistics.followers}"
                binding.tvFollowing.text = "${user.statistics.following}"
//                binding.tvShots.text = "Shots: ${user.statistics.activity.shots}"
//                binding.tvCollections.text = "Collections: ${user.statistics.activity.collections}"
//
//                // Socials
//                binding.tvWebsite.text = user.social.website
//                binding.tvWebsite.movementMethod = LinkMovementMethod.getInstance() // make link clickable

                // Profiles (Instagram, Facebook, etc.)
                val profilesText = user.social.profiles.joinToString("\n") {
                    "${it.platform}: ${it.url}"
                }
//                binding.tvProfiles.text = profilesText

                // Avatar
                Glide.with(this)
                    .load(user.avatar)
                    .into(binding.ivAvatar)

            } else {
                binding.tvName.text = "Error loading user"
            }
        }
    }
}

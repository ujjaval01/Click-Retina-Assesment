package com.uv.androidassessment.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import com.bumptech.glide.Glide
import com.uv.androidassessment.databinding.ActivityMainBinding
import com.uv.androidassessment.ui.viewmodel.UserViewModel
import okhttp3.internal.platform.Platform

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.VISIBLE
        binding.mainContent.visibility = View.GONE

        viewModel.fetchUser()

        Handler(Looper.getMainLooper()).postDelayed({
        viewModel.userData.observe(this) { user ->
            if (user != null) {

                binding.progressBar.visibility = View.GONE
                binding.mainContent.visibility = View.VISIBLE

                binding.tvName.text = user.name
                binding.tvUsername.text = user.username
                binding.tvLocation.text = "${user.location.city}, ${user.location.country}"


                binding.tvFollowers.text = "${user.statistics.followers}"
                binding.tvFollowing.text = "${user.statistics.following}"
                binding.tvShots.text = "${user.statistics.activity.shots} Shots"
                binding.tvCollections.text = "${user.statistics.activity.collections} Collections"

                Glide.with(this)
                    .load(user.avatar)
                    .into(binding.ivAvatar)


                binding.tvWebsite.setOnClickListener{
                    openUrl(user.social.website)
                }


                user.social.profiles.forEach { profile ->
                    when (profile.platform.lowercase()) {
                        "instagram" -> {
                            binding.anmInstagram.setOnClickListener {
                                openUrl(profile.url)
                            }
                        }
                        "facebook" -> {
                            binding.anmFacebook.setOnClickListener {
                                openUrl(profile.url)
                            }
                        }
                    }
                    binding.ivSettings.setOnClickListener {
                        Toast.makeText(this, "Coming soon...", Toast.LENGTH_SHORT).show()
                    }
                    binding.anmFacebook.setOnClickListener {
                        Toast.makeText(this, "Coming soon...", Toast.LENGTH_SHORT).show()
                    }
                    binding.anmTwitter.setOnClickListener {
                        Toast.makeText(this, "Coming soon...", Toast.LENGTH_SHORT).show()
                    }
                    binding.anmGithub.setOnClickListener {
                        openUrl("https://github.com/ujjaval01")
                    }
                    binding.tvCollections.setOnClickListener {
                        Toast.makeText(this, "Is on maintenance...", Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                binding.tvName.text = "Error loading user..."
            }

        }
    },3000)
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}

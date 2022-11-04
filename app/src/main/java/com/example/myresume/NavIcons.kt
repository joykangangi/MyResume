package com.example.myresume


//storing icons, to easily access iconId and icon name-default param from enum class
enum class NavIcons(var iconId: Int) {
    GitHub(iconId = R.drawable.github_logo),
    Gmail(iconId = R.drawable.gmail_logo),
    LinkedIn(iconId = R.drawable.linkedin_logo),
    Twitter(iconId = R.drawable.twitter_logo)
}
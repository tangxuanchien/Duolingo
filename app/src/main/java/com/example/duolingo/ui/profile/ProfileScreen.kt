package com.example.duolingo.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.duolingo.ui.components.NavigationBar
import com.example.duolingo.ui.profile.components.FriendStreaks
import com.example.duolingo.ui.profile.components.Overview
import com.example.duolingo.ui.profile.components.ProfileAction
import com.example.duolingo.ui.profile.components.ProfileInformation

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 10.dp, horizontal = 10.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            ProfileInformation(
                name = "Tang Xuan Chien",
                hashtag = "@tangxchien",
                joined = "November 2003"
            )
            ProfileAction(
                onClickShare = {},
                onClickInvite = {}
            )
            Overview()
            FriendStreaks()
        }
        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProfileScreen(
) {
    ProfileScreen()
}
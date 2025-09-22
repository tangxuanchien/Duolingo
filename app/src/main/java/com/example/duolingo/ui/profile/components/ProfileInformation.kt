package com.example.duolingo.ui.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.R
import java.nio.file.WatchEvent

@Preview(showBackground = true)
@Composable
fun ProfileInformation(
    name: String = "Tang Xuan Chien",
    hashtag: String = "@tangxchien",
    joined: String = "November 2003",
    courses: Int = R.drawable.french,
    following: String = "10",
    followers: String = "9"
) {
    Column {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = name,
            fontWeight = FontWeight.Companion.Bold,
            fontSize = 24.sp,
            color = Color(0xFF4B4B4B),
            modifier = Modifier.padding(top = 10.dp, bottom = 6.dp)
        )
        Row {
            Text(
                text = hashtag,
                fontSize = 18.sp,
                color = Color(0xFF777777)
            )
            Text(
                text = " · Joined $joined",
                fontSize = 18.sp,
                color = Color(0xFF777777)
            )
        }
        Row(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Column {
                Icon(
                    imageVector = ImageVector.Companion.vectorResource(courses),
                    contentDescription = "Icon Overview",
                    tint = Color.Companion.Unspecified,
                    modifier = Modifier.Companion.size(21.dp)
                )
                Text(
                    text = "Courses",
                    fontSize = 18.sp,
                    color = Color(0xFF777777)
                )
            }
            VerticalDivider(
                color = Color.LightGray,
                thickness = 3.dp,
                modifier = Modifier.height(45.dp)
                    .padding(horizontal = 12.dp)
            )
            Column {
                Text(
                    text = following,
                    fontWeight = FontWeight.Companion.Bold,
                    fontSize = 18.sp,
                    color = Color(0xFF4B4B4B)
                )
                Text(
                    text = "Following",
                    fontSize = 18.sp,
                    color = Color(0xFF777777)
                )
            }
            VerticalDivider(
                color = Color.LightGray,
                thickness = 3.dp,
                modifier = Modifier.height(45.dp)
                    .padding(horizontal = 12.dp)
            )
            Column {
                Text(
                    text = followers,
                    fontWeight = FontWeight.Companion.Bold,
                    fontSize = 18.sp,
                    color = Color(0xFF4B4B4B)
                )
                Text(
                    text = "Followers",
                    fontSize = 18.sp,
                    color = Color(0xFF777777)
                )
            }
        }
    }
}
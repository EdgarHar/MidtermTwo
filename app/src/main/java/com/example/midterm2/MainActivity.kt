package com.example.midterm2

import android.graphics.fonts.FontFamily
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midterm2.ViewModel.UserLoaderViewModel
import com.example.midterm2.domain.User

class MainActivity : ComponentActivity() {
    private val userLoader: UserLoaderViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userLoader.loadUsers()
        setContent {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(color = Color.Magenta)
                )
                {
                    Text(text = "USERS",
                        modifier = Modifier.align(Alignment.Center),
                        style =  MaterialTheme.typography.h5,
                        fontSize = 20.sp,
                        color = Color.White)
                }
                ListOfUsers(list = userLoader.userList.observeAsState().value!!)
            }
        }
    }
}

@Composable
fun DisplayUser(user: User) {
    Card(
        shape = RectangleShape,
        elevation = 4.dp,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = user.fullName?.first + user.fullName?.last,
                fontWeight = FontWeight.Bold)
            user.email?.let { Text(text = it) }

            user.nationality?.let { Text(text = it,
            color = Color.Green) }
        }
    }
}

@Composable
fun ListOfUsers(list: List<User>) {
    LazyColumn {
        items(list) {
            DisplayUser(user = it)
        }
    }
}
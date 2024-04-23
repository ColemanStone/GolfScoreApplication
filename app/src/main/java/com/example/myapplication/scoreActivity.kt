package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class scoreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                ScorePage()
            }
        }
    }
}

@Composable
fun ScorePage() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("How many holes of golf will you play?")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            // Handle 9 holes choice
            val intent = Intent(context, NineHoleActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("9 Holes")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            // Handle 18 holes choice
            val intent = Intent(context, EighteenHoleActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("18 Holes")
        }
    }
}

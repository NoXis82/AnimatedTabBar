package com.example.animatedtabbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.animatedtabbar.components.TabBar
import com.example.animatedtabbar.ui.theme.AnimatedTabBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedTabBarTheme {
                TabBar()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabBarPreview() {
    TabBar()
}
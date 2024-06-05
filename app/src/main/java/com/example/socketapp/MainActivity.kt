package com.example.socketapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socketapp.ui.theme.SocketAppTheme
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket

class MainActivity : ComponentActivity() {
    private var apiKey = "fC66ycvEhExZuJJZd2Xq2Ey1YnlX17P0kiZ7TRyH"
    private var channelId = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocketAppTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Button(
                        onClick = {
                            val request = Request
                                .Builder()
                                .url("wss://demo.piesocket.com/v3/$channelId?api_key=$apiKey&notify_self")
                                .build()
                            val listener = WebSocketListener()
                            val client: OkHttpClient =  OkHttpClient()
                            val ws: WebSocket = client.newWebSocket(request, listener)
                            Log.d("Hacker","websocket is $ws")
                            ws.send("Hello From my phone")
                        },
                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    ) {
                        Text(text = "Connect to Socket", fontSize = 28.sp)
                        Log.d("Hacker", "sss")
                    }
                }
            }
        }
    }
}



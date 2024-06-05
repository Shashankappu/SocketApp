package com.example.socketapp


import android.util.Log
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener


open class WebSocketListener : WebSocketListener() {

    companion object{
        private const val NORMAL_CLOSURE_STATUS = 1000
    }
    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        webSocket.send("Hi")
        Log.d("Hacker","connected")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        Log.d("Hacker","message is $text")
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosing(webSocket, code, reason)
        webSocket.close(NORMAL_CLOSURE_STATUS,null)
        Log.d("Hacker","Closed $code and $reason")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        Log.d("Hacker","onFailure ${t.message}, response : $response")
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        Log.d("Hacker","onclosed")
        super.onClosed(webSocket, code, reason)
    }



}
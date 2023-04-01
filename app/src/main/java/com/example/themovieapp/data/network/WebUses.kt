package com.example.themovieapp.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.net.InetSocketAddress
import java.net.Socket

object WebUses {
    suspend fun isConnected() = coroutineScope {
        return@coroutineScope try {
            val sock =Socket()
            val socketAddress = InetSocketAddress("8.8.8.8",53)
            withContext(Dispatchers.IO) {
                sock.connect(socketAddress, 2000)
            }
            withContext(Dispatchers.IO) {
                sock.close()
            }
            true
        }catch (e:Exception){
            false
        }
    }
}
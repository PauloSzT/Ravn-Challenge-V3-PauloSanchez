package com.example.starwarschallenge.adapter

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient

class StarWarsApi {
    fun getApolloClient(): ApolloClient {
        val okHttpClient = OkHttpClient.Builder().build()
        return ApolloClient.Builder()
            .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index")
            .okHttpClient(okHttpClient)
            .build()
    }
}

package com.example.mytamashaapi.network

import com.example.mytamashaapi.model.TamashaResponse
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {

    @GET("61cf7d91-a7f8-405e-b505-67926b759d78")
    suspend fun getTamashaList(): Response<TamashaResponse>
}
package com.example.buss

import com.example.example.AuthRequest
import com.example.example.AuthResponse
import com.example.example.RegisterRequest
import com.example.example.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.Call
import retrofit2.http.Headers

interface BusApiService {
    @GET("/api/v1/City/getallcitynames")
    suspend fun getAllCityNames(): AllCitiesNames


    @GET("/api/v1/City/getallcities")
    suspend fun getAllCities(): AllCities

    @GET("/api/v1/BusBrand/GetAllBusBrands")
    suspend fun getAllBusBrands(): AllBusBrands

    @GET("/api/v1/FollowTrip/GetAllFollowTripsByUser")
    suspend fun getAllFollowTrips(): AllFollowedTrips

    @GET("/api/v1/UserComment/GetBusBrandComments/{bus_brand_id}")
    suspend fun getBusBrandComments(@Path("bus_brand_id") bus_brand_id: Int): BusReview


    @GET("/api/v1/City/findtrips/departure_city/country_code/{departure_city_country_code}/name/{departure_city_name}/arrival_city/country_code/{arrival_city_country_code}/name/{arrival_city_name}/date/{date}/adult/{adult}")
    suspend fun findTrip(
        @Path("departure_city_name") departure: String,
        @Path("arrival_city_name") arrival: String,
        @Path("date") date: String,
        @Path("adult") adult: Int,
        @Path("departure_city_country_code") departure_country_code: String,
        @Path("arrival_city_country_code") arrival_country_code: String
    ): FindTrip

    @Headers("Content-Type: application/json")
    @POST("/api/Account/authenticate")
    fun authenticate(@Body authRequest: AuthRequest): Call<AuthResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/v1/FollowTrip/CreateFollowTrip")
    fun followTrip(@Body followTripRequest: FollowTripRequest): Call<FollowTripResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/Account/register")
    fun register(@Body registerRequest: RegisterRequest): Call<RegisterResponse>



}
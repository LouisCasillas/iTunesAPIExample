package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample.api.ApiService
import com.example.retrofitexample.model.ITunesResponse
import com.example.retrofitexample.view.SongAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var rvUserList: RecyclerView
    lateinit var songAdapter: SongAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUserList = findViewById(R.id.rv_user_list)

        startRetrofit()
    }

    private fun startRetrofit() {
        ApiService.createRetrofit().create(ApiService::class.java).getSongs()
            .enqueue(object: Callback<ITunesResponse>{
                override fun onResponse(
                    call: Call<ITunesResponse>,
                    response: Response<ITunesResponse>
                ) {
                    if (response.isSuccessful) {
                        songAdapter = SongAdapter(response.body()!!.results)
                        rvUserList.adapter = songAdapter
                    }
                }

                override fun onFailure(call: Call<ITunesResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}
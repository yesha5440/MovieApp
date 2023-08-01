package com.example.movieapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.API.ApiClient
import com.example.movieapp.API.ApiInterface
import com.example.movieapp.Adapter.UpcomingAdapter
import com.example.movieapp.Model.ResultsItem
import com.example.movieapp.Model.UpcomingMovieModel
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentNowPlayingBinding
import retrofit2.Call
import retrofit2.Response

class NowPlayingFragment : Fragment() {

    var adapter = UpcomingAdapter()
    var page = 1
    var movieList = ArrayList<ResultsItem>()
    lateinit var binding: FragmentNowPlayingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding = FragmentNowPlayingBinding.inflate(layoutInflater)
      binding.Nested.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener{v, scrollX, scrollY, oldScrollX, oldScrollY ->

          if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight){

              page++
              callApi(page)

          }

      })
        callApi(page)

        return binding.root

    }

    private fun callApi(page: Int) {
        var api = ApiClient.getApiClient().create(ApiInterface :: class.java)
        api.getNowPlayingMovies(page).enqueue(object : retrofit2.Callback<UpcomingMovieModel>{
            override fun onResponse(
                call: retrofit2.Call<UpcomingMovieModel>,
                response: retrofit2.Response<UpcomingMovieModel>
            ) {
                if (response.isSuccessful){
                    var NowPlayinglist = response.body()?.results

                    movieList.addAll(NowPlayinglist as List<ResultsItem>)
                    adapter.setMovies(movieList)
                    binding.rcvUpcoming.layoutManager = LinearLayoutManager(context)
                    binding.rcvUpcoming.adapter = adapter

                }
            }

            override fun onFailure(call: Call<UpcomingMovieModel>, t: Throwable) {

            }
        })
    }
}
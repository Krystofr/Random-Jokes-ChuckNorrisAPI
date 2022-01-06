package app.christopher.chucknorrisjokes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.christopher.chucknorrisjokes.R
import app.christopher.chucknorrisjokes.adapter.SearchRecyclerAdapter
import app.christopher.chucknorrisjokes.model.RandomJoke
import app.christopher.chucknorrisjokes.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(R.layout.fragment_search), SearchRecyclerAdapter.OnItemClickedListener {

    private lateinit var mainViewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //init view model
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //init recyclerview
        val searchRecyclerAdapter = SearchRecyclerAdapter(arrayListOf(), requireContext(), this)
        searchJokes.apply {
            searchJokes.adapter = searchRecyclerAdapter
            searchJokes.layoutManager =
                LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            searchJokes.setHasFixedSize(true)
        }

        //listen to incoming search results
        mainViewModel.search.observe(viewLifecycleOwner) {
            searchRecyclerAdapter.results = it.result
            searchRecyclerAdapter.notifyDataSetChanged()
        }

        //search text
        btn_search.setOnClickListener {
            val query = et_query.text
            if (!query.isNullOrBlank())
                mainViewModel.setQuerySearch(query.toString())
            else
                Toast.makeText(context, "Enter text to search", Toast.LENGTH_SHORT).show()
        }

        search_swipeRL.apply {
            setOnRefreshListener {
                isRefreshing = true
                swipeRefreshLayout()
                isRefreshing = false
            }
        }

    }

    override fun onItemClick(randomJoke: RandomJoke) {
        //search item clicked
    }

    private fun swipeRefreshLayout() {
        Toast.makeText(activity, "Refreshed", Toast.LENGTH_SHORT).show()
        activity?.overridePendingTransition(R.anim.slide_in, R.anim.slide_in)
        activity?.overridePendingTransition(R.anim.slide_in, R.anim.slide_in)
    }
}
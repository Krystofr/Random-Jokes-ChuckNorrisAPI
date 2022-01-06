package app.christopher.chucknorrisjokes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import app.christopher.chucknorrisjokes.R
import app.christopher.chucknorrisjokes.adapter.CategoriesRecyclerAdapter
import app.christopher.chucknorrisjokes.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment(), CategoriesRecyclerAdapter.OnItemClickedListener {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //init view model
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //init recyclerview
        val categoriesRecyclerAdapter = CategoriesRecyclerAdapter(arrayListOf(),requireContext(),this)
        category_recyclerview.apply {
            adapter = categoriesRecyclerAdapter
            layoutManager = GridLayoutManager(activity, 2)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        //get categories from api
        mainViewModel.categories.observe(viewLifecycleOwner) {
            categoriesRecyclerAdapter.results = it
            categoriesRecyclerAdapter.notifyDataSetChanged()
        }

        //listen to incoming categories joke from api
        mainViewModel.randomCatJoke.observe(viewLifecycleOwner) {
            //show joke in popup with ok button
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Chuck Joke")
            builder.setMessage(it.value)
            builder.setIcon(R.drawable.chuck_norris)
            builder.setPositiveButton("OKAY") { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
        }

        category_swipeRL.apply {
            setOnRefreshListener {
                isRefreshing = true
                swipeRefreshLayout()
                isRefreshing = false
            }
        }
    }

    override fun onItemClick(category: String) {
        //category clicked, fetch and display a random joke
        mainViewModel.setCategory(category)
    }

    private fun swipeRefreshLayout() {
        Toast.makeText(activity, "Refreshed", Toast.LENGTH_SHORT).show()
        activity?.overridePendingTransition(R.anim.slide_in, R.anim.slide_in)
        activity?.overridePendingTransition(R.anim.slide_in, R.anim.slide_in)

    }
}
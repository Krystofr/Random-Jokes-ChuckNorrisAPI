package app.christopher.chucknorrisjokes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import app.christopher.chucknorrisjokes.R
import app.christopher.chucknorrisjokes.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //init view model
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        navController = findNavController()

        //show random joke
        btn_random.setOnClickListener {
            //get random joke from api
            mainViewModel.randomJoke.observe(viewLifecycleOwner) {
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
        }

        //Navigate to joke search fragment
        btn_search.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

        //Navigate to categories fragment
        btn_categories.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categoryFragment)
        }
    }

}
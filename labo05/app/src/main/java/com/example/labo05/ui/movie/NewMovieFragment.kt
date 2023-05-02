package com.example.labo05.ui.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.labo05.R
import com.example.labo05.data.model.MovieModel
import com.example.labo05.data.name2
import com.example.labo05.databinding.FragmentNewMovieBinding

class NewMovieFragment : Fragment() {

    private val movieViewModel : MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var name: EditText
    private lateinit var category: EditText
    private lateinit var description: EditText
    private lateinit var calification: EditText
    private lateinit var save: Button

    private lateinit var binding: FragmentNewMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentNewMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // bind()
        setViewModel()
        observeStatus()
    }

     private fun setViewModel(){
         binding.viewmodel = movieViewModel
     }

    private fun observeStatus(){
        movieViewModel.status.observe(viewLifecycleOwner){status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION)->{
                    Log.d("APP_TAG", status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED)->{
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

  /*/  private fun bind(){
        name = view?.findViewById(R.id.nombretext)!!
        category =view?.findViewById(R.id.categoriatext)!!
        description =view?.findViewById(R.id.descripciontext)!!
        calification = view?.findViewById(R.id.calificationtext)!!
        save =view?.findViewById(R.id.submit)!!
    }

    private fun addMovie() {
        val namesave = name.text.toString()
        val categorysave = category.text.toString()
        val descriptionsave = description.text.toString()
        val calificationsave = calification.text.toString()

        val movie = MovieModel(namesave,categorysave,descriptionsave,calificationsave)

        movieViewModel.addMovies(movie)
        Log.d("lista",movieViewModel.getMovies().toString())
    }

   */
}
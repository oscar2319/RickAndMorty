package com.example.rickandmorty.charactersList

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickandmorty.R
import com.example.rickandmorty.charactersList.data.network.CharactersService
import com.example.rickandmorty.charactersList.data.network.response.CharacterInfo
import com.example.rickandmorty.charactersList.data.repository.CharactersRepository
import com.example.rickandmorty.charactersList.domain.AddCharactersUseCase
import com.example.rickandmorty.charactersList.domain.GetCharactersUseCase
import com.example.rickandmorty.charactersList.model.CharactersDetails
import com.example.rickandmorty.db.entities.CharactersEntity
import com.example.rickandmorty.utils.Mapper
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val addCharactersUseCase: AddCharactersUseCase
    ) : ViewModel() {
    private val _charactersList = MutableLiveData<List<CharactersDetails>>().apply {
        value = emptyList()
    }
        val charactersList: LiveData<List<CharactersDetails>>
            get() = _charactersList



    var counter = 1
    fun showCharacters(context: Context){

        val isNetwork =  isInternetAvailable(context)

        if(isNetwork){
            //from service
            viewModelScope.launch {
                getCharactersUseCase(counter){
                    if (it != null) {
                        addCharacters(counter, it.results)
                        val listFromService = Mapper.characterInfoToCharacterDetails(it.results)

                        val list = _charactersList.value?.union(listFromService)
                        _charactersList.postValue(list?.toList())
                        counter++
                    }
                }
            }


        }else{
            //from database
            var dataToReturn: List<CharactersEntity>  = emptyList()
            GlobalScope.launch(Dispatchers.IO) {
                dataToReturn =  getCharactersUseCase.getResults()
                Log.d("TAG-1", "dataToReturn $dataToReturn")

                val detailsFromDB = dataToReturn.map {
                    Log.d("TAG-1", "IT $it")
                    CharactersDetails(
                        it.image,
                        it.name,
                        it.species,
                        it.status
                    )
                }
                _charactersList.postValue(detailsFromDB)
            }
            counter++
        }
    }
    private fun addCharacters(page: Int, characterInfo: List<CharacterInfo>){
        viewModelScope.launch {
            addCharactersUseCase(page,characterInfo)
        }
    }

    private fun isInternetAvailable(context: Context): Boolean {
        var result = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }

                }
            }
        }

        return result
    }
}
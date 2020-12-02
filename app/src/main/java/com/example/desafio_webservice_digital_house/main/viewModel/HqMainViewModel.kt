package com.example.desafio_webservice_digital_house.main.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.desafio_webservice_digital_house.utils.model.HqModel
import com.example.desafio_webservice_digital_house.utils.repository.HqRepository
import kotlinx.coroutines.Dispatchers

class HqMainViewModel(
    private val repository: HqRepository
): ViewModel() {

    fun getList() = liveData(Dispatchers.IO) {
        val response = repository.getHqs()
        emit(response.data.results)
    }


    class HqMainViewModelFactory(
        private val repository: HqRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HqMainViewModel(repository) as T
        }
    }
}
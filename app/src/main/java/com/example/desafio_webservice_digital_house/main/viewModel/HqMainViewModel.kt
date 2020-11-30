package com.example.desafio_webservice_digital_house.main.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafio_webservice_digital_house.utils.model.HqModel
import com.example.desafio_webservice_digital_house.utils.repository.HqRepository

class HqMainViewModel(
    private val repository: HqRepository
): ViewModel() {

    val hqList = MutableLiveData<MutableList<HqModel>>()

    fun getHqList() {
        repository.getHqList {
            hqList.value = it
        }
    }


    class HqMainViewModelFactory(
        private val repository: HqRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HqMainViewModel(repository) as T
        }
    }
}
package com.example.desafio_webservice_digital_house.detail.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafio_webservice_digital_house.main.viewModel.HqMainViewModel
import com.example.desafio_webservice_digital_house.utils.model.HqModel
import com.example.desafio_webservice_digital_house.utils.repository.HqRepository

class HqDetailsViewModel(
    private val repository: HqRepository
): ViewModel() {

    val hqList = MutableLiveData<MutableList<HqModel>>()

    fun getHqList() {
        repository.getHqList {
            hqList.value = it
        }
    }


    class HqDetailsViewModelFactory(
        private val repository: HqRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HqDetailsViewModel(repository) as T
        }
    }
}
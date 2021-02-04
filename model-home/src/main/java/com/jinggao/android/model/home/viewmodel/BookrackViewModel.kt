package com.jinggao.android.model.home.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.jinggao.android.common.LogEnum
import com.jinggao.android.common.logWithTag
import com.jinggao.android.model.home.BR
import com.jinggao.android.model.home.R
import com.jinggao.android.model.home.model.BookrackModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.goldze.mvvmhabit.base.BaseViewModel
import me.goldze.mvvmhabit.binding.command.BindingCommand
import me.goldze.mvvmhabit.binding.command.BindingConsumer
import me.tatarka.bindingcollectionadapter2.ItemBinding
import java.net.URLDecoder

class BookrackViewModel(application: Application) :
    BaseViewModel<BookrackModel>(application, BookrackModel()) {
    private val TAG: String = BookrackViewModel::class.java.getSimpleName()


    val presenterScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.Main + Job())
    }

    //给RecyclerView添加ObservableList
    var observableList: ObservableList<RecyclerBookrackItemViewModel> =
        ObservableArrayList()

    //给RecyclerView添加ItemBinding
    var itemBinding: ItemBinding<RecyclerBookrackItemViewModel> = ItemBinding.of(
        BR.viewModel,
        R.layout.item_bookrack_recyclerview
    )

    var tests:String = "测试测试测试"

    var onQmRefreshCommand:BindingCommand<BindingConsumer<Boolean>>? = BindingCommand(BindingConsumer {
        presenterScope.launch {
            loadRecommendedList()
            it.call(true)
        }

    })

    var onQmLoadMoreCommand: BindingCommand<BindingConsumer<Boolean>>? = null


    override fun onCreate() {
        super.onCreate()
        loadData(true)
    }

    fun loadData(show:Boolean) {
        presenterScope.launch {
            if(show){
                showDialog()
            }
            loadRecommendedList()
            if (show){
                dismissDialog()
            }
        }
    }

    suspend fun loadRecommendedList(){
        var recommendedList = model.getBookcaseIsRecommendedList()
        recommendedList?.books?.forEach(action = {
            it.cover = URLDecoder.decode(it.cover).replace("/agent/", "")
            it.cover.logWithTag(TAG, LogEnum.ERROR)
            var recyclerBookrackItemViewModel =
                RecyclerBookrackItemViewModel(this@BookrackViewModel, it)
            observableList.add(recyclerBookrackItemViewModel)
        })
     }
}
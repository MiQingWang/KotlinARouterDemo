package com.jinggao.android.model.home.viewmodel

import androidx.databinding.ObservableField
import com.jinggao.android.common.bean.Book
import com.jinggao.android.common.bean.RankInfo
import me.goldze.mvvmhabit.base.ItemViewModel


class RecyclerBookrackItemViewModel(viewModel: BookrackViewModel, book: Book) : ItemViewModel<BookrackViewModel>(viewModel) {
    var itemData: ObservableField<Book> = ObservableField<Book>().apply {
        this.set(book)
    }

}
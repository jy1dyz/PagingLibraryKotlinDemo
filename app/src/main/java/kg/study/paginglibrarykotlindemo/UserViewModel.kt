package kg.study.paginglibrarykotlindemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kg.study.paginglibrarykotlindemo.model.User

class UserViewModel: ViewModel() {

    var userPagedList: LiveData<PagedList<User>>
    private var liveDataSource: LiveData<UserDataSource>

    init {
        val itemDataSourceFactory = UserDataSourceFactory()
        liveDataSource = itemDataSourceFactory.userLiveDataSource

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UserDataSource.PAGE_SIZE)
            .build()

        userPagedList = LivePagedListBuilder(itemDataSourceFactory, config)
            .build()
    }
}
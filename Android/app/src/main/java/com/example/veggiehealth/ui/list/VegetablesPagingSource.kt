package com.example.veggiehealth.ui.list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.veggiehealth.data.remote.response.VegetablesItem
import com.example.veggiehealth.data.remote.retrofit.ApiService

class VegetablesPagingSource(private val apiService: ApiService) : PagingSource<Int, VegetablesItem>() {
    override fun getRefreshKey(state: PagingState<Int, VegetablesItem>): Int? {
        return  state.anchorPosition?.let { anchorPosition->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VegetablesItem> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val responeData = apiService.getVegetable(position, params.loadSize)
            LoadResult.Page(
                data = responeData.vegetables,
                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (responeData.vegetables.isNullOrEmpty()) null else position + 1
            )
        }catch (e : Exception) {
            return LoadResult.Error(e)
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }
}
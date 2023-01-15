package com.teamdagger.expandableepoxylist

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import com.teamdagger.expandableepoxylist.entity.Coffee
import com.teamdagger.expandableepoxylist.entity.Header
import com.teamdagger.expandableepoxylist.epoxy_model.coffeeView
import com.teamdagger.expandableepoxylist.epoxy_model.headerView
import java.util.UUID

class ListController: EpoxyController() {

    private val listDataIndonesian = mutableListOf<Coffee>()
    private val listDataAmerican = mutableListOf<Coffee>()
    private var headerIndonesia = Header(title = "Indonesian Coffee", isExpanded = true)
    private var headerAmerican = Header(title = "American Coffee", isExpanded = false)

    fun setNewIndonesianData(newList: List<Coffee>) {
        listDataIndonesian.clear()
        listDataIndonesian.addAll(newList)
        requestModelBuild()
    }

    fun setNewAmericanData(newList: List<Coffee>) {
        listDataAmerican.clear()
        listDataAmerican.addAll(newList)
        requestModelBuild()
    }

    override fun buildModels() {
        headerView {
            id("indonesian")
            item(this@ListController.headerIndonesia)
            onExpandClicked {
                val isExpanded = this@ListController.headerIndonesia.isExpanded
                this@ListController.headerIndonesia = this@ListController.headerIndonesia.copy(isExpanded = !isExpanded)
                this@ListController.requestModelBuild()
            }
        }
        if (headerIndonesia.isExpanded) {
            listDataIndonesian.forEach {
                addChildItem(it)
            }
        }

        headerView {
            id("american")
            item(this@ListController.headerAmerican)
            onExpandClicked {
                val isExpanded = this@ListController.headerAmerican.isExpanded
                this@ListController.headerAmerican = this@ListController.headerAmerican.copy(isExpanded = !isExpanded)
                this@ListController.requestModelBuild()
            }
        }
        if (headerAmerican.isExpanded) {
            listDataAmerican.forEach {
                addChildItem(it)
            }
        }
    }

    private fun addChildItem(coffee: Coffee) {
        coffeeView {
            id(coffee.id)
            item(coffee)
        }
    }

}
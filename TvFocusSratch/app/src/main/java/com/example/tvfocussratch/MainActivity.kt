package com.example.tvfocussratch

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var gridAdapter: GridAdapter
    private lateinit var dataList: MutableList<Pair<String, Int>>
    private var focusedIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        dataList = mutableListOf(
            "Item 1" to 0, "Item 2" to 1, "Item 3" to 2, "Item 4" to 3,
            "Item 5" to 4, "Item 6" to 5, "Item 7" to 6, "Item 8" to 7,
            "Item 9" to 8, "Item 10" to 9, "Item 11" to 10, "Item 12" to 11,
            "Item 13" to 12, "Item 14" to 13, "Item 15" to 14,
        )
        gridAdapter = GridAdapter(this, dataList)

        val layoutManager = GridLayoutManager(this, 4) // 4 columns
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = gridAdapter

        recyclerView.requestFocus()
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event != null && event.action == KeyEvent.ACTION_DOWN) {
            val layoutManager = recyclerView.layoutManager as GridLayoutManager

            when (event.keyCode) {
                KeyEvent.KEYCODE_DPAD_UP -> {
                    moveFocus(-4, layoutManager) // Move up by 4 positions
                    return true
                }
                KeyEvent.KEYCODE_DPAD_DOWN -> {
                    moveFocus(4, layoutManager) // Move down by 4 positions
                    return true
                }
                KeyEvent.KEYCODE_DPAD_LEFT -> {
                    moveFocus(-1, layoutManager) // Move left by 1 position
                    return true
                }
                KeyEvent.KEYCODE_DPAD_RIGHT -> {
                    moveFocus(1, layoutManager) // Move right by 1 position
                    return true
                }
            }
        }
        return super.dispatchKeyEvent(event)
    }

    private fun moveFocus(offset: Int, layoutManager: GridLayoutManager) {
        var newFocusedIndex = focusedIndex + offset
        recyclerView.scrollToPosition(newFocusedIndex)
        if(newFocusedIndex>=dataList.size){
            newFocusedIndex=dataList.size-1
        }

        if (newFocusedIndex in 0 until dataList.size) {
            focusedIndex = newFocusedIndex
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(focusedIndex)
            viewHolder?.itemView?.requestFocus()
        }
    }
}

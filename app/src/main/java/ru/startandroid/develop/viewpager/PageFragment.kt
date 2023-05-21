package ru.startandroid.develop.viewpager

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.Random

class PageFragment : Fragment() {

    private var pageNumber: Int? = null
    private var backColor: Int? = null

    companion object {
        const val TAG = "myLogs"
        const val ARGUMENT_PAGE_NUMBER = "arg_page_number"
        const val SAVE_PAGE_NUMBER = "save_page_number"

        fun newInstance(page: Int): PageFragment {
            val pageFragment = PageFragment()
            val arguments = Bundle()
            arguments.putInt(ARGUMENT_PAGE_NUMBER, page)
            pageFragment.arguments = arguments
            return pageFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageNumber = arguments?.getInt(ARGUMENT_PAGE_NUMBER)
        Log.d(TAG, "onCreate: $pageNumber")

        val rnd = Random()
        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

        var savedPageNumber: Int = -1
        if (savedInstanceState != null) {
            savedPageNumber = savedInstanceState.getInt(SAVE_PAGE_NUMBER)
        }

        Log.d(TAG, "savedPageNumber = $savedPageNumber")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment, null)

        val tvPage: TextView = view.findViewById<View>(R.id.tvPage) as TextView
        tvPage.text = "Page $pageNumber"
        tvPage.setBackgroundColor(backColor!!)
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SAVE_PAGE_NUMBER, pageNumber!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: $pageNumber")
    }
}
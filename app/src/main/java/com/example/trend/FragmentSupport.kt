package com.example.trend

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.fragment.app.Fragment

class FragmentSupport : Fragment(R.layout.support), View.OnClickListener {
    /*override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_support, container, false)
        view.first.setOnClickListener {
            Log.d("console", "Button pressed")
        }
        return inflater.inflate(R.layout.fragment_support, container, false)
    }*/

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.first -> {
                val intent1 = Intent(Intent.ACTION_VIEW, Uri.parse("https://ols.sbiz.or.kr/"))
                startActivity(intent1)
            }

            else -> {
                val intent2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35076&pNm=BOA0101&eventMode="))
                startActivity(intent2)
            }
        }
    }
    /*
    companion object {
        fun newInstance(): ExampleFragment {
            return ExampleFragment()
        }
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button2 -> {
                toast("alpjasjdkasndknaskdnkasndkasndkjnaskjdnaskjdnkasjndkas")
            }
            else -> {
            }
        }
    }*/
}
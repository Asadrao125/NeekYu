package com.technado.neekyu.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.technado.neekyu.R
import com.technado.neekyu.base.BaseFragment
import com.technado.neekyu.databinding.CardDetailsFragmentBinding
import com.technado.neekyu.helper.CustomTextWatcher
import com.technado.neekyu.helper.Titlebar
import java.util.regex.Matcher
import java.util.regex.Pattern

class CardDetailsFragment : BaseFragment() {
    var binding: CardDetailsFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_card_details, container, false)

        getActivityContext?.lockMenu()

        binding?.edtCardNumber?.addTextChangedListener(CustomTextWatcher(
            onChanged = { text, start, before, count ->
                if (count > 0) {

                    binding?.tvCardNo?.text = text

                    val p: Pattern = Pattern.compile("(\\d{4})$")
                    val m: Matcher = p.matcher(text)
                    if (m.find()) {
                        var lastFour = m.group(m.groupCount())
                        binding?.tvCardNumber?.text = lastFour
                    }
                }
            }
        ))


        return binding?.root
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setBackTitle(getActivityContext!!, "Card Details")
    }
}
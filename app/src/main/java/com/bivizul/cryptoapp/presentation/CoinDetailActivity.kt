package com.bivizul.cryptoapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bivizul.cryptoapp.R
import com.bivizul.cryptoapp.databinding.ActivityCoinDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_coin_detail.*

class CoinDetailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCoinDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL) ?: EMPTY_SYMBOL
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, CoinDetailFragment.newInstance(fromSymbol))
                .commit()
        }
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"
        private const val EMPTY_SYMBOL = ""

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}
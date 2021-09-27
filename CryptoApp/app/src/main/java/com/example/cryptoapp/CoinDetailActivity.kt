package com.example.cryptoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_coin_detail.*

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)

        if (!intent.hasExtra(SYMBOL_EXTRA)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(SYMBOL_EXTRA)
        viewModel = ViewModelProvider
            .AndroidViewModelFactory(application)
            .create(CoinViewModel::class.java)

        viewModel.getDetailInfo(fromSymbol!!).observe(this) {
            priceTextView.text = it.price
            symbolsTextView.text = String.format(
                getString(R.string.symbols_template),
                it.fromSymbol,
                it.toSymbol
            )
            Picasso.get().load(it.getFullImageUrl()).into(coinLogoImageview)
        }
    }

    companion object {
        private const val SYMBOL_EXTRA = "fsym"

        fun newIntent(context: Context, fromSymbol: String) : Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(SYMBOL_EXTRA, fromSymbol)
            return intent
        }
    }
}
package com.market.goldmeter

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_previous_day_prices.*
import org.jsoup.Jsoup
import java.lang.Exception

class PreviousDayPricesActivity : AppCompatActivity() {
    @SuppressLint("Range")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_day_prices)

        supportActionBar?.hide()
        this.window.statusBarColor = Color.parseColor("#f44336")

        val commodity = intent.getStringExtra("commodity")

        Thread{
            try {
                val doc = Jsoup.connect("https://www.livechennai.com/gold_silverrate.asp").get()
                for (range in 3..12) {
                    val element = doc.select("tr:nth-of-type("+range+") > td:nth-of-type(1) > .txt-clr")
                    val text = element.text().toString()
                    when (range) {
                        3 -> d1.text = text + " :"
                        4 -> d2.text = text + " :"
                        5 -> d3.text = text + " :"
                        6 -> d4.text = text + " :"
                        7 -> d5.text = text + " :"
                        8 -> d6.text = text + " :"
                        9 -> d7.text = text + " :"
                        10 -> d8.text = text + " :"
                        11 -> d9.text = text + " :"
                        12 -> d10.text = text + " :"
                    }
                }
            } catch (e: Exception) {

            }
        }.start()

        val gold24Thread = Thread {
            try {
                val doc = Jsoup.connect("https://www.livechennai.com/gold_silverrate.asp").get()
                for (range in 3..12) {
                    val element = doc.select("tr:nth-of-type("+range+") > td:nth-of-type(2) > .txt-clr")
                    val text = element.text().toString()
                    val text8 = text.toFloat()*8
                    when (range) {
                        3 -> { p1.text = "1 Gram : ₹ " + text
                            P1.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        4 -> { p2.text = "1 Gram : ₹ " + text
                            P2.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        5 -> { p3.text = "1 Gram : ₹ " + text
                            P3.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        6 -> { p4.text = "1 Gram : ₹ " + text
                            P4.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        7 -> { p5.text = "1 Gram : ₹ " + text
                            P5.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        8 -> { p6.text = "1 Gram : ₹ " + text
                            P6.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        9 -> { p7.text = "1 Gram : ₹ " + text
                            P7.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        10 -> { p8.text = "1 Gram : ₹ " + text
                            P8.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        11 -> { p9.text = "1 Gram : ₹ " + text
                            P9.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        12 -> { p10.text = "1 Gram : ₹ " + text
                            P10.text = "8 Gram : ₹ " + text8.toString() + "0"}
                    }
                }
            } catch (e: Exception) {

            }
        }

        val silverThread = Thread {
            try {
                val doc = Jsoup.connect("https://www.livechennai.com/gold_silverrate.asp").get()
                for (range in 2..11) {
                    val element = doc.select("table:nth-of-type(2) .col-sm-8 > .table-price > tbody > tr:nth-of-type("+range+") > td:nth-of-type(2) > font")
                    val text = element.text().toString()
                    val text8 = text.toFloat()*1000
                    when (range) {
                        2 -> { p1.text = "1 Gram : ₹ " + text
                            P1.text = "1 KG : ₹ " + text8.toString() + "0"}
                        3 -> { p2.text = "1 Gram : ₹ " + text
                            P2.text = "1 KG : ₹ " + text8.toString() + "0"}
                        4 -> { p3.text = "1 Gram : ₹ " + text
                            P3.text = "1 KG : ₹ " + text8.toString() + "0"}
                        5 -> { p4.text = "1 Gram : ₹ " + text
                            P4.text = "1 KG : ₹ " + text8.toString() + "0"}
                        6 -> { p5.text = "1 Gram : ₹ " + text
                            P5.text = "1 KG : ₹ " + text8.toString() + "0"}
                        7 -> { p6.text = "1 Gram : ₹ " + text
                            P6.text = "1 KG : ₹ " + text8.toString() + "0"}
                        8 -> { p7.text = "1 Gram : ₹ " + text
                            P7.text = "1 KG : ₹ " + text8.toString() + "0"}
                        9 -> { p8.text = "1 Gram : ₹ " + text
                            P8.text = "1 KG : ₹ " + text8.toString() + "0"}
                        10 -> { p9.text = "1 Gram : ₹ " + text
                            P9.text = "1 KG : ₹ " + text8.toString() + "0"}
                        11 -> { p10.text = "1 Gram : ₹ " + text
                            P10.text = "1 KG : ₹ " + text8.toString() + "0"}
                    }
                }
            } catch (e: Exception) {

            }
        }

        val gold22Thread = Thread{
            try {
                val doc = Jsoup.connect("https://www.livechennai.com/gold_silverrate.asp").get()
                for (range in 3..12) {
                    val element = doc.select("tr:nth-of-type("+range+") > td:nth-of-type(4) > .txt-clr")
                    val text = element.text().toString()
                    val text8 = text.toFloat()*8
                    when (range) {
                        3 -> { p1.text = "1 Gram : ₹ " + text
                            P1.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        4 -> { p2.text = "1 Gram : ₹ " + text
                            P2.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        5 -> { p3.text = "1 Gram : ₹ " + text
                            P3.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        6 -> { p4.text = "1 Gram : ₹ " + text
                            P4.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        7 -> { p5.text = "1 Gram : ₹ " + text
                            P5.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        8 -> { p6.text = "1 Gram : ₹ " + text
                            P6.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        9 -> { p7.text = "1 Gram : ₹ " + text
                            P7.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        10 -> { p8.text = "1 Gram : ₹ " + text
                            P8.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        11 -> { p9.text = "1 Gram : ₹ " + text
                            P9.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        12 -> { p10.text = "1 Gram : ₹ " + text
                            P10.text = "8 Gram : ₹ " + text8.toString() + "0"}
                    }
                }
            } catch (e: Exception) {

            }
        }

        val platinumThread = Thread{
            try {
                val doc = Jsoup.connect("https://www.livechennai.com/platinum_rate_chennai.asp").get()
                for (range in 2..11) {
                    val element = doc.select("body > div.wrapper > div.veg-cointainer > div:nth-child(7) > div.col-sm-8 > div:nth-child(3) > div > table > tbody > tr:nth-child("+range+") > td:nth-child(2)")
                    val text = element.text().toString()
                    val text8 = text.toFloat()*8
                    when (range) {
                        2 -> { p1.text = "1 Gram : ₹ " + text
                            P1.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        3 -> { p2.text = "1 Gram : ₹ " + text
                            P2.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        4 -> { p3.text = "1 Gram : ₹ " + text
                            P3.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        5 -> { p4.text = "1 Gram : ₹ " + text
                            P4.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        6 -> { p5.text = "1 Gram : ₹ " + text
                            P5.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        7 -> { p6.text = "1 Gram : ₹ " + text
                            P6.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        8 -> { p7.text = "1 Gram : ₹ " + text
                            P7.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        9 -> { p8.text = "1 Gram : ₹ " + text
                            P8.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        10 -> { p9.text = "1 Gram : ₹ " + text
                            P9.text = "8 Gram : ₹ " + text8.toString() + "0"}
                        11 -> { p10.text = "1 Gram : ₹ " + text
                            P10.text = "8 Gram : ₹ " + text8.toString() + "0"}
                    }
                }
            } catch (e: Exception) {

            }
        }

        val petrolThread = Thread{}

        val dieselThread = Thread{}

        if (commodity == "gold22") {
            commodityTitle.text = "22 Carat Gold Rate for Last 10 Days"
            gold22Thread.start()
        } else if (commodity == "gold24") {
            commodityTitle.text = "24 Carat Gold Rate for Last 10 Days"
            gold24Thread.start()
        } else if (commodity == "silver") {
            commodityTitle.text = "Silver Rate for Last 10 Days"
            silverThread.start()
        } else if (commodity == "platinum") {
            commodityTitle.text = "Platinum Rate for Last 10 Days"
            platinumThread.start()
        } else if (commodity == "petrol") {
            commodityTitle.text = "Petrol Rate for Last 10 Days"
            petrolThread.start()
        } else if (commodity == "diesel") {
            commodityTitle.text = "Diesel Rate for Last 10 Days"
            dieselThread.start()
        }


    }
}
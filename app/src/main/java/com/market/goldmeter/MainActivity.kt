package com.market.goldmeter

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.Jsoup
import java.io.IOException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        var window = this.window
        window.statusBarColor = Color.parseColor("#f44336")

        val result = intent.getStringExtra("SPLASH_SCREEN_INTENT")

        if (result == "sound") {
                Snackbar.make(findViewById(R.id.tex), "Welcome Back!!", Snackbar.LENGTH_LONG).show()

                        var m = MediaPlayer.create(this, R.raw.welcome2)
                        m.setVolume(0.16F, 0.16F)
                        m.start()


        }


        val c = Calendar.getInstance().time
        val df = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
        val formattedDate: String = df.format(c)
        date.text = formattedDate

        var time = SimpleDateFormat("HH", Locale.getDefault())
        var formattedTime = time.format(c).toInt()

        if (formattedTime > 1 && formattedTime < 11) greeting.text = "Good Morning \uD83D\uDC4B\uD83D\uDE4F"
        else if (formattedTime > 11 && formattedTime < 16) greeting.text = "Good Afternoon \uD83D\uDC4B\uD83D\uDE4F"
        else greeting.text = "Good Evening \uD83D\uDC4B\uD83D\uDE4F"

        var num = LocalDate.now().dayOfWeek.toString()

        when (num) {
            "SUNDAY" -> num = "Sunday"
            "MONDAY" -> num = "Monday"
            "TUESDAY" -> num = "Tuesday"
            "WEDNESDAY" -> num = "Wednesday"
            "THURSDAY" -> num = "Thursday"
            "FRIDAY" -> num = "Friday"
            "SATURDAY" -> num = "Saturday"
        }

        day.text = num

        Thread(Runnable {
            try {
                val doc = Jsoup.connect("https://www.livechennai.com/gold_silverrate.asp").get()
                val element = doc.getElementsByAttributeValueContaining("width", "16%")

                var final1 = element[0].text().toString().toFloat()
                var final8 = final1*8

                runOnUiThread {
                    g241.text = "₹ " + final1.toString() + "0"
                    g248.text = "₹ " + final8.toString() + "0"
                }
            } catch (e : IOException) {

            }
        }).start()

        Thread(
            Runnable {
                try {
                    val doc = Jsoup.connect("https://www.livechennai.com/gold_silverrate.asp").get()
                    val element = doc.select("tr:nth-of-type(3) > td:nth-of-type(4) > .txt-clr")

                    var final1 = element[0].text().toString().toFloat()
                    var final8 = final1*8

                    runOnUiThread {
                        g221.text = "₹ " + final1.toString() + "0"
                        g228.text = "₹ " + final8.toString() + "0"
                    }
                } catch (e : IOException) {

                }
            }
        ).start()

        Thread(
            Runnable {
                try {
                    val doc = Jsoup.connect("https://www.livechennai.com/platinum_rate_chennai.asp").get()
                    val element = doc.select("tr:nth-of-type(2) > td:nth-of-type(2)")

                    var final1 = element[0].text().toString().toFloat()
                    var final8 = final1*8

                    runOnUiThread {
                        p1.text = "₹ " + final1.toString() + "0"
                        p8.text = "₹ " + final8.toString() + "0"
                    }
                } catch (e : IOException) {

                }
            }
        ).start()

        Thread(
            Runnable {
                try {
                    val doc = Jsoup.connect("https://www.livechennai.com/scrap_prices_Chennai.asp").get()
                    val element = doc.select(".content  .content > tbody > tr:nth-of-type(6) > td:nth-of-type(3) > p")

                    var final1 = element[0].text().toString().toFloat()
                    var final8 = doc.select(".content  .content > tbody > tr:nth-of-type(7) > td:nth-of-type(3) > p").text().toString()

                    runOnUiThread {
                        copper.text = "₹ " + final1.toString() + "0"
                        copperKG.text = "₹ " + final8
                    }
                } catch (e : IOException) {

                }
            }
        ).start()

        Thread(
            Runnable {
                try {
                    val doc = Jsoup.connect("https://www.livechennai.com/gold_silverrate.asp").get()
                    val element = doc.select("table:nth-of-type(2) .col-sm-8 > .table-price > tbody > tr:nth-of-type(2) > td:nth-of-type(2) > font")

                    var final1 = element[0].text().toString().toFloat()
                    var final8 = final1*1000

                    runOnUiThread {
                        s1.text = "₹ " + final1.toString() + "0"
                        s8.text = "₹ " + final8.toString() + "0"
                    }
                } catch (e : IOException) {

                }
            }
        ).start()

        Thread(
            Runnable {
                try {
                    val doc = Jsoup.connect("https://www.livechennai.com/petrol_price.asp").get()
                    val element = doc.select(".column-col-12.pad-l-01.pad-r-01.pad-t-01.row > div:nth-of-type(5) > table:nth-of-type(2) > tbody > tr:nth-of-type(4) > .content > span")

                    var final1 = element[0].text().toString().toDouble()
                    var final8 = final1*3

                    runOnUiThread {
                        petrol.text = "₹ " + final1.toString()
                        petrolG.text = "₹ " + final8.toString()
                    }
                } catch (e : IOException) {

                }
            }
        ).start()

        Thread(
            Runnable {
                try {
                    val doc = Jsoup.connect("https://www.livechennai.com/petrol_price.asp").get()
                    val element = doc.select("table:nth-of-type(3) > tbody > tr:nth-of-type(4) > .content > span")

                    var final1 = element[0].text().toString().toFloat()
                    var final8 = final1*3

                    runOnUiThread {
                        diesel.text = "₹ " + final1.toString()
                        dieselG.text = "₹ " + final8.toString()
                    }
                } catch (e : IOException) {

                }
            }
        ).start()



        val intent = Intent(this, PreviousDayPricesActivity::class.java)
        var mp = MediaPlayer.create(this, R.raw.click)
        mp.setVolume(0.04F, 0.04F)

        gold22Card.setOnClickListener {
            intent.putExtra("commodity", "gold22")
            startActivity(Intent(intent))

            mp.start()
        }

        gold24Card.setOnClickListener {
            intent.putExtra("commodity", "gold24")
            startActivity(Intent(intent))

            mp.start()
        }

        silverCard.setOnClickListener {
            intent.putExtra("commodity", "silver")
            startActivity(Intent(intent))

            mp.start()
        }

        platinumCard.setOnClickListener {
            Snackbar.make(findViewById(R.id.tex), "Platinum Price History is Unavailable at the moment", Snackbar.LENGTH_LONG).show()

            //mp.start()
            //intent.putExtra("commodity", "platinum")
            //startActivity(Intent(intent))
        }

        copperCard.setOnClickListener {
            Snackbar.make(findViewById(R.id.tex), "Copper Price History is Unavailable at the moment", Snackbar.LENGTH_LONG).show()

            //mp.start()
            //intent.putExtra("commodity", "petrol")
            //startActivity(Intent(intent))
        }

        petrolCard.setOnClickListener {
            Snackbar.make(findViewById(R.id.tex), "Fuel Price History is Unavailable at the moment", Snackbar.LENGTH_LONG).show()

            //mp.start()
            //intent.putExtra("commodity", "petrol")
            //startActivity(Intent(intent))
        }

        dieselCard.setOnClickListener {
            Snackbar.make(findViewById(R.id.tex), "Fuel Price History is Unavailable at the moment", Snackbar.LENGTH_LONG).show()

            //mp.start()
            //intent.putExtra("commodity", "diesel")
            //startActivity(Intent(intent))
        }

    }

}
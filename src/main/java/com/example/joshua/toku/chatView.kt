
package com.example.joshua.toku

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.github.bassaer.chatmessageview.model.ChatUser
import com.github.bassaer.chatmessageview.model.Message
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager
import kotlinx.android.synthetic.main.activity_chat_view.*
import java.util.*
import android.widget.TextView
import com.example.joshua.toku.R.layout.activity_chat_view
import com.google.firebase.auth.FirebaseAuth

class chatView : AppCompatActivity() {
//    companion object {
//        private const val ACCESS_TOKEN = "09fff17870294c3a8038390f8113ad67"
//    }
//    internal lateinit var firebaseAuth: FirebaseAuth
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(activity_chat_view)
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)
//
//        FuelManager.instance.baseHeaders = mapOf(
//                "Authorization" to "Bearer $ACCESS_TOKEN"
//        )
//
//        FuelManager.instance.basePath = "https://api.dialogflow.com/v1/"
//
//        FuelManager.instance.baseParams = listOf(
//                "v" to "20170712",                  // latest protocol
//                "sessionId" to UUID.randomUUID(),   // random Id
//                "lang" to "en"                      // English language
//        )
//
//        val human = ChatUser(
//                1,
//                "Joshua",
//                BitmapFactory.decodeResource(resources,
//                        R.drawable.ic_account_circle)
//        )
//
//        val agent = ChatUser(
//                2,
//                "Api",
//                BitmapFactory.decodeResource(resources,
//                        R.drawable.ic_account_circle)
//        )
//
//        activity_chat_view.setOnClickSendButtonListener(View.OnClickListener {
//
//            activity_chat_view.send(Message.Builder()
//                    .setUser(human)
//                    .setRight(true)
//                    .setText(activity_chat_view.inputText)
//                    .build()
//            )
//            Fuel.get("/query",
//                    listOf("query" to activity_chat_view.inputText))
//                    .responseJson { _, _, result ->
//                        val reply = result.get().obj()
//                                .getJSONObject("result")
//                                .getJSONObject("fulfillment")
//                                .getString("speech")
//
//                        activity_chat_view.send(Message.Builder()
//                                .setRight(false)
//                                .setUser(agent)
//                                .setText(reply)
//                                .build()
//                        )
//
//                        val intent:String? = result.get().obj()
//                                .getJSONObject("result")
//                                .optJSONObject("metadata")
//                                .optString("intentName")
//
//                        if(intent!! == "WEIGHT") {
//                            val unitWeightName = result.get().obj()
//                                    .getJSONObject("result")
//                                    .getJSONObject("parameters")
//                                    .getString("unit-weight-name")
//
//                            val unitWeight = result.get().obj()
//                                    .getJSONObject("result")
//                                    .getJSONObject("parameters")
//                                    .getJSONObject("unit-weight")
//                                    .getDouble("amount")
//
//                            val result = if(unitWeightName == "lb") {
//                                unitWeight * 2.20462
//                            } else {
//                                unitWeight / 2.20462
//                            }
//
//                            activity_chat_view.send(Message.Builder()
//                                    .setRight(false)
//                                    .setUser(agent)
//                                    .setText("That's ${"%.2f".format(result)} $unitWeightName")
//                                    .build()
//                            )
//                        }
//                    }
//        })
//    }
//
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.chat_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.settings -> {
//                val intent = Intent(this, settings::class.java)
//                startActivity(intent)
//            }
//            R.id.profile -> {
//                val profile = Intent(this, userView::class.java)
//                startActivity(profile)
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
}

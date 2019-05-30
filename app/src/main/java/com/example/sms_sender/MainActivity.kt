package com.example.sms_sender

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.widget.LinearLayoutManager
import android.telephony.SmsManager
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.desing_number_name.*

class MainActivity : AppCompatActivity() {

    private val requestSendSms: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datos = getLists()

        recycler_datos_sms.layoutManager = LinearLayoutManager(this)
        recycler_datos_sms.hasFixedSize()
        recycler_datos_sms.adapter = AdaptadorDatosSMS(datos)


        btn_send_msj.setOnClickListener {

            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), requestSendSms)
            }else {
                sendSms()
            }
        }
    }

    fun getLists(): ArrayList<DatosSMS> {
        var lists = ArrayList<DatosSMS>()
        lists.add(DatosSMS("Johnny","3122845783","Lo esperamos en las urnas"))
        lists.add(DatosSMS("Faruth","3122844511","Lo esperamos en las urnas"))
        lists.add(DatosSMS("Fidelina","312284500","Lo esperamos en las urnas"))
        return lists
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == requestSendSms) sendSms()
    }

    private fun sendSms() {
        val number = txtview_number_send.text.toString()
        val name = txtview_name_send.text.toString()
        val mensaje = editxt_msj_to_send.toString()

        SmsManager.getDefault().sendTextMessage(number,name,mensaje,null,null)
        Toast.makeText(applicationContext,"Mensaje enviado",Toast.LENGTH_SHORT).show()
    }


}

package com.example.sms_sender

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.telephony.SmsManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val requestSendSms: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_send_msj.setOnClickListener {

            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), requestSendSms)
            }else {
                sendSms()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == requestSendSms) sendSms()
    }

    private fun sendSms() {
        val number = txtview_number_send.text.toString()
        val name = txtview_name_send
        val mensaje = editxt_msj_to_send.text.toString()

        SmsManager.getDefault().sendTextMessage(number,null,mensaje,null,null)
        Toast.makeText(applicationContext,"Mensaje enviado",Toast.LENGTH_SHORT).show()
    }


}

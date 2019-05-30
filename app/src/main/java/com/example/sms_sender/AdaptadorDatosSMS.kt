package com.example.sms_sender

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.desing_number_name.view.*

class AdaptadorDatosSMS(val datosListSMS: ArrayList<DatosSMS>):RecyclerView.Adapter<AdaptadorDatosSMS.ViewHolderDatosSMS>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolderDatosSMS {
       val v = LayoutInflater.from(p0.context).inflate(R.layout.desing_number_name,p0,false)
        return ViewHolderDatosSMS(v)
    }

    override fun onBindViewHolder(p0: ViewHolderDatosSMS, p1: Int) {
       p0.bindItem(datosListSMS[p1])
    }

    override fun getItemCount(): Int {
       return datosListSMS.size
    }
    class ViewHolderDatosSMS(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindItem(datosSMS: DatosSMS){
            itemView.txtview_number_send.text = datosSMS.numero
            itemView.txtview_name_send.text = datosSMS.nombre
            itemView.editxt_msj_to_send.text = datosSMS.mensaje as Editable
        }
    }

}



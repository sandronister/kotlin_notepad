package br.com.sandroni.notepad.view.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.sandroni.notepad.R
import br.com.sandroni.notepad.model.Note
import kotlinx.android.synthetic.main.item_note.view.*

class MainListAdapter(
    val context : Context,
    val notes : List<Note>
):
    RecyclerView.Adapter<MainListAdapter.NotaViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NotaViewHolder {

        val itemView = LayoutInflater.from(context)
                            .inflate(R.layout.item_note,p0,false)

        return NotaViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(p0: NotaViewHolder, position: Int) {
        val note = notes[position]
        p0.bindView(note)
    }

    class NotaViewHolder(itemView:View)
        :RecyclerView.ViewHolder(itemView){

        fun bindView(note:Note) = with(itemView){
            tvTitle.text = note.title
            tvDescription.text = note.description
        }
    }

}
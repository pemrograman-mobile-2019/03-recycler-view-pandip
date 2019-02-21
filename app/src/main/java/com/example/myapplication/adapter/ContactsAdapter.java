package com.example.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.models.Contact;

import org.w3c.dom.Text;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    //atribut
    private List<Contact> mContacts;

    //contstructor
    public ContactsAdapter(List<Contact> mContacts) {
        this.mContacts = mContacts;
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //menghubungkan contact.xml
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_contact, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder viewHolder, int i) {
        //menghubungkan / mensetting nilai masing2 item
        Contact itemContact  = mContacts.get(i);
        TextView textView    = viewHolder.nameTextView;
        textView.setText(itemContact.getmName());

        Button buttonContact = viewHolder.messageButton;
        buttonContact.setText(itemContact.isnOnline()? "Message" : "Offline");
        buttonContact.setEnabled(itemContact.isnOnline());

    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private Button messageButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView  = itemView.findViewById(R.id.contact_name);
            messageButton = itemView.findViewById(R.id.message_button);
        }
    }
}

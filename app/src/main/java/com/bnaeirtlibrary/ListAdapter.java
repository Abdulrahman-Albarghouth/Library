package com.bnaeirtlibrary;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Books> {


        public ListAdapter(Context context, ArrayList<Books> userArrayList){

            super(context,R.layout.list_item,userArrayList);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

           Books books = getItem(position);

            if (convertView == null){

                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

            }

           // ImageView imageView = convertView.findViewById(R.id.profile_pic);
            TextView bookAuthor = convertView.findViewById(R.id.personName);
            TextView bookUrl = convertView.findViewById(R.id.lastMessage);
            TextView bookDetay = convertView.findViewById(R.id.msgtime);
           TextView bookLike = convertView.findViewById(R.id.booklik);

            //imageView.setImageResource(books);
            bookAuthor.setText("auteur: " + books.book_author);
            bookUrl.setText(books.url);
            bookDetay.setText(books.book_detail);
            bookLike.setText(books.book_like);

            return convertView;
        }
    }



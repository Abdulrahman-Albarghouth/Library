package com.bnaeirtlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BookActivityPage extends AppCompatActivity {
    private TextView scnce;
    //TextView btn;
    String scientist;
    ListView listView;
    //int n=0;
    String link;
   // String booknom;
   // StorageReference storageReference;
    DatabaseReference databaseReference;
    List<Books> uploadePDF;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_page);
        listView = (ListView) findViewById(R.id.listview);


        //databaseReference = FirebaseDatabase.getInstance().getReference().child("book_detail");
       // btn = (TextView) findViewById(R.id.showbook);
        //scnce = findViewById(R.id.test);

        Intent secondintent = getIntent();
        scientist = secondintent.getStringExtra("key");
       // scnce.setText(scientist);
        databaseReference = FirebaseDatabase.getInstance().getReference(scientist);
        uploadePDF = new ArrayList<>();
       retrievPDFFile();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                likeClick();
                Books books = uploadePDF.get(position);
               // String itemValue = (String) listView.getItemAtPosition( position );

                // String value = onItemClick();
                Intent intent = new Intent(BookActivityPage.this, BooksViewer.class);
                intent.putExtra("key", books.getUrl());


/*
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @SuppressLint("IntentReset")
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Books books = uploadePDF.get(position);
                        Intent i = new Intent(BookActivityPage.this,BooksViewer.class);
                        i.putExtra("val", books.geturl());
                        startActivity(i);
*/
                startActivity(intent);
                //Intent intent = new Intent(BookActivityPage.this,KWellcomeActivity.class);
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //  intent.setType("application/pdf");
                //intent.setData(Uri.parse(books.getBook_detail()));
                // startActivity(intent);
                // webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/mylibrary-9f78b.appspot.com/o/Techology.pdf?alt=media&token=69081060-d798-4737-b832-aed2c37959f8");

            }
        });

    }






//-----------------------Data Retrieving -----------------------------

    public void retrievPDFFile(){
       // n++;
       // String s = "Sciences";

        // databaseReference = FirebaseDatabase.getInstance().getReference().child("Sciences1");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {

                    Books books = ds.getValue(com.bnaeirtlibrary.Books.class);
                    uploadePDF.add(books);

                }

               String[] uploadsAuthor = new String[uploadePDF.size()];
                // String[] uploadsCathegory = new String[uploadePDF.size()];
                 String[] uploadsUrl = new String[uploadePDF.size()];
                String[] uploadsDetay = new String[uploadePDF.size()];
                String[] uploadsLike = new String[uploadePDF.size()];

               ArrayList<Books> booksArrayList = new ArrayList<>();

               for (int i = 0; i < uploadsUrl.length; i++) {
                    //     User user = new User(name[i],lastMessage[i],lastmsgTime[i],phoneNo[i],country[i],imageId[i]);


                    uploadsAuthor[i] = uploadePDF.get(i).book_author;
                    uploadsUrl[i] = uploadePDF.get(i).url;
                    uploadsDetay[i] = uploadePDF.get(i).book_detail;
                      uploadsLike[i] = uploadePDF.get(i).book_like;
                    // uploadsCathegory[i] = uploadePDF.get(i).book_cathegory;

                   Books books = new Books();

                    books.book_author = uploadsAuthor[i];
                    books.url = uploadsUrl[i];
                    books.book_detail = uploadsDetay[i];
                   books.book_like = uploadsLike[i];
                    //books.book_cathegory = uploadsCathegory[i];



                    booksArrayList.add(books);

                }





//-------------------------Retrieve Data End-----------------------------------


                ListAdapter listAdapter = new ListAdapter(BookActivityPage.this,booksArrayList);

                listView.setAdapter(listAdapter);
               //listView.setClickable(true);
             /*  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Books books = uploadePDF.get(position);
                        String itemValue = (String) listView.getItemAtPosition( position );

                        Intent intent = new Intent(BookActivityPage.this, BooksViewer.class);
                        intent.putExtra("key", itemValue);

                        startActivity(intent);

                        Intent i = new Intent();

                        i.putExtra("",uploadsUrl[position]);
                        //  i.putExtra("",uploadsCathegory[position]);
                       // i.putExtra("",uploadsDetay[position]);
                        startActivity(i);



                    }
                });

                */






/*
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_activated_1,uploadsUrl){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view= super.getView(position, convertView, parent);
                        TextView booklink = (TextView) view
                                .findViewById( android.R.id.text1);
                        booklink.setTextColor(Color.BLACK);
                        booklink.setTextSize(15);

                        Drawable img = getContext().getResources().getDrawable(R.drawable.pdf);
                        img.setBounds(0,0,150,150);
                        booklink.setCompoundDrawables(img, null, null, null);
                        link = booklink.getText().toString();
                        return view;

                    }
                };

*/
                //listView.setAdapter(listAdapter);


            }



            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });

    }

    public void likeClick(){

        int n=0;
        n++;

        Books books = new Books();

    }




}
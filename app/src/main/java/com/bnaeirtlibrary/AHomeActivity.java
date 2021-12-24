package com.bnaeirtlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AHomeActivity extends AppCompatActivity {
    //StorageReference storageReference;
   // DatabaseReference databaseReference;
   // EditText editText;
    // TextView textview;
    //Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* textview= (TextView) findViewById(R.id.testid);
        editText= (EditText) findViewById(R.id.selectbookeditext);
        btn = (Button) findViewById(R.id.btn);
        setContentView(R.layout.activity_a_home);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("LibraryAdmin");
        btn.setEnabled(false);

        editText.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                selectPDF();
            }
        });

        */
    }
/*
    private void selectPDF() {

        Intent intent = new Intent();
        intent.setType("Application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"PDF FİLE SELECT"),12);

    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==12 && resultCode==RESULT_OK && data!=null && data.getData()!=null){

            btn.setEnabled(true);

            editText.setText(data.getDataString()
                    .substring(data.getDataString().lastIndexOf("/") + 1));

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

              // uploadPDFfileFirebase(data.getData());

           }
       });

        }

    }

    /*
    private void uploadPDFfileFirebase(Uri data) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("File is downloading...");
        progressDialog.show();
        StorageReference refence = storageReference.child("upload" + System.currentTimeMillis() + ".pdf");

        refence.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();

                        while (!uriTask.isComplete()) {
                            Uri uri = uriTask.getResult();
                            Books book = new Books(editText.getText().toString(), uri.toString());
                            databaseReference.child(databaseReference.push().getKey()).setValue(book);

                            Toast.makeText(getApplicationContext(), "File Upload", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {

            @Override
            public void onProgress(@NonNull @NotNull UploadTask.TaskSnapshot snapshot) {
                double progress = (100.0 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
                progressDialog.setMessage("File upload" + (int) progress + "%");

            }
        });

    }
    */







/*


    public void insertBook(View v){
        EditText kategori = (EditText) findViewById(R.id.cathegory);

        EditText detay = (EditText) findViewById(R.id.bookdetail);

        //TextView choError = (TextView) findViewById(R.id.k_Erreur_display);

        String b_kategori = kategori.getText().toString().trim();
        String b_detail = detay.getText().toString().trim();
        Books book = new Books(b_kategori,b_detail);
    }




    public void bookSelector(View v){
        Intent intent = new Intent();
        intent.setType("Application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"PDF FİLE SELECT"),12);

    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==12 && resultCode==RESULT_OK && data!=null && data.getData()!=null){

            test.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));


        }

    }

    public void uploadFileTofirebase(Uri data) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();
        StorageReference refence = storageReference.child("upload" + System.currentTimeMillis() + ".pdf");

        refence.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();

                        while (!uriTask.isComplete()) {
                            Uri uri = uriTask.getResult();
                            Books book = new Books(selectbook.getText().toString(), uri.toString());
                            databaseReference.child(databaseReference.push().getKey()).setValue(book);

                            Toast.makeText(getApplicationContext(), "File Upload", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {

            @Override
            public void onProgress(@NonNull @NotNull UploadTask.TaskSnapshot snapshot) {
                double progress = (100.0 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
                progressDialog.setMessage("File upload" + (int) progress + "%");

            }
        });
    }










 */

}
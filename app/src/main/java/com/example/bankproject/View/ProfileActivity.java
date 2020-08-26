package com.example.bankproject.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankproject.MainActivity;
import com.example.bankproject.Model.User;
import com.example.bankproject.Model.UserRequest;
import com.example.bankproject.R;
import com.squareup.picasso.Picasso;

import java.io.File;

public class ProfileActivity extends AppCompatActivity implements DeleteDialog.DeleteDialogListener{
    Uri image_uri;
    private Button btnDelete;
    private ImageView mImage;
    private ImageView image_prof;
    private TextView cpfProfile, pwsProfile;
    Button btnDelAcc, btnCancel;
    Dialog MyDialog;

    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);




        image_prof = findViewById(R.id.image_profile);
        btnDelete = findViewById(R.id.button_delete_account);

        mImage = findViewById(R.id.img_user_avatar);
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) ==
                            PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                    PackageManager.PERMISSION_DENIED) {
                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);
                    } else {
                        openCamera();
                    }
                } else {
                    openCamera();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }

    private void openDialog() {
//        DeleteDialog deleteDialog = new DeleteDialog();
//        deleteDialog.show(getSupportFragmentManager(), "delete dialog");
        MyDialog = new Dialog(ProfileActivity.this);
        MyDialog.setContentView(R.layout.delete_account);



        btnDelAcc = MyDialog.findViewById(R.id.button_delete_account);
        btnCancel = MyDialog.findViewById(R.id.button_back);
        btnCancel.setEnabled(true);
        btnDelAcc.setEnabled(true);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnDelAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        MyDialog.show();
    }

    @Override
    public void applyTexts(String userCpfDelete, String userPwsDelete) {
        cpfProfile.setText(userCpfDelete);
        pwsProfile.setText(userPwsDelete);
    }

    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            File file = new File(MediaStore.Images.Media.DATE_ADDED);
            image_prof.setImageURI(image_uri);
//            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
//            intent.putExtra("Profile picture", image_uri);
//            startActivity(intent);
        }
    }
}
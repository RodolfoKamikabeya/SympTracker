package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private Button CreateAccountButton;
    private EditText InputName, InputBirthday, InputPassword, InputLocation, InputGender, InputUsername;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        CreateAccountButton =(Button) findViewById(R.id.register_btn);
        InputUsername =(EditText) findViewById(R.id.register_username_login);
        InputName =(EditText) findViewById(R.id.register_username_input);
        InputPassword =(EditText) findViewById(R.id.register_password_input);
        InputBirthday =(EditText) findViewById(R.id.register_birthday_input);
        InputLocation=(EditText) findViewById(R.id.register_location_input);
        InputGender =(EditText) findViewById(R.id.register_gender_input);
        loadingBar = new ProgressDialog(this);

        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });
    }

    private void CreateAccount() {
        String username = InputUsername.getText().toString();
        String name = InputName.getText().toString();
        String birthday = InputBirthday.getText().toString();
        String password = InputPassword.getText().toString();
        String location = InputLocation.getText().toString();
        String gender = InputGender.getText().toString();

        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please write your name ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(birthday)){
            Toast.makeText(this, "Please write your phone number ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please write your password ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(location)){
            Toast.makeText(this, "Please write your location ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(gender)){
            Toast.makeText(this, "Please write your gender ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(username)){
            Toast.makeText(this, "Please write your gender ", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please wait, while we are checking the credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            ValidateCredentials(username,name, password, birthday, location, gender);

        }

    }

    private void ValidateCredentials(final String username, final String name, final String password, final String birthday, final String location, final String gender) {

        //Set the value in the Firebase database
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Users").child(username).exists()))
                {
                    HashMap<String,Object> userdataMap = new HashMap<>();
                    userdataMap.put("username",username);
                    userdataMap.put("password",password);
                    userdataMap.put("name",name);
                    userdataMap.put("birthday",birthday);
                    userdataMap.put("location",location);
                    userdataMap.put("gender",gender);

                    RootRef.child("Users").child(username).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText(RegisterActivity.this, "Your Account has been created", Toast.LENGTH_SHORT).show();
                                        loadingBar.dismiss();
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                        {
                                            Toast.makeText(RegisterActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else {
                    Toast.makeText(RegisterActivity.this, "This " + username + " already exist", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(RegisterActivity.this, "Please try again using another username", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}

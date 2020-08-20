package com.example.bankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankproject.Model.User;
import com.example.bankproject.Services.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<User> users;
    User user;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.all_users);

        users = new ArrayList<>();

//        sendRequest();
//        addUser();
        updateUser();
    }

    public void sendRequest() {
        Call<User> call = new RetrofitConfig().getUserService().findByUser("08215596975", "123456");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

//                for (User user : users) {
                    String content ="";
                    content += "_id: " + user.get_id() + "\n";
                    content += "name: " + user.getName() + "\n";
                    content += "cpf: " + user.getCpf() + "\n";
                    content += "pws: " + user.getPws() + "\n";
                    content += "telefone: " + user.getTelefone() + "\n";
                    content += "avatar: " + user.getAvatar() + "\n\n";

                    textView.append(content);
//                }
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha na solicitação", Toast.LENGTH_LONG).show();
            }
        });
    }

    public User addUser() {
        User user = new User("Novo 123", "95696587000", "654321", "", "999991111");

        Call<User> call = new RetrofitConfig().getUserService().addUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {

                    User userResponse = response.body();

                    String content ="";
                    content += "_id: " + userResponse.get_id() + "\n";
                    content += "name: " + userResponse.getName() + "\n";
                    content += "cpf: " + userResponse.getCpf() + "\n";
                    content += "pws: " + userResponse.getPws() + "\n";
                    content += "telefone: " + userResponse.getTelefone() + "\n";
                    content += "avatar: " + userResponse.getAvatar() + "\n\n";

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

        return user;
    }

    public void updateUser() {
        User user = new User("5f3dc2e38a3df50021017a41","Novo usuário123", "95696587000", "654321", "", "999991111");

        Call<User> call = new RetrofitConfig().getUserService().updateUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User userResponse = response.body();

                    String content ="";
                    content += "_id: " + userResponse.get_id() + "\n";
                    content += "name: " + userResponse.getName() + "\n";
                    content += "cpf: " + userResponse.getCpf() + "\n";
                    content += "pws: " + userResponse.getPws() + "\n";
                    content += "telefone: " + userResponse.getTelefone() + "\n";
                    content += "avatar: " + userResponse.getAvatar() + "\n\n";

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}
package com.example.bankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankproject.Model.BankAccount;
import com.example.bankproject.Model.BankAccountRequest;
import com.example.bankproject.Model.User;
import com.example.bankproject.Model.UserRequest;
import com.example.bankproject.Services.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<User> users;
    private List<BankAccount> bankAccounts;
    BankAccount bankAccount;
    BankAccountRequest bankAccountRequest;
    User user;
    UserRequest userRequest;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.all_users);

        users = new ArrayList<>();

//        sendRequest();
//        addUser(userRequest);
//        updateUser();
//        addAccount();
        getAccountsByUser();
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

    public User addUser(UserRequest userRequest) {
        userRequest = new UserRequest("Testando request", "00100100101", "","990009000","880808");

        Call<User> call = new RetrofitConfig().getUserService().addUser(userRequest);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {

                    User userResponse = response.body();

                    String content ="";
//                    content += "_id: " + userResponse.get_id() + "\n";
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
        User user = new User("5f3e8e54d76ab10021d40eb7","Testando request", "00100100101", "880808", "", "990009000");

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

    public void addAccount() {

        BankAccountRequest bankAccountRequest = new BankAccountRequest("00100100101", 89,1);

        Call<BankAccount> call = new RetrofitConfig().getBankAccountService().addAccount("00100100101", "880808", bankAccountRequest);

        call.enqueue(new Callback<BankAccount>() {
            @Override
            public void onResponse(Call<BankAccount> call, Response<BankAccount> response) {
                if (response.isSuccessful()) {
                    BankAccount bankAccountResponse = response.body();

                    String content ="";
                    content += "_id: " + bankAccountResponse.get_id() + "\n";
                    content += "Bank_brench: " + bankAccountResponse.getBank_brench() + "\n";
                    content += "code: " + bankAccountResponse.getCode() + "\n";
                    content += "balance: " + bankAccountResponse.getAccount_balance() + "\n";
                    content += "status: " + bankAccountResponse.getStatus() + "\n";
//                    content += "user: " + bankAccountResponse.getUser() + "\n\n";

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<BankAccount> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
    public void getAccountsByUser() {

        Call<List<BankAccount>> call = new RetrofitConfig().getBankAccountService().getAccountsByUser("00100100101", "880808");

        call.enqueue(new Callback<List<BankAccount>>() {
            @Override
            public void onResponse(Call<List<BankAccount>> call, Response<List<BankAccount>> response) {
                if (response.isSuccessful()) {

                  List<BankAccount> bankAccounts = response.body();

                   for(BankAccount bankAccount : bankAccounts) {

                       String content = "";
                       content += "_id: " + bankAccount.get_id() + "\n";
                       content += "Bank_brench: " + bankAccount.getBank_brench() + "\n";
                       content += "code: " + bankAccount.getCode() + "\n";
                       content += "balance: " + bankAccount.getAccount_balance() + "\n";
                       content += "status: " + bankAccount.getStatus() + "\n";
                       content += "cpf: " + bankAccount.getCpf() + "\n\n";

                       textView.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<BankAccount>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}
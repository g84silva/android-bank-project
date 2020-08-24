package com.example.bankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankproject.Model.BankAccount;
import com.example.bankproject.Model.BankAccountRequest;
import com.example.bankproject.Model.BankAccountResponse;
import com.example.bankproject.Model.User;
import com.example.bankproject.Model.UserRequest;
import com.example.bankproject.Repository.UserRepository;
import com.example.bankproject.Services.RequestResult;
import com.example.bankproject.Services.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private UserRepository uRepo = null;
    private List<User> users;
    //    UserRequest userRequest;
    User user;
    private EditText mNome, mCpf, mTelefone, mPws;
    private TextView mResult;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNome = findViewById(R.id.edt_login_name);
        mCpf = findViewById(R.id.edt_login_cpf);
        mTelefone = findViewById(R.id.edt_login_telefone);
        mPws = findViewById(R.id.edt_login_pws);
        mResult = findViewById(R.id.all_users);
        mBtn = findViewById(R.id.btn_request);

        uRepo = new UserRepository(this);

        users = new ArrayList<>();

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserRequest userRequest = new UserRequest(
                        mCpf.getText().toString(),
                        mNome.getText().toString(),
                        mPws.getText().toString(),
                        mTelefone.getText().toString());
                login(userRequest);

            }

            ;
        });
//        sendRequest();
//        addUser(userRequest);
//        updateUser();
//        addAccount();
//        getAccountsByUser();
//        getAllAccounts();
//        updateAccounts();

    }

    public void login(UserRequest userRequest) {
        RequestResult result = new RequestResult() {

            @Override
            public <T> void successResult(T clazz) {

                showUser((User) clazz);

            }

            @Override
            public void errorResult(String message) {
                Toast.makeText(MainActivity.this, "Falha na request!", Toast.LENGTH_LONG).show();
            }
        };
        if (uRepo != null) {
            uRepo.getUserProfile(userRequest, result);
            Toast.makeText(MainActivity.this, "Seja bem vindo: " + userRequest.getName(), Toast.LENGTH_LONG).show();
//            uRepo.getAllUsers("userAdmin", result);
        }
    }


    public void sendRequest() {
        Call<User> call = new RetrofitConfig().getUserService().findByUser("08215596975", "123456");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

//                for (User user : users) {
                String content = "";
                content += "_id: " + user.get_id() + "\n";
                content += "name: " + user.getName() + "\n";
                content += "cpf: " + user.getCpf() + "\n";
                content += "pws: " + user.getPws() + "\n";
                content += "telefone: " + user.getTelefone() + "\n";
                content += "avatar: " + user.getAvatar() + "\n\n";

                mResult.append(content);
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
        userRequest = new UserRequest("Testando request", "00100100101", "", "990009000", "880808");

        Call<User> call = new RetrofitConfig().getUserService().addUser(userRequest);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {

                    User userResponse = response.body();

                    String content = "";
//                    content += "_id: " + userResponse.get_id() + "\n";
                    content += "name: " + userResponse.getName() + "\n";
                    content += "cpf: " + userResponse.getCpf() + "\n";
                    content += "pws: " + userResponse.getPws() + "\n";
                    content += "telefone: " + userResponse.getTelefone() + "\n";
                    content += "avatar: " + userResponse.getAvatar() + "\n\n";

                    mResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mResult.setText(t.getMessage());
            }
        });

        return user;
    }

    public void updateUser() {
        User user = new User("5f3e8e54d76ab10021d40eb7", "Testando request", "00100100101", "880808", "", "990009000");

        Call<User> call = new RetrofitConfig().getUserService().updateUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User userResponse = response.body();

                    String content = "";
                    content += "_id: " + userResponse.get_id() + "\n";
                    content += "name: " + userResponse.getName() + "\n";
                    content += "cpf: " + userResponse.getCpf() + "\n";
                    content += "pws: " + userResponse.getPws() + "\n";
                    content += "telefone: " + userResponse.getTelefone() + "\n";
                    content += "avatar: " + userResponse.getAvatar() + "\n\n";

                    mResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mResult.setText(t.getMessage());
            }
        });
    }

    public void addAccount() {

        BankAccountRequest bankAccountRequest = new BankAccountRequest("00100100101", 89, 1);

        Call<BankAccount> call = new RetrofitConfig().getBankAccountService().addAccount("00100100101", "880808", bankAccountRequest);

        call.enqueue(new Callback<BankAccount>() {
            @Override
            public void onResponse(Call<BankAccount> call, Response<BankAccount> response) {
                if (response.isSuccessful()) {
                    BankAccount bankAccountResponse = response.body();

                    String content = "";
                    content += "_id: " + bankAccountResponse.get_id() + "\n";
                    content += "Bank_branch: " + bankAccountResponse.getBank_branch() + "\n";
                    content += "code: " + bankAccountResponse.getCode() + "\n";
                    content += "balance: " + bankAccountResponse.getAccount_balance() + "\n";
                    content += "status: " + bankAccountResponse.getStatus() + "\n";
//                    content += "user: " + bankAccountResponse.getUser() + "\n\n";

                    mResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<BankAccount> call, Throwable t) {
                mResult.setText(t.getMessage());
            }
        });
    }

    public void getAccountsByUser() {

        Call<BankAccountResponse> call = new RetrofitConfig().getBankAccountService().getAccountsByUser("00100100101", "880808");

        call.enqueue(new Callback<BankAccountResponse>() {
            @Override
            public void onResponse(Call<BankAccountResponse> call, Response<BankAccountResponse> response) {
                if (response.isSuccessful()) {

                    BankAccountResponse bankAccount = response.body();

                    String content = "";
                    content += "_id: " + bankAccount.get_id() + "\n";
                    content += "Bank_branch: " + bankAccount.getBank_branch() + "\n";
                    content += "code: " + bankAccount.getCode() + "\n";
                    content += "balance: " + bankAccount.getAccount_balance() + "\n";
                    content += "status: " + bankAccount.getStatus() + "\n";
                    content += "user: " + bankAccount.getUser() + "\n\n";

                    mResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<BankAccountResponse> call, Throwable t) {
                mResult.setText(t.getMessage());
            }
        });
    }

    public void getAllAccounts() {

        Call<List<BankAccountResponse>> call = new RetrofitConfig().getBankAccountService().getAllAccounts("adminUser", "123456");

        call.enqueue(new Callback<List<BankAccountResponse>>() {
            @Override
            public void onResponse(Call<List<BankAccountResponse>> call, Response<List<BankAccountResponse>> response) {
                if (response.isSuccessful()) {

                    List<BankAccountResponse> bankAccountResponses = response.body();
                    for (BankAccountResponse bankAccountResponse : bankAccountResponses) {
                        String content = "";
                        content += "_id: " + bankAccountResponse.get_id() + "\n";
                        content += "Bank_branch: " + bankAccountResponse.getBank_branch() + "\n";
                        content += "code: " + bankAccountResponse.getCode() + "\n";
                        content += "balance: " + bankAccountResponse.getAccount_balance() + "\n";
                        content += "status: " + bankAccountResponse.getStatus() + "\n";
                        content += "user: " + bankAccountResponse.getUser() + "\n\n";

                        mResult.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<BankAccountResponse>> call, Throwable t) {
                mResult.setText(t.getMessage());
            }
        });

    }

    public void updateAccounts() {

        Call<BankAccount> call = new RetrofitConfig().getBankAccountService().updateAccounts("00100100101", "880808", 0);

        call.enqueue(new Callback<BankAccount>() {
            @Override
            public void onResponse(Call<BankAccount> call, Response<BankAccount> response) {
                if (response.isSuccessful()) {

                    BankAccount bankAccount = response.body();

                    String content = "";

                    content += "status: " + bankAccount.getStatus() + "\n";

                    mResult.append(content);

                }

                Toast.makeText(MainActivity.this, "Conta atualizada com sucesso!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<BankAccount> call, Throwable t) {
                mResult.setText(t.getMessage());
            }
        });

    }


    private void updateList(List<User> users) {
        for (User user : users) {
            String content = "";
            content += "_id: " + user.get_id() + "\n";
            content += "name: " + user.getName() + "\n";
            content += "cpf: " + user.getCpf() + "\n";
            content += "pws: " + user.getPws() + "\n";
            content += "telefone: " + user.getTelefone() + "\n";
            content += "avatar: " + user.getAvatar() + "\n\n";

            mResult.append(content);
        }
    }

    private <T> void showUser(User clazz) {
        User user = clazz;
//
        String content = "";
        content += "_id: " + user.get_id() + "\n";
        content += "name: " + user.getName() + "\n";
        content += "cpf: " + user.getCpf() + "\n";
        content += "pws: " + user.getPws() + "\n";
        content += "telefone: " + user.getTelefone() + "\n";
        content += "avatar: " + user.getAvatar() + "\n\n";

        mResult.append(content);
    }

}
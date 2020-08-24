package com.example.bankproject.Repository;

import android.content.Context;
import android.widget.TextView;

import com.example.bankproject.DAO.AppDatabase;
import com.example.bankproject.Model.BankAccount;
import com.example.bankproject.Model.BankAccountRequest;
import com.example.bankproject.Model.BankAccountResponse;
import com.example.bankproject.Model.User;
import com.example.bankproject.Services.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BankAccountRepository {

    private AppDatabase database;

    public BankAccountRepository(Context context) {
        this(AppDatabase.getInstance(context));
    }

    private BankAccountRepository(AppDatabase instance) {
        this.database = instance;
    }

    private void insert(List<BankAccount> bankAccounts) {
        database.bankAccDAO().insertAllAccDAO(bankAccounts);
    }

    private List<BankAccount> bankAccounts;
    BankAccount bankAccount;
    TextView textView;

    public void addAccount(String cpf, String pws, BankAccountRequest bankAccountRequest) {

        Call<BankAccount> call = new RetrofitConfig().getBankAccountService().addAccount(cpf, pws, bankAccountRequest);

        call.enqueue(new Callback<BankAccount>() {
            @Override
            public void onResponse(Call<BankAccount> call, Response<BankAccount> response) {
                if (response.isSuccessful()) {
                    BankAccount bankAccountResponse = response.body();

                }
            }

            @Override
            public void onFailure(Call<BankAccount> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
    public void getAccountsByUser(String cpf, String pws) {

        Call<BankAccountResponse> call = new RetrofitConfig().getBankAccountService().getAccountsByUser(cpf, pws);

        call.enqueue(new Callback<BankAccountResponse>() {
            @Override
            public void onResponse(Call<BankAccountResponse> call, Response<BankAccountResponse> response) {
                if (response.isSuccessful()) {
                    BankAccountResponse bankAccount = response.body();

                }
            }

            @Override
            public void onFailure(Call<BankAccountResponse> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    public void getAllAccounts(String cpf, String pws) {

        Call<List<BankAccountResponse>> call = new RetrofitConfig().getBankAccountService().getAllAccounts(cpf, pws);

        call.enqueue(new Callback<List<BankAccountResponse>>() {
            @Override
            public void onResponse(Call<List<BankAccountResponse>> call, Response<List<BankAccountResponse>> response) {
                if (response.isSuccessful()) {
                    List<BankAccountResponse> bankAccountResponses = response.body();

                }
            }

            @Override
            public void onFailure(Call<List<BankAccountResponse>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }

//    public void updateAccounts(String code, String cpf, int status) {
//
//        Call call = new RetrofitConfig().getBankAccountService().updateAccounts(code, cpf, status);
//
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                if (response.isSuccessful()) {
//                    textView.setText("Code " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                textView.setText(t.getMessage());
//            }
//        });
//
//    }

}

//package com.example.bankproject.view;
//
//import android.os.Bundle;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.bankproject.R;
//import com.example.bankproject.dto.request.AccountRequest;
//import com.example.bankproject.dto.request.UserRequest;
//import com.example.bankproject.dto.response.AccountResponse;
//import com.example.bankproject.model.Account;
//import com.example.bankproject.model.User;
//import com.example.bankproject.service.RequestResult;
//import com.example.bankproject.service.RetrofitConfig;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class MainActivity extends AppCompatActivity {
//  private List<User> users;
//  private List<Account> accounts;
//  Account account;
//  AccountRequest accountRequest;
//  User user;
//  UserRequest userRequest;
//  TextView textView;
//
//  @Override
//  protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_main);
//
//    textView = findViewById(R.id.all_users);
//
//    users = new ArrayList<>();
//
//    sendRequest();
//    //        addUser(userRequest);
//    //        updateUser();
//    //        addAccount();
//    //        getAccountsByUser();
//    //        getAllAccounts();
//    //        updateAccounts();
//  }
//
//  public void sendRequest() {
//    Call<User> call = new RetrofitConfig().getUserService().findByUser("08215596975", "123456");
//
//    call.enqueue(
//        new Callback<User>() {
//          @Override
//          public void onResponse(Call<User> call, Response<User> response) {
//            textView.append(response.body().getName());
//            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
//          }
//
//          @Override
//          public void onFailure(Call<User> call, Throwable t) {
//            Toast.makeText(MainActivity.this, "Falha na solicitação", Toast.LENGTH_LONG).show();
//          }
//        });
//  }
//
//  public User addUser(UserRequest userRequest) {
//    userRequest = new UserRequest("2222", "Testando request 1", "", "990009000", "880808");
//
//    Call<User> call = new RetrofitConfig().getUserService().addUser(userRequest);
//
//    call.enqueue(
//        new Callback<User>() {
//          @Override
//          public void onResponse(Call<User> call, Response<User> response) {
//            if (response.isSuccessful()) {
//              textView.append(response.body().toString());
//            } else {
//              try {
//                textView.append(
//                    response.errorBody() != null ? response.errorBody().string() : null);
//              } catch (IOException e) {
//                e.printStackTrace();
//              }
//            }
//          }
//
//          @Override
//          public void onFailure(Call<User> call, Throwable t) {
//            textView.setText(t.getMessage());
//          }
//        });
//
//    return user;
//  }
//
//  public void updateUser() {
//    User user =
//        new User(
//            "5f3e8e54d76ab10021d40eb7",
//            "Testando request",
//            "00100100101",
//            "880808",
//            "",
//            "990009000");
//
//    Call<User> call = new RetrofitConfig().getUserService().updateUser(user);
//
//    call.enqueue(
//        new Callback<User>() {
//          @Override
//          public void onResponse(Call<User> call, Response<User> response) {
//            if (response.isSuccessful()) {
//              textView.append(response.body().toString());
//            }
//          }
//
//          @Override
//          public void onFailure(Call<User> call, Throwable t) {
//            textView.setText(t.getMessage());
//          }
//        });
//  }
//
//  public void addAccount() {
//
//    AccountRequest accountRequest = new AccountRequest("00100100101", 89, 1);
//
//    Call<Account> call =
//        new RetrofitConfig()
//            .getBankAccountService()
//            .addAccount("00100100101", "880808", accountRequest);
//
//    call.enqueue(
//        new Callback<Account>() {
//          @Override
//          public void onResponse(Call<Account> call, Response<Account> response) {
//            if (response.isSuccessful()) {
//              textView.append(response.body().toString());
//            }
//          }
//
//          @Override
//          public void onFailure(Call<Account> call, Throwable t) {
//            textView.setText(t.getMessage());
//          }
//        });
//  }
//
//  public void getAccountsByUser() {
//
//    Call<AccountResponse> call =
//        new RetrofitConfig().getBankAccountService().getAccountsByUser("00100100101", "880808");
//
//    call.enqueue(
//        new Callback<AccountResponse>() {
//          @Override
//          public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
//            if (response.isSuccessful()) {
//              textView.append(response.body().toString());
//            }
//          }
//
//          @Override
//          public void onFailure(Call<AccountResponse> call, Throwable t) {
//            textView.setText(t.getMessage());
//          }
//        });
//  }
//
//  public void getAllAccounts() {
//
//    Call<List<AccountResponse>> call =
//        new RetrofitConfig().getBankAccountService().getAllAccounts("adminUser", "123456");
//
//    call.enqueue(
//        new Callback<List<AccountResponse>>() {
//          @Override
//          public void onResponse(
//              Call<List<AccountResponse>> call, Response<List<AccountResponse>> response) {
//            if (response.isSuccessful()) {
//              for (AccountResponse accountResponse : response.body()) {
//                textView.append(accountResponse.toString());
//              }
//            }
//          }
//
//          @Override
//          public void onFailure(Call<List<AccountResponse>> call, Throwable t) {
//            textView.setText(t.getMessage());
//          }
//        });
//  }
//
////  public void updateAccounts() {
////
////    Call<Account> call =
////        new RetrofitConfig().getBankAccountService().updateAccount("00100100101", "880808", 3, new RequestResult());
////
////    call.enqueue(
////        new Callback<Account>() {
////          @Override
////          public void onResponse(Call<Account> call, Response<Account> response) {
////            if (response.isSuccessful()) {
////              textView.append(String.valueOf(response.body().getStatus()));
////            }
////
////            Toast.makeText(MainActivity.this, "Conta atualizada com sucesso!", Toast.LENGTH_LONG)
////                .show();
////          }
////
////          @Override
////          public void onFailure(Call<Account> call, Throwable t) {
////            textView.setText(t.getMessage());
////          }
////        });
////  }
//}

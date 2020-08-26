//package com.example.bankproject.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.bankproject.R;
//import com.example.bankproject.model.Transaction;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TransactionAdapter
//    extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
//
//  private Context context;
//  private List<Transaction> bankTransactions = new ArrayList<>();
//  private LayoutInflater mInflater;
//
//  public TransactionAdapter(Context context, List<Transaction> bankTransactions) {
//    this.context = context;
//    this.bankTransactions = bankTransactions;
//    mInflater = LayoutInflater.from(context);
//  }
//
//  public void setBankTransactions(List<Transaction> bankTransactions) {
//    this.bankTransactions = bankTransactions;
//  }
//
//  @NonNull
//  @Override
//  public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//    View view = mInflater.inflate(R.layout.item_transaction, parent, false);
//
//    return new TransactionViewHolder(view);
//  }
//
//  @Override
//  public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
//    Transaction bankTransaction = bankTransactions.get(position);
//
//    String conta = bankTransaction.getBank_account().getCode();
//    int transaction = bankTransaction.getSource_transaction();
//    int amount = bankTransaction.getAmount();
//
//    holder.mAccount.setText(conta);
//    holder.mTransaction.setText(transaction);
//    holder.mAmount.setText(amount);
//  }
//
//  @Override
//  public int getItemCount() {
//    return bankTransactions.size();
//  }
//
//  public class TransactionViewHolder extends RecyclerView.ViewHolder {
//
//    public TextView mAccount, mTransaction, mAmount;
//
//    public CardView mCardView;
//
//    public TransactionViewHolder(@NonNull View itemView) {
//      super(itemView);
//
//      mAccount = itemView.findViewById(R.id.txt_conta_bt);
//      mTransaction = itemView.findViewById(R.id.txt_transacion_bt);
//      mAmount = itemView.findViewById(R.id.txt_amount_bt);
//
//      mCardView = itemView.findViewById(R.id.componente_pai);
//    }
//  }
//}

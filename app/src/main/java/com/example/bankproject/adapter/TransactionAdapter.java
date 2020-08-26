package com.example.bankproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankproject.R;
import com.example.bankproject.dto.response.AccountExtractResponse;
import com.example.bankproject.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter
    extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

  private Context context;
  private List<AccountExtractResponse> bankTransactions;
  private LayoutInflater mInflater;

  public TransactionAdapter(Context context, List<AccountExtractResponse> bankTransactions) {
    this.context = context;
    this.bankTransactions = bankTransactions;
    mInflater = LayoutInflater.from(context);
  }

  public void setBankTransactions(List<AccountExtractResponse> bankTransactions) {
    this.bankTransactions = bankTransactions;
  }

  @NonNull
  @Override
  public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View view = mInflater.inflate(R.layout.item_transaction, parent, false);

    return new TransactionViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
    AccountExtractResponse bankTransaction = bankTransactions.get(position);

    String data = bankTransaction.getCreatedAt().substring(0,10);
    int transaction = bankTransaction.getSource_transaction();
    String description = "";
    switch (transaction) {
      case 0:
        description = "Pagamento";
        break;
      case 1:
        description = "Transferência";
        break;
      case 2:
        description = "Depósito";
        break;
    }
    double amount = bankTransaction.getAmount();

    holder.mData.setText(data);
    holder.mTransaction.setText(description);
    holder.mAmount.setText(String.format("%.2f", amount));

  }

  @Override
  public int getItemCount() {
    return bankTransactions.size();
  }

  public class TransactionViewHolder extends RecyclerView.ViewHolder {

    public TextView mData, mTransaction, mAmount;

    public CardView mCardView;

    public TransactionViewHolder(@NonNull View itemView) {
      super(itemView);

      mData = itemView.findViewById(R.id.txt_data_bt);
      mTransaction = itemView.findViewById(R.id.txt_transacion_bt);
      mAmount = itemView.findViewById(R.id.txt_amount_bt);

      mCardView = itemView.findViewById(R.id.componente_pai);
    }
  }
}

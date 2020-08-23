package com.example.bankproject.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankproject.Model.BankAccount;
import com.example.bankproject.Model.BankTransaction;
import com.example.bankproject.R;

import java.util.ArrayList;
import java.util.List;

public class BTransactionAdapter extends RecyclerView.Adapter<BTransactionAdapter.BTransactionViewHolder> {

    private Context context;
    private List<BankTransaction> bankTransactions = new ArrayList<>();
    private LayoutInflater mInflater;

    public BTransactionAdapter(Context context, List<BankTransaction> bankTransactions) {
        this.context = context;
        this.bankTransactions = bankTransactions;
        mInflater = LayoutInflater.from(context);
    }

    public void setBankTransactions(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    @NonNull
    @Override
    public BTransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_transaction, parent, false);

        return new BTransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BTransactionViewHolder holder, int position) {
        BankTransaction bankTransaction = bankTransactions.get(position);

        String conta = bankTransaction.getBank_account().getCode();
        int transaction = bankTransaction.getSource_transaction();
        int amount = bankTransaction.getAmount();

        holder.mAccount.setText(conta);
        holder.mTransaction.setText(transaction);
        holder.mAmount.setText(amount);
    }


    @Override
    public int getItemCount() {
        return bankTransactions.size();
    }


    public class BTransactionViewHolder extends RecyclerView.ViewHolder {

        public TextView mAccount, mTransaction, mAmount;

        public CardView mCardView;

        public BTransactionViewHolder(@NonNull View itemView) {
            super(itemView);

            mAccount = itemView.findViewById(R.id.txt_conta_bt);
            mTransaction = itemView.findViewById(R.id.txt_transacion_bt);
            mAmount = itemView.findViewById(R.id.txt_amount_bt);

            mCardView = itemView.findViewById(R.id.componente_pai);

        }

    }

}

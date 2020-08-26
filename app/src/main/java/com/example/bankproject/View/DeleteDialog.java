package com.example.bankproject.View;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.bankproject.R;

public class DeleteDialog extends AppCompatDialogFragment {
    TextView titleDelete, confirmAcc, cpfDelAcc, passDelAcc;

    private DeleteDialogListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.delete_account, null);



//        builder.setView(view)
//                .setNegativeButton("voltar", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                })
//                .setPositiveButton("cancelar \nconta", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String userCpfDelete = cpfDelAcc.getText().toString();
//                        String userPwsDelete = passDelAcc.getText().toString();
//                        listener.applyTexts(userCpfDelete, userPwsDelete);
//                    }
//                });

        titleDelete = view.findViewById(R.id.confirm_data);
        confirmAcc = view.findViewById(R.id.confirm_account);
        cpfDelAcc = view.findViewById(R.id.cpf_page_delete_account);
        passDelAcc = view.findViewById(R.id.password_page_delete_account);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (DeleteDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement DeleteDialogListener");
        }
    }

    public interface DeleteDialogListener {
        void applyTexts(String userCpfDelete, String userPwsDelete);
    }
}

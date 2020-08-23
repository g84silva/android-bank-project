package com.example.bankproject.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankproject.Model.User;
import com.example.bankproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder> {

    private Context context;
    private List<User> users = new ArrayList<>();
    private LayoutInflater mInflater;

    public UserAdapter(Context context, List<User> user) {
        this.context = context;
        this.users = users;
        mInflater = LayoutInflater.from(context);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_user, parent, false);

        return new UserAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterViewHolder holder, int position) {

        User user = users.get(position);

        String avatar = user.getAvatar();
        String nome = user.getName();
        String cpf = user.getCpf();

        Picasso.get().load(avatar).into(holder.mAvatar);
        holder.mName.setText(nome);
        holder.mCpf.setText(cpf);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView mAvatar;
        private TextView mName, mCpf;

        private CardView mCardView;

        public UserAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            mAvatar = itemView.findViewById(R.id.avatar_user);
            mName = itemView.findViewById(R.id.txt_name_user);
            mCpf = itemView.findViewById(R.id.txt_cpf_user);

            mCardView = itemView.findViewById(R.id.componente_pai_user);
        }
    }
}

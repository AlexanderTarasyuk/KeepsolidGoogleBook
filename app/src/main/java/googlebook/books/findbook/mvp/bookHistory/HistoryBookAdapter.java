package googlebook.books.findbook.mvp.bookHistory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import googlebook.books.findbook.R;
import googlebook.books.findbook.mvp.chosenBookActivity.ChosenBookActivity;
import googlebook.books.findbook.network.bookModels.Items;

public class HistoryBookAdapter extends RecyclerView.Adapter<HistoryBookAdapter.ViewHolder> {

    public HistoryBookAdapter(List<Items> books) {
        this.books = books;
    }

    private List<Items> books = new ArrayList<>();

    public void updateBooks(List<Items> bookList) {
        books.clear();
        books.addAll(bookList);
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public HistoryBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryBookAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_anserw, parent, false)
        );

    }

    @Override
    public void onBindViewHolder(@NonNull HistoryBookAdapter.ViewHolder holder, int position) {
        holder.setup(books.get(position));
    }


    @Override
    public int getItemCount() {
        return books.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_book_image)
        ImageView bookImage;

        @BindView(R.id.item_anserw_description)
        TextView bookDescription;

        @BindView(R.id.item_anserw_name)
        TextView bookName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        void setup(Items item) {

            bookDescription.setText(item.getVolumeInfo().getDescription());
            itemView.setOnClickListener(view -> {

                        Bundle selectedBookData = new Bundle();
                        Intent intent = new Intent(itemView.getContext(), ChosenBookActivity.class);
                        intent.putExtras(selectedBookData);

                        itemView.getContext().startActivity(intent);

                    }
            );


        }
    }



}

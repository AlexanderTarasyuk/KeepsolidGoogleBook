package googlebook.books.findbook.mvp.findActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import googlebook.books.findbook.R;
import googlebook.books.findbook.mvp.chosenBookActivity.ChosenBookActivity;
import googlebook.books.findbook.room.watchedBook.WatchedBook;
import googlebook.books.findbook.network.bookModels.Items;

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.ViewHolder> {

    private FindActivityContract.BookListener bookListener;
    private List<Items> books = new ArrayList<>();

    public FindAdapter(FindActivityContract.BookListener bookListener) {
        this.bookListener = bookListener;
    }

    public void updateBooks(List<Items> bookList) {
        books.clear();
        books.addAll(bookList);
        notifyDataSetChanged();


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_anserw, parent, false)
        );

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setup(books.get(position), bookListener);
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

        void setBookNameText(Items item) {
            if (item.getVolumeInfo().authors != null) {
                String partOfText = "\nAuthor(s): ";
                String textForName = item.getVolumeInfo().title + partOfText + getAllAuthors(item.getVolumeInfo().getAuthors());
                bookName.setText(textForName);
                //  String book = String.format(R.string.bookName,item.volumeInfo.title,getAllAuthors(item.volumeInfo.getAuthors()))
                //     bookName.setText((String.format(R.string.bookName),item.volumeInfo.title,getAllAuthors(item.volumeInfo.getAuthors()));
            } else {
                bookName.setText(item.getVolumeInfo().title);
            }
        }

        String getAllAuthors(List<String> authors) {
            String allAuthors = "";
            for (int i = 0; i <= authors.size() - 1; i++) {
                allAuthors = allAuthors + ", " + authors.get(i);
            }
            return allAuthors;
        }

        void setup(Items item, FindActivityContract.BookListener bookListener) {
            if (item.getVolumeInfo().imageLinks == null) {
                setImageWithoutApiResponse();
            } else {
                setImageGlide(item);
            }

            bookDescription.setText(item.getVolumeInfo().getDescription());
            setBookNameText(item);
            itemView.setOnClickListener(view -> {

                        Bundle selectedBookData = new Bundle();
                        setDataOfBook(item, selectedBookData);
                        Intent intent = new Intent(itemView.getContext(), ChosenBookActivity.class);
                        intent.putExtras(selectedBookData);
                        WatchedBook watchedBook = new WatchedBook(item.getVolumeInfo().getTitle(), item.getVolumeInfo().language,
                                item.getVolumeInfo().infoLink, item.getAccessInfo().getWebReaderLink(), item.getVolumeInfo().maturityRating,
                                item.getAccessInfo().getPdf().getAcsTokenLink(), item.getVolumeInfo().getDescription(), item.getSaleInfo().getBuyLink(),
                                selectedBookData.getString("listPriceAmountWithCurrencyCode"), selectedBookData.getString("listPriceRetailAmountWithCurrencyCode"),prepareBookImageToPassString());
                        bookListener.passBookToDatabase(watchedBook);

                        itemView.getContext().startActivity(intent);

                    }
            );


        }

        private void setDataOfBook(Items item, Bundle selectedBookData) {
            selectedBookData.putString("BookTitle", item.getVolumeInfo().getTitle());
            selectedBookData.putString("BookLanguage", item.getVolumeInfo().language);
            selectedBookData.putString("BookInfolink", item.getVolumeInfo().infoLink);
            selectedBookData.putString("BookWebReaderLink", item.getAccessInfo().getWebReaderLink());
            selectedBookData.putString("BookMaturity", item.getVolumeInfo().maturityRating);
            selectedBookData.putString("BookDownload", item.getAccessInfo().getPdf().getAcsTokenLink());
            selectedBookData.putString("BookDescription", item.getVolumeInfo().getDescription());
            selectedBookData.putString("BookBuyLink", item.getSaleInfo().getBuyLink());
            checkIfListPriceIsAvailable(item, selectedBookData);
            checkIfRetailPriceIsAvailable(item, selectedBookData);
            selectedBookData.putByteArray("BookImageArray", prepareBookImageToPass());
            selectedBookData.putStringArray("KeyArray", createKeysArray());

        }

        private String[] createKeysArray() {
            String[] prepareArray = new String[10];
            prepareArray[0] = "BookTitle";
            prepareArray[1] = "BookLanguage";
            prepareArray[2] = "BookInfolink";
            prepareArray[3] = "BookWebReaderLink";
            prepareArray[4] = "BookMaturity";
            prepareArray[5] = "BookDownload";
            prepareArray[6] = "BookBuyLink";
            prepareArray[7] = "BookDescription";
            prepareArray[8] = "listPriceAmountWithCurrencyCode";
            prepareArray[9] = "listPriceRetailAmountWithCurrencyCode";

            return prepareArray;
        }


        private byte[] prepareBookImageToPass() {
            itemView.setDrawingCacheEnabled(true);
            bookImage.buildDrawingCache();
            Bitmap bookBitmap = bookImage.getDrawingCache();
            itemView.setDrawingCacheEnabled(false);
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            bookBitmap.compress(Bitmap.CompressFormat.PNG, 100, bs);
            return bs.toByteArray();
        }

        private String prepareBookImageToPassString() {
            itemView.setDrawingCacheEnabled(true);
            bookImage.buildDrawingCache();
            Bitmap bookBitmap = bookImage.getDrawingCache();
            itemView.setDrawingCacheEnabled(false);
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            bookBitmap.compress(Bitmap.CompressFormat.PNG, 100, bs);
            return bs.toString();
        }

        private void setImageWithoutApiResponse() {
        }

        private void setImageGlide(Items item) {
            Glide.with(itemView.getContext())
                    .load(item.getVolumeInfo().getImageLinks().thumbnail)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Toast.makeText(itemView.getContext(), "failed", Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                            return false;
                        }

                    })
                    .into(bookImage);
        }

        private void checkIfRetailPriceIsAvailable(Items item, Bundle selectedBookData) {
            if (item.getSaleInfo().retailPrice == null) {
                selectedBookData.putString("listPriceRetailAmountWithCurrencyCode", "Information not provided");

            } else {
                selectedBookData.putString("listPriceRetailAmountWithCurrencyCode", item.getSaleInfo().retailPrice.getAmount().toString() + " "
                        + item.getSaleInfo().retailPrice.currencyCode);
            }
        }

        private void checkIfListPriceIsAvailable(Items item, Bundle selectedBookData) {
            if (item.getSaleInfo().listPrice == null) {
                selectedBookData.putString("listPriceAmountWithCurrencyCode", "Information not provided");
            } else {
                selectedBookData.putString("listPriceAmountWithCurrencyCode", String.valueOf(item.getSaleInfo().listPrice.getAmount().toString()) + " "
                        + item.getSaleInfo().listPrice.currencyCode);
            }
        }


    }


}

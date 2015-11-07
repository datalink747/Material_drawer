package material_design.soussi.com.material_drawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import material_design.soussi.com.material_drawer.model.Events;

/**
 * Created by Soussi on 06/11/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContentViewHolder> {

    public interface RecyclerViewAdapterCallBack {
        void onRecyclerViewElementClicked(View view, int position, Events element);
    }

    RecyclerViewAdapterCallBack callback;
    List<Events> contents = new ArrayList<>();

    public RecyclerViewAdapter(RecyclerViewAdapterCallBack callback) {
        this.callback = callback;
    }

    public void addObjects(List<Events> contents) {
        this.contents.addAll(contents);
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_cards, parent, false);
        return new ContentViewHolder(view, callback);
    }


    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        holder.bind(contents.get(position));
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RecyclerViewAdapterCallBack callback;
        private Events myObject;
        private TextView textViewView;
        private  ImageView imageView;
        //@InjectView(R.id.text)

        //@InjectView(R.id.image)


        public ContentViewHolder(View itemView, RecyclerViewAdapterCallBack callback) {
            super(itemView);
            this.callback = callback;

           // ButterKnife.inject(this, itemView);
            textViewView=(TextView)itemView.findViewById(R.id.text);
            imageView=(ImageView)itemView.findViewById(R.id.image);
            this.itemView.setOnClickListener(this);
        }

        public void bind(Events myObject) {
            this.myObject = myObject;
            textViewView.setText(myObject.getText());
            Picasso.with(imageView.getContext()).load(myObject.getImageUrl()).centerCrop().fit().into(imageView);
        }

        @Override
        public void onClick(View v) {
            this.callback.onRecyclerViewElementClicked(this.itemView, this.getAdapterPosition(), myObject);
        }
    }
}
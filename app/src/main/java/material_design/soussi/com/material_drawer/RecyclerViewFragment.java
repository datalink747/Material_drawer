package material_design.soussi.com.material_drawer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import java.util.ArrayList;
import java.util.List;

import material_design.soussi.com.material_drawer.model.Events;


public class RecyclerViewFragment extends Fragment implements RecyclerViewAdapter.RecyclerViewAdapterCallBack {

    RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter(this);
        adapter.addObjects(createEvents());

        recyclerView.setAdapter(adapter);
    }

    private List<Events> createEvents() {
        List<Events> objects = new ArrayList<>();

        objects.add(new Events("Tunisie", "http://www.nachoua.com/Sahel/sousse-plage.jpg"));
        objects.add(new Events("France", "http://www.telegraph.co.uk/travel/destination/article130148.ece/ALTERNATES/w620/parisguidetower.jpg"));
        objects.add(new Events("Angleterre", "http://www.traditours.com/images/Photos%20Angleterre/ForumLondonBridge.jpg"));
        objects.add(new Events("Allemagne", "http://tanned-allemagne.com/wp-content/uploads/2012/10/pano_rathaus_1280.jpg"));
        objects.add(new Events("Espagne", "http://www.sejour-linguistique-lec.fr/wp-content/uploads/espagne-02.jpg"));
        objects.add(new Events("Italie", "http://retouralinnocence.com/wp-content/uploads/2013/05/Hotel-en-Italie-pour-les-Vacances2.jpg"));
        objects.add(new Events("Russie", "http://www.choisir-ma-destination.com/uploads/_large_russie-moscou2.jpg"));


        return objects;
    }

    @Override
    public void onRecyclerViewElementClicked(View view, int position, Events element) {
        Intent intent = new Intent(getActivity(), Detail_events.class);
        intent.putExtra(Detail_events.MY_OBJECT, element);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                getActivity(),
                Pair.create(view.findViewById(R.id.image), getResources().getString(R.string.image))
        );

        ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
    }

}

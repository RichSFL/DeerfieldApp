package com.example.android.deerfield;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SightseeingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {





        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.QuietWPark,R.string.QWPAdd,
                R.drawable.quietwp, R.raw.color_red));
        places.add(new Place(R.string.DfbIPark, R.string.DfbIParkAdd,
                R.drawable.dfbislprk, R.raw.color_mustard_yellow));
        places.add(new Place(R.string.SullivanPark, R.string.SullivanParkAdd,
                R.drawable.sullivan, R.raw.color_dusty_yellow));
        places.add(new Place(R.string.HillsInlet, R.string.HillsInletAdd,
                R.drawable.inlet, R.raw.color_green));
        places.add(new Place(R.string.RailwayMuseum, R.string.RailwayMuseumAdd, R.drawable.railwaymuseum, R.raw.color_brown));
        places.add(new Place(R.string.FishingPier, R.string.FishingPierAdd, R.drawable.dfbpier, R.raw.color_brown));
        places.add(new Place(R.string.TheBeach, R.string.TheBeachAdd, R.drawable.thebeach, R.raw.color_brown));


        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_sightseeing);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

// Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                // Get the {@link Place} object at the given position the user clicked on
                int location = places.get(position).getMiwokTranslationId();
                String address = String.valueOf(location);
                Toast.makeText(getActivity(),location,Toast.LENGTH_LONG).show();
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + address);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);


            }
        });

        return rootView;
    }
}

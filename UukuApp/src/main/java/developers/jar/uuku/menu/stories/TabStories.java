package developers.jar.uuku.menu.stories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import developers.jar.uuku.menu.CardViewMainActivity;

/**
 * Created by axeljovanny on 9/02/17.
 */

public class TabStories extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(developers.jar.uuku.R.layout.tab_stories, container, false);
        View colormenu = rootView.findViewById(developers.jar.uuku.R.id.btn_stories);

        colormenu.setOnClickListener(this);



        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case developers.jar.uuku.R.id.btn_stories:
                Intent i = new Intent(getActivity().getApplicationContext(), CardViewMainActivity.class);
                startActivity(i);
                break;
            default:

                break;

        }

    }
}

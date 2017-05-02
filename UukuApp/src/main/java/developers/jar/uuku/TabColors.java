package developers.jar.uuku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import developers.jar.uuku.cards.CardColorActivity;

/**
 * Created by axeljovanny on 9/02/17.
 */

public class TabColors extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_colors, container, false);
        View colormenu = rootView.findViewById(R.id.btn_colors);

        colormenu.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_colors:
                Intent i = new Intent(getActivity().getApplicationContext(), CardColorActivity.class);
                startActivity(i);
                break;
            default:

                break;

        }
    }
}

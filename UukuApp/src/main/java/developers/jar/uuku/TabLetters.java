package developers.jar.uuku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import developers.jar.uuku.cards.CardLettersActivity;

/**
 * Created by axeljovanny on 9/02/17.
 */

public class TabLetters  extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_letters, container, false);
        View colormenu = rootView.findViewById(R.id.btn_letters);

        colormenu.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_letters:
                Intent i = new Intent(getActivity().getApplicationContext(), CardLettersActivity.class);
                startActivity(i);
                break;
            default:

                break;

        }
    }
}

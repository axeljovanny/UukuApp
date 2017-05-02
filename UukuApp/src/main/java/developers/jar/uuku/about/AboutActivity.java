package developers.jar.uuku.about;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.activity_about);
    }

    @Bind(developers.jar.uuku.R.id.messageWithLinkTextView)
    TextView messageWithLinkTextView;


    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.findViewById(developers.jar.uuku.R.id.messageWithLinkTextView);
        ButterKnife.bind(this, view);
        messageWithLinkTextView.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void lanzarPoliticas(View view){
        Intent i = new Intent(this, PoliticasActivity.class);
        startActivity(i);
    }

}

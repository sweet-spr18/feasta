package sweet1.feasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button commentBtn;

    public void clickBtn() {
        //create button variable point to resource id
        Button commentBtn = findViewById(R.id.commentBtn);
        //add on click listener
        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set intent, tell android to link button to the comment class
                Intent startIntent = new Intent(getApplicationContext(), CommentsListingActivity.class);
                //start the intent, click the button
                startActivity(startIntent);


            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickBtn();


    }
}
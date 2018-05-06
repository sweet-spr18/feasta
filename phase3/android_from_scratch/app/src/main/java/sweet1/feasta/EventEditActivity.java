package sweet1.feasta;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class EventEditActivity extends AppCompatActivity {

    Toolbar mToolbar;
    private ImageButton selectImage;
    private EditText name;
    private EditText description;
    private EditText room;
    private Spinner location;
    private Uri selectImageUri;
    private String Description;
    private static final int Gallery_Pick= 1;
    private String saveCurrDate, saveCurrTime, postRandomName;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference postImageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);

        postImageRef = database.getReference();

        mToolbar = (Toolbar) findViewById(R.id.eventEditToolbar);
        setSupportActionBar(mToolbar);

        /* Get a support ActionBar corresponding to this toolbar */
        ActionBar ab = getSupportActionBar();

        /* Enable the Up button */
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        selectImage = (ImageButton) findViewById(R.id.select_image);
        name = (EditText) findViewById(R.id.event_name);
        description = (EditText) findViewById(R.id.event_description);
        location = (Spinner) findViewById(R.id.location);
        room = (EditText) findViewById(R.id.room);

        ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(EventEditActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.locations));
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(locationAdapter);

        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });
    }
        private void OpenGallery(){
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, Gallery_Pick);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Gallery_Pick && resultCode ==RESULT_OK && data != null){
            selectImageUri = data.getData();
            selectImage.setImageURI(selectImageUri);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mToolbar = (Toolbar) findViewById(R.id.eventEditToolbar);

        // Inflate the menu; this adds items to the bar if it is present
        mToolbar.inflateMenu(R.menu.menu_event_edit);
        mToolbar.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return onOptionsItemSelected(item);
                    }
                });
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menu_event_edit, menu);
        return true;
    }

    private void validatePostInfo(){
        Description = description.getText().toString();

        if (selectImageUri == null){
            Toast.makeText(this, "Please select an image", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Description)){
            Toast.makeText(this, "Please enter a short description about the event", Toast.LENGTH_SHORT).show();
        }
        else
            ImageToFirebase();
    }

    //-----NEEDS WORK---- USED THIS LINK BUT CAN'T GET HIS IMPORTS --- https://www.youtube.com/watch?v=N3npOixl9fk
    private void ImageToFirebase(){
        Calendar callForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MMMM-yyyy");
        saveCurrDate = currentDate.format(callForDate.getTime());

        Calendar callForTime = Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm");
        saveCurrTime = currentTime.format(callForDate.getTime());

        postRandomName = saveCurrDate + saveCurrTime;

        DatabaseReference filePath = postImageRef.child("Post Images").child(selectImageUri.getLastPathSegment() + postRandomName + ".jpg");
        //filePath.push(selectImageUri).addValueEventListener().


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_publish:
                //---TRIED TO ADD TO EVENT LISTINGS PAGE HERE USING FIREBASE METHODS ABOVE.
                validatePostInfo();
                Toast.makeText(EventEditActivity.this, "Your event has been published", Toast.LENGTH_LONG).show();
                Intent backToEventsList =
                        new Intent(getApplicationContext(), EventsListingActivity.class);
                startActivity(backToEventsList);
                return true;

            //TODO: add an image - either by taking a photo or select from pre-built gallery
            //TODO: if taking a photo, use Intent.ACTION_IMAGE_CAPTURE, as seen here:
            //https://developer.android.com/guide/components/intents-common#Camera
            //TODO: if getting a prebuilt photo, maybe see this link?
            //https://developer.android.com/guide/components/intents-common#Storage
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}

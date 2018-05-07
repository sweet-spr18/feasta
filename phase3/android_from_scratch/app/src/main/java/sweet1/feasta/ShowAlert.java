package sweet1.feasta;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class ShowAlert extends DialogInterface
{
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

    // Add the buttons
    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            // User clicked OK button
        }
    });
    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {

        }
    });

    void cancel()
    {

    }

    @Override
    public void dismiss() {
        
    }

    // Create the AlertDialog
    AlertDialog dialog = builder.create();
}

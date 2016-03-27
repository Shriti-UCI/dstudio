package edu.umich.dstudio.ui.addDataActivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by neera_000 on 3/27/2016.
 */
public class AddGalleryPhotoActivity extends GenericPhotoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestGalleryImage();
    }

    private void requestGalleryImage() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, REQUEST_GALLERY);
    }
}

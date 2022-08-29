package com.cecom.caukiosk.buttons;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cecom.caukiosk.FloorActivity;
import com.cecom.caukiosk.R;

public class FloorExtButton {
    FloorActivity floorActivity;
    View view;

    public void initializeButton(FloorActivity floorActivity, View view){
        this.floorActivity = floorActivity;
        this.view = view;

        Button button201 = view.findViewById(R.id.btn_room_b201);
        Button button202 = view.findViewById(R.id.btn_room_b202);
        Button button203 = view.findViewById(R.id.btn_room_b203);

        button201.setOnClickListener(buttonListener);
        button202.setOnClickListener(buttonListener);
        button203.setOnClickListener(buttonListener);


    }

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button selButton = view.findViewById(view.getId());
            ImageView mapImage = floorActivity.getWindow().findViewById(R.id.floor_map);

            int mapHeight = mapImage.getHeight();
            int mapWidth = mapImage.getWidth();
            int mapMarginLeft = mapImage.getLeft();
            int mapMarginTop = mapImage.getTop();

            floorActivity.openRoomInfo(selButton.getText().toString(), mapWidth, mapHeight, mapMarginLeft, mapMarginTop, selButton.getWidth(), selButton.getHeight(), selButton.getLeft(), selButton.getTop(), selButton.getRotation());
        }
    };
}

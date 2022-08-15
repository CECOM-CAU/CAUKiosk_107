package com.cecom.caukiosk.buttons;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cecom.caukiosk.FloorActivity;
import com.cecom.caukiosk.R;

public class Floor2Button {
    FloorActivity floorActivity;
    View view;

    public void initializeButton(FloorActivity floorActivity, View view){
        this.floorActivity = floorActivity;
        this.view = view;

        Button button201 = view.findViewById(R.id.btn_room_201);
        Button button203 = view.findViewById(R.id.btn_room_203);
        Button button204 = view.findViewById(R.id.btn_room_204);
        Button button205 = view.findViewById(R.id.btn_room_205);
        Button button206 = view.findViewById(R.id.btn_room_206);
        Button button207 = view.findViewById(R.id.btn_room_207);
        Button button208 = view.findViewById(R.id.btn_room_208);
        Button button209 = view.findViewById(R.id.btn_room_209);


        button201.setOnClickListener(buttonListener);
        button203.setOnClickListener(buttonListener);
        button204.setOnClickListener(buttonListener);
        button205.setOnClickListener(buttonListener);
        button206.setOnClickListener(buttonListener);
        button207.setOnClickListener(buttonListener);
        button208.setOnClickListener(buttonListener);
        button209.setOnClickListener(buttonListener);

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

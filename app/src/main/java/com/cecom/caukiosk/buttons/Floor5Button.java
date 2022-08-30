package com.cecom.caukiosk.buttons;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cecom.caukiosk.FloorActivity;
import com.cecom.caukiosk.R;

public class  Floor5Button {
    FloorActivity floorActivity;
    View view;

    public void initializeButton(FloorActivity floorActivity, View view){
        this.floorActivity = floorActivity;
        this.view = view;

        Button button501 = view.findViewById(R.id.btn_room_501);
        Button button502 = view.findViewById(R.id.btn_room_502);
        Button button503 = view.findViewById(R.id.btn_room_503);
        Button button504 = view.findViewById(R.id.btn_room_504);
        Button button505 = view.findViewById(R.id.btn_room_505);
        Button button506 = view.findViewById(R.id.btn_room_506);
        Button button507 = view.findViewById(R.id.btn_room_507);
        Button button508 = view.findViewById(R.id.btn_room_508);
        Button button509 = view.findViewById(R.id.btn_room_509);
        Button button510 = view.findViewById(R.id.btn_room_510);
        Button button511 = view.findViewById(R.id.btn_room_511);
        Button button512 = view.findViewById(R.id.btn_room_512);
        Button button513 = view.findViewById(R.id.btn_room_513);
        Button button514 = view.findViewById(R.id.btn_room_514);

        button501.setOnClickListener(buttonListener);
        button502.setOnClickListener(buttonListener);
        button503.setOnClickListener(buttonListener);
        button504.setOnClickListener(buttonListener);
        button505.setOnClickListener(buttonListener);
        button506.setOnClickListener(buttonListener);
        button507.setOnClickListener(buttonListener);
        button508.setOnClickListener(buttonListener);
        button509.setOnClickListener(buttonListener);
        button510.setOnClickListener(buttonListener);
        button511.setOnClickListener(buttonListener);
        button512.setOnClickListener(buttonListener);
        button513.setOnClickListener(buttonListener);
        button514.setOnClickListener(buttonListener);
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

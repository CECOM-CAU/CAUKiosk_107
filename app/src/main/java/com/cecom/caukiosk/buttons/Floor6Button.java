package com.cecom.caukiosk.buttons;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cecom.caukiosk.FloorActivity;
import com.cecom.caukiosk.R;

public class Floor6Button {
    FloorActivity floorActivity;
    View view;

    public void initializeButton(FloorActivity floorActivity, View view){
        this.floorActivity = floorActivity;
        this.view = view;
        Button button601 = view.findViewById(R.id.btn_room_601);
        Button button602 = view.findViewById(R.id.btn_room_602);
        Button button603 = view.findViewById(R.id.btn_room_603);
        Button button604 = view.findViewById(R.id.btn_room_604);
        Button button605 = view.findViewById(R.id.btn_room_605);
        Button button607 = view.findViewById(R.id.btn_room_607);
        Button button608 = view.findViewById(R.id.btn_room_608);
        Button button609 = view.findViewById(R.id.btn_room_609);
        Button button610 = view.findViewById(R.id.btn_room_610);
        Button button611 = view.findViewById(R.id.btn_room_611);
        Button button612 = view.findViewById(R.id.btn_room_612);
        Button button613 = view.findViewById(R.id.btn_room_613);

        button601.setOnClickListener(buttonListener);
        button602.setOnClickListener(buttonListener);
        button603.setOnClickListener(buttonListener);
        button604.setOnClickListener(buttonListener);
        button605.setOnClickListener(buttonListener);
        button607.setOnClickListener(buttonListener);
        button608.setOnClickListener(buttonListener);
        button609.setOnClickListener(buttonListener);
        button610.setOnClickListener(buttonListener);
        button611.setOnClickListener(buttonListener);
        button612.setOnClickListener(buttonListener);
        button613.setOnClickListener(buttonListener);
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

package com.cecom.caukiosk.buttons;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cecom.caukiosk.FloorActivity;
import com.cecom.caukiosk.R;

public class Floor1Button {
    FloorActivity floorActivity;
    View view;

    public void initializeButton(FloorActivity floorActivity, View view){
        this.floorActivity = floorActivity;
        this.view = view;

        Button button101 = view.findViewById(R.id.btn_room_101);
        Button button103 = view.findViewById(R.id.btn_room_103);
        Button button104 = view.findViewById(R.id.btn_room_104);
        Button button105 = view.findViewById(R.id.btn_room_105);
        Button button106 = view.findViewById(R.id.btn_room_106);
        Button button107 = view.findViewById(R.id.btn_room_107);
        Button button108 = view.findViewById(R.id.btn_room_108);
        Button button109 = view.findViewById(R.id.btn_room_109);
        Button button110 = view.findViewById(R.id.btn_room_110);
        Button button111 = view.findViewById(R.id.btn_room_111);
        Button button112 = view.findViewById(R.id.btn_room_112);
        Button button113 = view.findViewById(R.id.btn_room_113);
        Button button114 = view.findViewById(R.id.btn_room_114);

        button101.setOnClickListener(buttonListener);
        button103.setOnClickListener(buttonListener);
        button104.setOnClickListener(buttonListener);
        button105.setOnClickListener(buttonListener);
        button106.setOnClickListener(buttonListener);
        button107.setOnClickListener(buttonListener);
        button108.setOnClickListener(buttonListener);
        button109.setOnClickListener(buttonListener);
        button110.setOnClickListener(buttonListener);
        button111.setOnClickListener(buttonListener);
        button112.setOnClickListener(buttonListener);
        button113.setOnClickListener(buttonListener);
        button114.setOnClickListener(buttonListener);
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

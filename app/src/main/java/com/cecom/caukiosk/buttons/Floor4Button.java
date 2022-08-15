package com.cecom.caukiosk.buttons;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cecom.caukiosk.FloorActivity;
import com.cecom.caukiosk.R;

public class Floor4Button {
    FloorActivity floorActivity;
    View view;

    public void initializeButton(FloorActivity floorActivity, View view){
        this.floorActivity = floorActivity;
        this.view = view;

        Button button401 = view.findViewById(R.id.btn_room_401);
        Button button402 = view.findViewById(R.id.btn_room_402);
        Button button403 = view.findViewById(R.id.btn_room_403);
        Button button404 = view.findViewById(R.id.btn_room_404);
        Button button405 = view.findViewById(R.id.btn_room_405);
        Button button406 = view.findViewById(R.id.btn_room_406);
        Button button407 = view.findViewById(R.id.btn_room_407);
        Button button408 = view.findViewById(R.id.btn_room_408);
        Button button409 = view.findViewById(R.id.btn_room_409);
        Button button410 = view.findViewById(R.id.btn_room_410);
        Button button411 = view.findViewById(R.id.btn_room_411);
        Button button412 = view.findViewById(R.id.btn_room_412);
        Button button413 = view.findViewById(R.id.btn_room_413);
        Button button414 = view.findViewById(R.id.btn_room_414);
        Button button415 = view.findViewById(R.id.btn_room_415);
        Button button416 = view.findViewById(R.id.btn_room_416);
        Button button417 = view.findViewById(R.id.btn_room_417);

        button401.setOnClickListener(buttonListener);
        button402.setOnClickListener(buttonListener);
        button403.setOnClickListener(buttonListener);
        button404.setOnClickListener(buttonListener);
        button405.setOnClickListener(buttonListener);
        button406.setOnClickListener(buttonListener);
        button407.setOnClickListener(buttonListener);
        button408.setOnClickListener(buttonListener);
        button409.setOnClickListener(buttonListener);
        button410.setOnClickListener(buttonListener);
        button411.setOnClickListener(buttonListener);
        button412.setOnClickListener(buttonListener);
        button413.setOnClickListener(buttonListener);
        button414.setOnClickListener(buttonListener);
        button415.setOnClickListener(buttonListener);
        button416.setOnClickListener(buttonListener);
        button417.setOnClickListener(buttonListener);


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

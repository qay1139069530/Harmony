package com.huawei.wearablejava.slice;

import com.huawei.wearablejava.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class SecondAbilitySlice extends AbilitySlice {
    Text mText;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_second);
    }

    @Override
    public void onActive() {
        super.onActive();
        Button button = (Button) findComponentById(ResourceTable.Id_secondButton);
        button.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                terminateAbility();
            }
        });
        mText = (Text) findComponentById(ResourceTable.Id_secondText);
        Button changeText = (Button) findComponentById(ResourceTable.Id_changeText);
        changeText.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                mText.setText("页面文字修改了");
            }
        });
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}

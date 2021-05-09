package com.huawei.wearablejava.slice;

import com.huawei.wearablejava.ResourceTable;
import com.huawei.wearablejava.SecondAbility;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
    }

    @Override
    public void onActive() {
        super.onActive();
        Button button = (Button) findComponentById(ResourceTable.Id_mainButton);
        button.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                onJumpAbility();
            }
        });
    }

    private void onJumpAbility() {
        Intent intent = new Intent();
        Operation operation = new
                Intent.OperationBuilder()
                .withDeviceId("")
                .withBundleName("com.huawei.wearablejava")
                .withAbilityName(SecondAbility.class.getCanonicalName())
                .build();
        // 把 operation 设置到 intent 中
        intent.setOperation(operation);
        startAbility(intent);
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}

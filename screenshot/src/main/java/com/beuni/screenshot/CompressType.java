package com.beuni.screenshot;

import androidx.annotation.IntDef;

@IntDef({
        CompressType.JPEG,
        CompressType.PNG,
        CompressType.WEBP
})

public @interface CompressType {
    int JPEG = 1;
    int PNG = 2;
    int WEBP = 3;
}

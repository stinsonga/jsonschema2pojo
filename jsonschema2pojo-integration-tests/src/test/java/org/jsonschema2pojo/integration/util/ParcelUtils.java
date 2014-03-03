package org.jsonschema2pojo.integration.util;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class ParcelUtils {

    private ParcelUtils() {
    }
    
    public static Parcel writeToParcel(Parcelable instance, String key) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(key, instance);
        
        Parcel parcel = Parcel.obtain();
        parcel.writeBundle(bundle);
        return parcel;
    }
    
    public static Parcelable readFromParcel(Parcel parcel, Class<?> parcelableType, String key) {
        parcel.setDataPosition(0);

        Bundle bundle = parcel.readBundle();
        bundle.setClassLoader(parcelableType.getClassLoader());
        
        Parcelable unparceledInstance = bundle.getParcelable(key);
        return unparceledInstance;
    }

}

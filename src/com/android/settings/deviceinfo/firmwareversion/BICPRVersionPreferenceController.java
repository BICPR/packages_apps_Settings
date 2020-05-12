/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import androidx.annotation.VisibleForTesting;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class BICPRVersionPreferenceController extends BasePreferenceController {

    @VisibleForTesting
    private static final String BICPR_NUM_VERSION = "com.bicpr.version";
    private static final String BICPR_BUILD_TYPE = "com.bicpr.build_type";
    private static final String BICPR_BUILD_DATE = "com.bicpr.build_date";

    public BICPRVersionPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
     String bicprVer =  SystemProperties.get(BICPR_NUM_VERSION);
     String bicprDate = SystemProperties.get(BICPR_BUILD_DATE);
     String bicprType = SystemProperties.get(BICPR_BUILD_TYPE);

      if (!bicprVer.isEmpty() && !bicprDate.isEmpty() && !bicprType.isEmpty())
	    return bicprVer + " | " + bicprDate + " | " + bicprType;
	else
            return mContext.getString(R.string.unknown);
    }
}

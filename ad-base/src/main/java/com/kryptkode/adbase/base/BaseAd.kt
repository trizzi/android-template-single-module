package com.kryptkode.adbase.base

import android.app.Activity
import com.kryptkode.adbase.Ad
import com.kryptkode.adbase.AdType
import com.kryptkode.adbase.R


abstract class BaseAd(protected var activity: Activity) :
    Ad {

    open val adType = AdType.AD_MOB
    protected var INTERSTITIAL_INTERVAL = 2 //TODO: Randomize the interval
    protected var REWARDED_VIDEO_INTERVAL = 4
    protected var interstitialCounter = 0
    protected var rewardedVideoCounter = 0

    init {
        INTERSTITIAL_INTERVAL = activity.resources.getInteger(R.integer.intervals_for_interstitial)
        REWARDED_VIDEO_INTERVAL = activity.resources.getInteger(R.integer.intervals_for_rewarded_video)
    }


}
package com.devmeist3r.didemo

import dagger.Binds
import dagger.Module


@Module
abstract class NCBatteryModule {

  @Binds
  abstract fun bindsNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery

}

/*
 * Copyright (C) 2022 The Android Open Source Project
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

package dev.artenes.template

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import dev.artenes.app.BuildConfig
import xyz.artenes.template.di.FactoryLocator
import xyz.artenes.template.di.FactoryLocatorMapping
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {

    @Inject
    lateinit var mapping: FactoryLocatorMapping

    override fun onCreate() {
        super.onCreate()
        FactoryLocator.instance = mapping
        val tree = if (_root_ide_package_.dev.artenes.app.BuildConfig.DEBUG) Timber.DebugTree() else ProductionTree()
        Timber.plant(tree)
    }

}
//
// Created by Andre Napitupulu on 27/4/22.
// Copyright (c) 2022 orgName. All rights reserved.
//

import Foundation
import common

func startKoin() {
    let doOnStartup = {
    }

    let koinApplication = KoinIOSKt.doInitKoinIos(doOnStartup: doOnStartup)
    _koin = koinApplication.koin
}

private var _koin: Koin_coreKoin?
var koin: Koin_coreKoin {
    return _koin!
}
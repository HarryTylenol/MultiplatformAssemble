//
//  Koin.swift
//  ios
//
//  Created by 박현기 on 2021/05/30.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

private var _koin: Koin_coreKoin? = nil
var koin: Koin_coreKoin {
    return _koin!
}

func startKoin() {
    _koin = KoinKt.doInitKoin().koin
}

func inject<T : AnyObject>() -> T {
    return koin.get(objCClass: T.self) as! T
}

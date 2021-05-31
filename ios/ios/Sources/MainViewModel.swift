//
//  MainViewModel.swift
//  ios
//
//  Created by 박현기 on 2021/05/30.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared
import Combine

class MainViewModel : ObservableObject {
    
    @Published var members = [Member]()
    
    private var repository : MemberRepository = MemberRepositoryImp()
    
    init() {
        
        repository.getAndroidMembers { response, error in
            self.members = response?.data as! [Member]
        }
    }
    
}

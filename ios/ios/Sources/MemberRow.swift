//
//  MemberRow.swift
//  ios
//
//  Created by 박현기 on 2021/05/30.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MemberRow: View {
    
    var member : Member
    
    var body: some View {
        VStack {
            Text(member.name)
            Spacer()
            Text(member.level)
        }
    }
}

struct MemberRow_Previews: PreviewProvider {
    static var previews: some View {
        MemberRow(member: Member(name: "Harry", level: "초보"))
    }
}

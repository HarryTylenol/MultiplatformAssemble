import SwiftUI
import shared

struct ContentView: View {
    
    @StateObject var viewModel = MainViewModel()
    
	var body: some View {
        let members : [Member] = viewModel.members
        
        NavigationView {
            List {
                ForEach(members, id: \.self) { member in
                    MemberRow(member: member)
                }
            }.navigationTitle("MultiplatformAssemble")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}

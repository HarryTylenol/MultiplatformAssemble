import SwiftUI
import shared

struct ContentView: View {
    
    @StateObject var viewModel = MainViewModel()
    
	var body: some View {
        Text("")
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}

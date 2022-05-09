import SwiftUI
import common

struct ContentView: View {

    @StateObject var vm = ContentViewModel()

    var body: some View {
        Text(vm.text)
                .onAppear(perform: {
                    vm.activate()
                })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

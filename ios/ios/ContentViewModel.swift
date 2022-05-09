//
// Created by Andre Napitupulu on 27/4/22.
// Copyright (c) 2022 orgName. All rights reserved.
//

import Foundation
import common

@MainActor
class ContentViewModel: ObservableObject {
    private lazy var getFact: GetRandomFactUseCase = UseCaseBridge().getRandomFact()

    @Published var text: String = ""

    func activate() {
        getFact.executeAndWatch { result in
            self.text = result.data?.text ?? ""
        }
    }
}

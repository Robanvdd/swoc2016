import QtQuick 2.7
import QtQuick.Controls 2.1
import QtQuick.Layouts 1.1

Column {
    spacing: 16
    Grid {
        id: gameGrid
        flow: Grid.TopToBottom
        rows: 3
        columnSpacing: 8

        Label {
            text: "ID"
            visible: gameBackend.objectId != -1
        }
        Label {
            text: "Game name"
            visible: gameBackend.objectId != -1
        }
        Label {
            text: "Current tick"
            visible: gameBackend.objectId != -1
        }

        Label {
            id: labelId
            text: gameBackend.objectId
            visible: gameBackend.objectId != -1
        }

        Label {
            id: labelName
            text: gameBackend.name
            visible: gameBackend.objectId != -1
        }

        Label {
            id: labelTick
            text: gameBackend.currentTick
            visible: gameBackend.objectId != -1
        }
    }
    GridLayout {
        id: playerCreditGrid
        columns: 2
        rowSpacing: gameGrid.rowSpacing
        Repeater {
            model: gameBackend.players
            delegate: Item {
                Label {
                    parent: playerCreditGrid
                    Layout.column: 0
                    Layout.row: index
                    text: modelData.name
                }
                Label {
                    parent: playerCreditGrid
                    Layout.column: 1
                    Layout.row: index
                    text: modelData.credits
                }
            }
        }
    }
}

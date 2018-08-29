
interface GameView {

    //updates view
    //any class that implements the interface will be notified when model updates
    //and use the model param to update UI accordingly



    fun update(model: GameModel=GameModel)
}
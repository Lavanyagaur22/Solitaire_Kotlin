

//presenter serves as a middleman between view and model

//view ->presenter ->model (update) -> pass model to the view' update method to update screen

object GamePresenter {
    //as we are going to have only 1 presenter

    var view: GameView? = null  //view property

    fun setGameView(gameView: GameView){  //to populate the view
        view=gameView
    }

    fun onDeckTap() {
        //update the model ->which is accessible in kotlin
        //we are modelling only one game of solitaire , i.e. we are going to model only one game at a time
        //so declare game model as singleton -> use object instead of class


        GameModel.onDeckTap()
        view?.update()
    }

    fun onWasteTap(){
        GameModel.onWasteTap()
        view?.update()
    }



    fun onFoundationTap(foundationIndex: Int) {

        GameModel.onFoundationTap(foundationIndex)
        view?.update()


    }


    fun onTableauTap(tableauIndex: Int, cardIndex: Int) {
        GameModel.onTableauTap(tableauIndex,cardIndex)
        view?.update()
    }
}
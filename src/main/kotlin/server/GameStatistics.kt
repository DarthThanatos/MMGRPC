package server

class GameStatistics(){

    private val guessesHistory = arrayListOf<Combination>()
    private val verificationsHistory = arrayListOf<Verification>()
    lateinit var secretCombination: Combination

    private var currentRound = 0

    fun addGuess(combination: Combination){
        guessesHistory.add(combination)
    }

    fun addVerificationAndIncrementRound(verification: Verification){
        verificationsHistory.add(verification)
        currentRound += 1
    }

    fun gameOver(verification: Verification) =
        (verification.first ==  VerificationMarker.GOOD_PLACE_AND_COLOR &&
        verification.second ==  VerificationMarker.GOOD_PLACE_AND_COLOR &&
        verification.third ==  VerificationMarker.GOOD_PLACE_AND_COLOR &&
        verification.fourth ==  VerificationMarker.GOOD_PLACE_AND_COLOR)
        || currentRound == 15
}
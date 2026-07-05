import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PokerScreen(
    viewModel: PokerViewModel = viewModel()
) {
    PokerScreenContent(
        game = viewModel.game,
        onNewGame = { viewModel.newGame() }
    )
}
package strategies.botplayingstrategies;

import models.Board;
import models.Cell;

public interface BotPlayingStrategy {

    Cell makeMove(Board board);
}

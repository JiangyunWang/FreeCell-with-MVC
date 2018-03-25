package cs3500.hw03;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellOperations;
import cs3500.hw02.PileType;

/**
 * Represent a controller for Freecell.
 */
public class FreecellController implements IFreecellController<Card> {
  private Readable rd;
  private Appendable ap;

  /**
   * A contractor for the class FreecellController.
   *
   * @param rd represents the input from the user.
   * @param ap represents the output from the game.
   */
  public FreecellController(Readable rd, Appendable ap) {
    if (ap == null) {
      throw new IllegalStateException("Invalid output.");
    } else {
      this.ap = ap;
    }

    if (rd == null) {
      throw new IllegalStateException("Invalid input.");
    } else {
      this.rd = rd;
    }
  }


  /**
   * Check does string equal to "Q", or "q".
   *
   * @param s String of each segment in the input.
   * @return boolean that string equal to "Q", or "q" or not.
   */
  private boolean isQuit(String s) {
    if ((s.equals("Q")) || (s.equals("q"))) {
      try {
        ap.append("\nGame quit prematurely.");
        return true;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  /**
   * Check does game over.
   *
   * @param model the model of freecell .
   * @return boolean that does game over or not.
   */
  private boolean checkWin(FreecellOperations<Card> model) {
    if (model.isGameOver()) {
      try {
        ap.append("\n").append(model.getGameState()).append("\nGame over.");
      } catch (IOException e) {
        e.printStackTrace();
      }
      return true;
    }
    return false;
  }


  /**
   * Translate the string into PileType.
   *
   * @param s String in the input.
   * @return PileType that corresponding to the string. If not a pileType, retuen null.
   */
  private PileType getType(String s) {
    switch (s.substring(0, 1)) {
      case "C":
        return PileType.CASCADE;
      case "F":
        return PileType.FOUNDATION;
      case "O":
        return PileType.OPEN;
      default:
        throw new IllegalArgumentException("Invalid Pile type.");
    }
  }

  /**
   * Translate the String into the Integer.
   *
   * @param source String is from the input.
   * @return int that is transferred from the String. If not an integer, return a negative number.
   */
  private int getInt(String source) {
    try {
      return Integer.parseInt(source);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid pile number.");
    }
  }

  /**
   * Check is the index from the input is smaller than the pile number.
   *
   * @param s           index that represents the pile number.
   * @param numCascades the number of Cascades.
   * @param numOpens    the number of Opens.
   * @param type        the Piletype that index need to compare with.
   * @return boolean that the index from the input is smaller than the pile number or not.
   */
  private void checkIndex(int s, int numCascades, int numOpens, PileType type) {
    if (type.equals(PileType.CASCADE)) {
      if ((s >= numCascades) || (s < 0)) {
        throw new IllegalArgumentException("Out of Boundary.");
      }
    } else if (type.equals(PileType.OPEN)) {
      if ((s >= numOpens) || (s < 0)) {
        throw new IllegalArgumentException("Out of Boundary.");

      }
    } else if (type.equals(PileType.FOUNDATION)) {
      if ((s >= 4) || (s < 0)) {
        throw new IllegalArgumentException("Out of Boundary.");
      }
    }
  }

  /**
   * This method should start a new game of Freecell using the provided model, number of cascade and
   * open piles and the provided deck.
   *
   * @param deck        The deck to be used is the one provided as input, and not necessarily the
   *                    one returned from the model.
   * @param model       The model is to be used to get model methods.
   * @param numCascades The number piles of Cascades.
   * @param numOpens    The number piles of Opens.
   * @param shuffle     The boolean to decide is shuffle or not.
   */
  @Override
  public void playGame(List<Card> deck, FreecellOperations<Card> model,
                       int numCascades, int numOpens, boolean shuffle) throws
          IllegalArgumentException {

    if (deck == null) {
      throw new IllegalArgumentException("Invalid deck.");
    } else if (model == null) {
      throw new IllegalArgumentException("Invalid model.");
    } else {
      try {
        model.startGame(deck, numCascades, numOpens, shuffle);
      } catch (IllegalArgumentException e) {
        try {
          ap.append("Could not start game.");
        } catch (IOException e1) {
          e1.printStackTrace();
        }
        return;
      }
    }

    try {
      ap.append(model.getGameState());
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    Scanner s = new Scanner(rd);

    PileType source = null;
    PileType destination = null;
    int sourceIndex = -1;
    int cardIndex = -1;
    int desIndex = -1;
    int counter = 1;


    while (s.hasNext()) {
      String segment = s.next();

      if (isQuit(segment)) {
        return;
      }

      if (counter == 1) {
        try {
          source = getType(segment);
          sourceIndex = (getInt(segment.substring(1)) - 1);
          checkIndex(sourceIndex, numCascades, numOpens, source);
          counter++;
          continue;
        } catch (IllegalArgumentException e) {
          try {
            ap.append("\nInvalid move. Try again.").append(e.getMessage());
          } catch (IOException e1) {
            e1.printStackTrace();
          }
        }
      }

      if (counter == 2) {
        try {
          cardIndex = (getInt(segment) - 1);
          counter++;
          continue;
        } catch (IllegalArgumentException e) {
          try {
            ap.append("\nInvalid move. Try again." + e.getMessage());
          } catch (IOException e1) {
            e1.printStackTrace();
          }
        }
      }

      if (counter == 3) {
        try {
          destination = getType(segment);
          desIndex = (getInt(segment.substring(1)) - 1);
          checkIndex(desIndex, numCascades, numOpens, destination);
          counter++;
        } catch (IllegalArgumentException e) {
          try {
            ap.append("\nInvalid move. Try again.").append(e.getMessage());
            continue;
          } catch (IOException e1) {
            e1.printStackTrace();
          }
        }
      }


      if (counter == 4) {
        counter = 1;
        if ((source != null) && (destination != null) && (sourceIndex > -1) && (desIndex > -1)
                && (cardIndex > -1)) {
          try {
            model.move(source, sourceIndex, cardIndex, destination, desIndex);
            try {
              ap.append("\n").append(model.getGameState());
            } catch (IOException e) {
              e.printStackTrace();
            }
          } catch (IllegalArgumentException e) {
            try {
              ap.append("\nInvalid move. Try again.").append(e.getMessage());
            } catch (IOException e1) {
              e.printStackTrace();
            }
          }
        }
      }

      if (checkWin(model)) {
        return;
      }
    }
  }
}


package cs3500.hw04;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.PileType;


/**
 * A class is to represents MultiFreecell Model.
 * A more realistic version of Freecell is one where the player
 * can move several cards at once from one cascade pile to another
 * (while it is also possible to move several cards from a cascade pile to
 * a foundation pile, we will ignore this feature in this variation).
 */
public class MultiFreecellModel extends FreecellModel {

  /**
   * To get the number of Intermediate from cascade or open Piles.
   *
   * @param pile the list of specific pile type.
   * @return int that represents the number of Intermediate.
   */
  private int numIntermediate(List<List<Card>> pile) {
    int ans = 0;
    for (int i = 0; i < pile.size(); i++) {
      if (pile.get(i).size() == 0) {
        ans++;
      }
    }
    return ans;
  }

  /**
   * Check if the parameters are valid or not.
   *
   * @param pileNumber     the number source pile.
   * @param cardIndex      the Index of card.
   * @param destPileNumber the number Destination pile.
   * @return boolean if the parameters are valid or not.
   */
  private boolean checkValid(int pileNumber, int cardIndex, int destPileNumber) {
    return (pileNumber >= 0) && (pileNumber < this.cascades.size())
            && (destPileNumber >= 0) && (destPileNumber < this.cascades.size())
            && (cardIndex >= 0) && (cardIndex < this.cascades.get(pileNumber).size());
  }

  /**
   * To get the movelist from the cardIndex.
   *
   * @param cardIndex index of card.
   * @param source    list of source pile.
   * @return list that need to be moved.
   */
  private List<Card> movedList(int cardIndex, List<Card> source) {
    List<Card> temp = new ArrayList<Card>(Arrays.asList(source.get(cardIndex)));
    for (int j = cardIndex; j < (source.size() - 1); j++) {
      if (source.get(j).compareCard(source.get(j + 1))) {
        temp.add(source.get(j + 1));
      } else {
        throw new IllegalArgumentException("Invalid Sequence.");
      }
    }
    return temp;
  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex,
                   PileType destination, int destPileNumber) throws
          IllegalArgumentException {
    List<Card> temp;
    if ((source == PileType.CASCADE) && (destination == PileType.CASCADE)) {
      if (checkValid(pileNumber, cardIndex, destPileNumber)) {
        List<Card> sourceCas = this.cascades.get(pileNumber);
        List<Card> desSource = this.cascades.get(destPileNumber);

        if ((sourceCas.size() - cardIndex) <= ((numIntermediate(this.opens) + 1)
                * ((int) (Math.pow(2, numIntermediate(this.cascades)))))) {

          if (desSource.get(desSource.size() - 1).compareCard(sourceCas.get(cardIndex))) {
            temp = movedList(cardIndex, sourceCas);
            if (temp.size() == (sourceCas.size() - cardIndex)) {
              sourceCas.removeAll(temp);
              desSource.addAll(temp);
            } else {
              throw new IllegalArgumentException("Invalid sequence.");
            }
          } else {

            throw new IllegalArgumentException("Invalid move.");
          }
        } else {
          throw new IllegalArgumentException("Lack of space.");
        }

      } else {
        throw new IllegalArgumentException("Invalid Input.");
      }

    } else {
      super.move(source, pileNumber, cardIndex, destination, destPileNumber);
    }

  }

}

package cs3500.hw02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A class represents a model for the game Freecell.
 */
public class FreecellModel implements FreecellOperations<Card> {
  protected List<List<Card>> cascades;
  protected List<List<Card>> opens;
  protected List<List<Card>> foundations;

  /**
   * A constructor for Freecell Model.
   */
  public FreecellModel() {
    this.cascades = new ArrayList<List<Card>>();
    this.opens = new ArrayList<List<Card>>();
    this.foundations = new ArrayList<List<Card>>(Arrays.asList(new ArrayList<Card>(),
            new ArrayList<Card>(), new ArrayList<Card>(), new ArrayList<Card>()));

  }

  @Override
  public List getDeck() {
    List<Card> deck = new ArrayList<Card>();
    for (Value i : Value.values()) {
      for (Suit j : Suit.values()) {
        Card c = new Card(i, j);
        deck.add(c);
      }
    }
    return deck;
  }

  /**
   * Check whether the deck contains duplicated cards.
   *
   * @param deck the given deck as a list of cards.
   * @return boolean that the deck has duplication or not.
   */

  private boolean duplication(List<Card> deck) {
    boolean temp = false;
    for (int k = 0; k < deck.size() - 1; k++) {
      for (int j = k + 1; j < deck.size(); j++) {
        if (deck.get(k).equals(deck.get(j))) {
          temp = true;
          break;
        }
      }
    }
    return temp;
  }


  /**
   * Create a Cascate pile.
   *
   * @param numPiles the number of cascades piles.
   * @param deck     the given deck as a list of cards.
   * @return a cascades which contains some piles.
   */
  private List<List<Card>> creatPile(int numPiles, List<Card> deck) {
    for (int i = 0; i < numPiles; i++) {
      List<Card> onePile = new ArrayList<Card>();
      for (int j = i; j < 52; j += numPiles) {
        onePile.add(deck.get(j));
      }
      cascades.add(onePile);
    }
    return cascades;
  }


  @Override
  public void startGame(List deck, int numCascadePiles, int numOpenPiles, boolean shuffle) {
    this.cascades = new ArrayList<>();
    this.opens = new ArrayList<>();
    this.foundations = new ArrayList<>(Arrays.asList(new ArrayList<Card>(), new ArrayList<Card>(),
            new ArrayList<Card>(), new ArrayList<Card>()));

    if (duplication(deck)) {
      throw new IllegalArgumentException("Invalid deck");
    }
    if (deck.size() != 52) {
      throw new IllegalArgumentException("Invalid size");
    }
    if (numCascadePiles < 4) {
      throw new IllegalArgumentException("Invalid parameter");
    }
    if (numOpenPiles < 1) {
      throw new IllegalArgumentException("Invalid parameter");
    }
    if (shuffle) {
      Collections.shuffle(deck);
    }
    creatPile(numCascadePiles, deck);
    for (int i = 0; i < numOpenPiles; i++) {
      opens.add(new ArrayList<Card>());
    }
  }


  /**
   * Put card into Foundation according to some limitations.
   *
   * @param destPileNumber the location which pile in the foundation.
   * @param c              a Card need to be put in.
   */

  private void putCardToFoun(int destPileNumber, Card c) {
    if (foundations.get(destPileNumber).size() == 0) {
      if (1 == c.getValue().getInt()) {
        foundations.get(destPileNumber).add(c);
      } else {
        throw new IllegalArgumentException("Invalid top value to Foundation Pile");
      }
    } else {
      int lastIndex = foundations.get(destPileNumber).size() - 1;
      Card lastCard = foundations.get(destPileNumber).get(lastIndex);

      if (lastCard.getSuit().equals(c.getSuit())) {
        if (lastCard.getValue().getInt() == (c.getValue().getInt() - 1)) {
          this.foundations.get(destPileNumber).add(c);
        } else {
          throw new IllegalArgumentException("Invalid value to move to Foundation Piles");
        }
      } else {
        throw new IllegalArgumentException("Invalid suit to move to Foundation Piles");
      }
    }
  }

  /**
   * Put card into Cascade according to some limitations.
   *
   * @param destPileNumber the location which pile in the Cascade.
   * @param c              a Card need to be put in.
   */

  private void putCardToCas(int destPileNumber, Card c) {
    if (cascades.get(destPileNumber).size() == 0) {
      cascades.get(destPileNumber).add(c);
    } else {
      int lastIndex = cascades.get(destPileNumber).size() - 1;
      Card lastCard = cascades.get(destPileNumber).get(lastIndex);

      if (lastCard.getValue().getInt() == c.getValue().getInt() + 1) {
        if (lastCard.getSuit().equals(Suit.CLUB) || lastCard.getSuit().equals(Suit.SPADE)) {
          if (c.getSuit().equals(Suit.DIAMOND) || c.getSuit().equals(Suit.HEART)) {
            cascades.get(destPileNumber).add(c);
          } else {
            throw new IllegalArgumentException("Invalid suit between last card and added card");
          }
        } else if (lastCard.getSuit().equals(Suit.DIAMOND)
                || lastCard.getSuit().equals(Suit.HEART)) {
          if (c.getSuit().equals(Suit.SPADE) || c.getSuit().equals(Suit.CLUB)) {
            cascades.get(destPileNumber).add(c);
          } else {
            throw new IllegalArgumentException("Invalid suit between last card and added card");
          }
        }
      } else {
        throw new IllegalArgumentException("Invalid value between last card and added card");
      }
    }
  }

  /**
   * check he when source is cascade is valid or not.
   *
   * @param pileNumber the number of piles.
   * @param cardIndex  the index of card.
   * @return Card use card Index to find in the pile.
   */
  private Card sourceCas(int pileNumber, int cardIndex) {
    Card c = null;
    if (pileNumber > (this.cascades.size() - 1)) {
      throw new IllegalArgumentException("Invalid pile number");
    } else if (this.cascades.get(pileNumber).size() == 0) {
      throw new IllegalArgumentException("Invalid movement from Cascade Pile.");
    } else if (cardIndex == (this.cascades.get(pileNumber).size() - 1)) {
      c = this.cascades.get(pileNumber).get(cardIndex);
      this.cascades.get(pileNumber).remove(cardIndex);
    } else {
      throw new IllegalArgumentException("Invalid cardIndex from Cascade Pile");
    }
    return c;
  }

  /**
   * check he when source is open is valid or not.
   *
   * @param pileNumber the number of piles.
   * @param cardIndex  the index of card.
   * @return Card use card Index to find in the pile.
   */
  private Card sourceOpen(int pileNumber, int cardIndex) {
    Card c = null;
    if (pileNumber > (this.opens.size() - 1)) {
      throw new IllegalArgumentException("Invalid pile number");
    }
    if (this.opens.get(pileNumber).size() == 0) {
      throw new IllegalArgumentException("Invalid movement from Open Pile.");
    } else if ((cardIndex == (this.opens.get(pileNumber).size() - 1))
            && (this.opens.get(pileNumber).size() == 1)) {
      c = this.opens.get(pileNumber).get(cardIndex);
      this.opens.get(pileNumber).remove(cardIndex);
    } else {
      throw new IllegalArgumentException("Invalid cardIndex from Open Pile");
    }
    return c;
  }

  /**
   * check he when source is foundation is valid or not.
   *
   * @param pileNumber the number of piles.
   * @param cardIndex  the index of card.
   * @return Card use card Index to find in the pile.
   */
  private Card sourceFoun(int pileNumber, int cardIndex) {
    Card c = null;
    if (pileNumber > 3) {
      throw new IllegalArgumentException("Invalid pile number");
    } else if (this.foundations.get(pileNumber).size() == 0) {
      throw new IllegalArgumentException("Invalid movement from Foundation Pile.");
    } else if (cardIndex == (this.foundations.get(pileNumber).size() - 1)) {
      c = this.foundations.get(pileNumber).get(cardIndex);
      this.foundations.get(pileNumber).remove(cardIndex);
    } else {
      throw new IllegalArgumentException("Invalid cardIndex from Foundations Pile");
    }
    return c;
  }

  /**
   * check the destination is valid or not.
   *
   * @param destination    the pile type of destination.
   * @param destPileNumber the number of destination pile.
   * @param c              the card which need to be moves.
   */
  private void checkDes(PileType destination, int destPileNumber, Card c) {
    if (destination.equals(PileType.OPEN)) {
      putCardToOpen(destPileNumber, c);
    } else if (destination.equals(PileType.FOUNDATION)) {
      putCardToFoun(destPileNumber, c);
    } else if (destination.equals(PileType.CASCADE)) {
      putCardToCas(destPileNumber, c);
    } else {
      throw new IllegalArgumentException("Invalid pileType");
    }
  }


  /**
   * Put card into Opens according to some limitations.
   *
   * @param destPileNumber the location which pile in the Open piles.
   * @param c              a Card need to be put in.
   */
  private void putCardToOpen(int destPileNumber, Card c) {
    if (opens.get(destPileNumber).size() == 0) {
      opens.get(destPileNumber).add(c);
    } else {
      throw new IllegalArgumentException("Invalid size of Open piles");
    }
  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex,
                   PileType destination, int destPileNumber) throws
          IllegalArgumentException {
    Card c;
    switch (source) {
      case CASCADE:
        c = sourceCas(pileNumber, cardIndex);
        checkDes(destination, destPileNumber, c);
        if (c == null) {
          throw new IllegalArgumentException("Invalid source.");
        }
        break;

      case FOUNDATION:
        c = sourceFoun(pileNumber, cardIndex);
        checkDes(destination, destPileNumber, c);
        if (c == null) {
          throw new IllegalArgumentException("Invalid source.");
        }
        break;


      case OPEN:

        c = sourceOpen(pileNumber, cardIndex);
        checkDes(destination, destPileNumber, c);
        if (c == null) {
          throw new IllegalArgumentException("Invalid source.");
        }
        break;

      default:
        throw new IllegalArgumentException("Invalid Piletype.");
    }


  }


  @Override
  public boolean isGameOver() {
    boolean result = true;
    for (int j = 0; j < opens.size(); j++) {
      if (this.opens.get(j).size() != 0) {
        result = false;
        break;
      }
    }

    for (int k = 0; k < opens.size(); k++) {
      if (this.cascades.get(k).size() != 0) {
        result = false;
        break;
      }
    }

    return result;
  }

  /**
   * Show the string type of cascade pile, open pile, or foundation pile.
   *
   * @param piletype the type of pile
   * @param s        The letter represents type of pile
   * @return String that contains all information from piletype.
   */

  private String stringState(List<List<Card>> piletype, String s) {
    String result = "";
    for (int i = 0; i < piletype.size(); i++) {
      if (s.equals("C")) {
        result = result + "C" + (i + 1) + ": ";
      } else if (s.equals("F")) {
        result = result + "F" + (i + 1) + ": ";
      } else {
        result = result + "O" + (i + 1) + ": ";
      }

      if (piletype.get(i).size() == 0) {
        result = result.substring(0, result.length() - 1) + "\n";
      } else {
        for (int j = 0; j < piletype.get(i).size(); j++) {
          if (j == piletype.get(i).size() - 1) {
            result = result + piletype.get(i).get(j).getValue().toString()
                    + piletype.get(i).get(j).getSuit().toString();
          } else {
            result = result + piletype.get(i).get(j).getValue().toString()
                    + piletype.get(i).get(j).getSuit().toString() + ", ";
          }
        }
        result = result + "\n";
      }
    }
    return result;
  }

  @Override
  public String getGameState() {
    String state = "";
    if (cascades.size() != 0 && opens.size() != 0 && foundations.size() != 0) {
      state = state + stringState(this.foundations, "F")
              + stringState(this.opens, "O") + stringState(this.cascades, "C");
      return state.substring(0, state.length() - 1);

    } else {
      return "";
    }
  }

}

import java.util.concurrent.ThreadLocalRandom;

public class AppTest {

  static int[][] gri;

  public static int entierAleatoire(int a, int b) {
    //Retourne un entier aléatoire entre a (inclus) et b (inclus)
    return ThreadLocalRandom.current().nextInt(a, b + 1);
  }

  public static void initialisegri() {
    gri = new int[6][7];
  }

  public static void jouer(int player, int colonne) {
    for (int i = 0; i < gri.length; i++) {
      if (gri[i][colonne] == 0) {
        gri[i][colonne] = player;
        break;
      }
    }
  }

  public static boolean aGagneHorTest(int x, int y, int player, int[][] gri) {
    int cmpt = 0;
    if (y <= 3/*&& y + 3 != gri[x].length - 1*/) {
      for (int i = y; i < gri[x].length; i++) {
        if (gri[x][i] == player) {
          cmpt++;
          if (cmpt == 4) {
            System.out.println();
            System.out.println(
              "Partie gangner par le joueure: " + player + " "
            );
            return true;
          }
          if (gri[x][i] == player + 1) {
            return false;
          }
          if (gri[x][i] == player - 1) {
            return false;
          }
        } else {
          return false;
        }
      }
    } else {
      return false;
    }
    return false;
  }

  public static boolean aGagneVer(int x, int y, int player) {
    int cmpt = 0;
    if (x < 4) {
      for (int i = x; i < gri.length; i++) {
        if (gri[i][y] == player) {
          cmpt++;
          if (cmpt == 4) {
            System.out.println();
            System.out.println(
              "Partie gangner par le joueure: " + player + " "
            );
            return true;
          }
        }
        if (cmpt > 0 && gri[i][y] == player + 1) {
          return false;
        }
        if (gri[i][y] == player - 1) {
          return false;
        }
        //System.out.println("player =" + player + " " + "compte " + cmpt);
      }
    }
    return false;
  }

  public static boolean aGagneDiagMontTest(
    int[][] gri,
    int x,
    int y,
    int player
  ) {
    int cmpt = 0;
    if (x >= 3 && y <= 3) {
      do {
        System.out.println("cmpt : " + cmpt + " " + "x,y : " + x + " , " + y);
        if (gri[x][y] == player) {
          cmpt++;
          x--;
          y++;
        } else if (gri[x][y] != player) {
          return false;
        }
      } while (cmpt != 4);

      return true;
    } else {
      return false;
    }
  }

  public static boolean aGagneDiagDescTest(    
  int[][] gri,
  int x,
  int y,
  int player
) {
  int cmpt = 0;
  if (x <= 2 && y <= 3) {
    do {
      System.out.println("cmpt : " + cmpt + " " + "x,y : " + x + " , " + y);
      if (gri[x][y] == player) {
        cmpt++;
        x++;
        y++;
      } else if (gri[x][y] != player) {
        return false;
      }
    } while (cmpt != 4);

    return true;
  } else {
    return false;
  }
}

  public static boolean matchNull() {
    for (int i = 0; i < gri.length; i++) {
      if (gri[5][i] == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] t = {
      { 0, 0, 0, 1, 0, 0, 0 },
      { 0, 0, 1, 0, 0, 0, 0 },
      { 0, 1, 0, 0, 0, 0, 0 },
      { 1, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 1, 0, 0, 0 },
      { 0, 0, 0, 1, 0, 0, 0 },
    };
    
  }
}

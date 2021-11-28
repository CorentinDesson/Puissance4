import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

  static int[][] grille;
  static Scanner sc = new Scanner(System.in);

  public static int entierAleatoire(int a, int b) {
    //Retourne un entier aléatoire entre a (inclus) et b (inclus)
    return ThreadLocalRandom.current().nextInt(a, b + 1);
  }

  public static void initialiseGrille() {
    grille = new int[6][7];
  }

  public static void jouer(int player, int colonne) {
    for (int i = 0; i < grille.length; i++) {
      if (grille[i][colonne] == 0) {
        grille[i][colonne] = player;
        break;
      }
    }
  }

  public static void affichage() {
    //Sur la grille
    for (int i = grille.length - 1; i >= 0; i--) {
      for (int j = grille[i].length - 1; j >= 0; j--) {
        if (grille[i][j] == 0) {
          System.out.print("|" + "  " + " ");
        } else if (grille[i][j] == 1) {
          System.out.print("|" + " X" + " ");
        } else if (grille[i][j] == 2) {
          System.out.print("|" + " O" + " ");
        }
      }
      System.out.println("|");
    }
    //Sous la grille
    for (int x = 0; x < grille[0].length; x++) {
      System.out.print("  " + (grille.length - x) + " ");
    }
  }

  ///////////////////////////////ligne//colonne/////////
  public static boolean aGagneHor(int x, int y, int player) {
    int cmpt = 0;
    if (y <= 3/*&& y + 3 != grille[x].length - 1*/) {
      for (int i = y; i < grille[x].length; i++) {
        if (grille[x][i] == player) {
          cmpt++;
          if (cmpt == 4) {
            System.out.println();
            System.out.println(
              "Partie gangner par le joueure: " + player + " "
            );
            return true;
          }
          if (grille[x][i] == player + 1) {
            return false;
          }
          if (grille[x][i] == player - 1) {
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
      for (int i = x; i < grille.length; i++) {
        if (grille[i][y] == player) {
          cmpt++;
          if (cmpt == 4) {
            System.out.println();
            System.out.println(
              "Partie gangner par le joueure: " + player + " "
            );
            return true;
          }
        }
        if (cmpt > 0 && grille[i][y] == player + 1) {
          return false;
        }
        if (grille[i][y] == player - 1) {
          return false;
        }
        //System.out.println("player =" + player + " " + "compte " + cmpt);
      }
    }
    return false;
  }

  public static boolean aGagneDiagMont(int x, int y, int player) {
    int cmpt = 0;
    if (x >= 3 && y <= 3) {
      do {
        if (grille[x][y] == player) {
          cmpt++;
          x--;
          y++;
        } else if (grille[x][y] != player) {
          return false;
        }
      } while (cmpt != 4);

      return true;
    }
    return false;
  }

  public static boolean aGagneDiagDesc(int x, int y, int player) {
    return false;
  }

  public static boolean matchNull() {
    for (int i = 0; i < grille.length; i++) {
      if (grille[5][i] == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean aGagner(int player) {
    for (int i = 0; i < grille.length; i++) {
      for (int j = 0; j < grille[i].length; j++) {
        if (aGagneHor(i, j, player) == true) {
          return true;
        } else if (aGagneVer(i, j, player) == true) {
          return true;
        } else if (aGagneDiagMont(i, j, player) == true) {
          return true;
        } else if (aGagneDiagDesc(i, j, player) == true) {
          return true;
        }
      }
    }
    return false;
  }

  public static int jouecoupRandom() {
    int p1 = -1;
    do {
      p1 = entierAleatoire(0, 6);
      if (grille[5][p1] == 0) {
        return p1;
      } else {
        System.out.println("Colonne pleinne réessayer ");
        p1 = -1;
      }
    } while (p1 == -1);
    return p1;
  }

  public static int selecColum() {
    return selecColumGri(grille);
  }

  public static int selecColumGri(int[][] gri) {
    int p1 = -1;
    do {
      p1 = sc.nextInt();
      if (gri[5][p1] == 0) {
        return p1;
      } else if (p1 > 6 || p1 < 0) {
        System.out.println("Colonne inexistante, réessayer !");
        p1 = -1;
      } else if (gri[5][p1] != 0) {
        System.out.println("Colonne pleinne réessayer !");
        p1 = -1;
      }
    } while (p1 == -1);
    return -1;
  }

  public static void main(String[] args) {
    initialiseGrille();
    do {
      affichage();
      System.out.println(" ");
      System.out.println("Tour du Player 1 ");

      jouer(1, selecColum());
      //jouer(1, jouecoupRandom());
      affichage();
      if (aGagner(1) == true || matchNull() == true) {
        break;
      }
      System.out.println(" ");

      System.out.println("Tour du Player 2 ");
      //jouer(2, jouecoupRandom());
      jouer(2, selecColum());
      affichage();
      if (aGagner(2) == true || matchNull() == true) {
        break;
      }
      System.out.println(" ");
    } while ((!aGagner(1) && !aGagner(2)));
    System.out.println();
    System.out.println("Partie Fini");
    sc.close();
  }
}

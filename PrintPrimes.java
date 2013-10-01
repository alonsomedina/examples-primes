public class PrintPrimes {
  int numbOfPrimes;
  int numOfRows;
  int numOfColumns;
  int ORDMAX;
  int listOfPrimes[];

  public PrintPrimes(int numbOfPrimes, int numOfRows, int numOfColumns, int ORDMAX) {
    this.numbOfPrimes   = numbOfPrimes;
    this.numOfRows  = numOfRows;
    this.numOfColumns  = numOfColumns;
    this.ORDMAX = ORDMAX;
    this.listOfPrimes = new int[numbOfPrimes + 1];
  }


  public static void main(String[] args) {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4, 30);
      printPrimes.calculatePrimes();
      printPrimes.printPrimes();
  }

  public void calculatePrimes() {
      /* Two is the only even prime. All other prime numbers are odd.
       * To simplify the code, we simply add 2 as a prime number, and
       * delegate the task of finding all odd prime numbers to a helper
       * function.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  private void calculateOddPrimes() {
      boolean JPRIME;
      int N;
      int MULT[] = new int[ORDMAX + 1];

      int J = 1;
      int ORD = 2;
      int SQUARE = 9;

      for(int primesFoundSoFar = 1; primesFoundSoFar <= numbOfPrimes; primesFoundSoFar++) {
        while (!JPRIME) {
          J = J + 2;
          if (J == SQUARE) {
            ORD = ORD + 1;
            SQUARE = listOfPrimes[ORD] * listOfPrimes[ORD];
            MULT[ORD - 1] = J;
          }
          N = 2;
          JPRIME = true;
          while (N < ORD && JPRIME) {
            while (MULT[N] < J)
              MULT[N] = MULT[N] + listOfPrimes[N] + listOfPrimes[N];
            if (MULT[N] == J)
              JPRIME = false;
            N = N + 1;
          }
        }
        listOfPrimes[primesFoundSoFar] = J;
      }
    }

    public void printPrimes() {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numbOfPrimes) {
          System.out.println("The First " + numbOfPrimes +
                               " Prime Numbers --- Page " + pageNumber);
          System.out.println("");
          for (int ROWOFFSET = pageOffset; ROWOFFSET < pageOffset + numOfRows; ROWOFFSET++){
            for (int C = 0; C < numOfColumns;C++)
              if (ROWOFFSET + C * numOfRows <= numbOfPrimes)
                System.out.format("%10d", listOfPrimes[ROWOFFSET + C * numOfRows]);
            System.out.println("");
          }
          System.out.println("\f");
          pageNumber = pageNumber + 1;
          pageOffset = pageOffset + numOfRows * numOfColumns;
        }
    }
}

					 

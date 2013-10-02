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
      /* 
       * Add only even prime number 2 to our list, then use helper function
       * calculateOddPrimes() to find the rest of the prime numbers.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  private void calculateOddPrimes() {
      boolean isPrime;
      int N;
      int listOfMultiples[] = new int[ORDMAX + 1];
      int primeCandidate = 1;
      int ORD = 2;
      int SQUARE = 9;

      //i represents the number of prime numbers found so far
      for(int i = 1; i <= numbOfPrimes; i++) {
        while (!isPrime) {
          primeCandidate = primeCandidate + 2;
          if (primeCandidate == SQUARE) {
            ORD = ORD + 1;
            SQUARE = listOfPrimes[ORD] * listOfPrimes[ORD];
            listOfMultiples[ORD - 1] = primeCandidate;
          }
          N = 2;
          isPrime = true;
          while (N < ORD && isPrime) {
            while (listOfMultiples[N] < primeCandidate) {
              listOfMultiples[N] = listOfMultiples[N] + listOfPrimes[N] + listOfPrimes[N];
            }
            if (listOfMultiples[N] == primeCandidate) {
              isPrime = false;
            }
            N = N + 1;
          }
        }
        listOfPrimes[i] = primeCandidate;
      }
    }

    public void printPrimes() {
        int pageNumber = 1;
        int pageOffset = 1;
        
        while (pageOffset <= numbOfPrimes) {
          System.out.println("The First " + numbOfPrimes +
                             " Prime Numbers --- Page " + pageNumber);
          System.out.println("");
          //i represents the row offset
          for (int i = pageOffset; i < pageOffset + numOfRows; i++) {
            //j represents the column offset
            for (int j = 0; j < numOfColumns; j++) {
              if (i + j * numOfRows <= numbOfPrimes) {
                System.out.format("%10d", listOfPrimes[i + j * numOfRows]);
              }
            }
            System.out.println("");
          }
          System.out.println("\f");
          pageNumber = pageNumber + 1;
          pageOffset = pageOffset + numOfRows * numOfColumns;
        }
    }
}

					 

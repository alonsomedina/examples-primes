public class PrintPrimes {
	
  int numbOfPrimes;
  int numOfRows;
  int numOfColumns;
  int maxRefPoints;
  int listOfPrimes[];

  public PrintPrimes(int numbOfPrimes, int numOfRows, int numOfColumns, int maxRefPoints) {
    this.numbOfPrimes   = numbOfPrimes;
    this.numOfRows  = numOfRows;
    this.numOfColumns  = numOfColumns;
    this.maxRefPoints = maxRefPoints;
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
      int counter;
      int listOfMultiples[] = new int[maxRefPoints + 1];
      int primeCandidate = 1;
      int currentRefPoint = 2;
      int square = 9;

      //i represents the number of prime numbers found so far
      for(int i = 1; i <= numbOfPrimes; i++) {
      	/*
      	 *this do-while loop should stylistically be changed into a while loop, however the code 
      	 *does not function properly in a while-loop and the changed was therefore reverted
      	 */
        do {
          primeCandidate = primeCandidate + 2;
          //if our candidate prime number is a square then move on to next reference number and update the square
          if (primeCandidate == square) {
            currentRefPoint++;
            square = listOfPrimes[currentRefPoint] * listOfPrimes[currentRefPoint];
            listOfMultiples[currentRefPoint - 1] = primeCandidate;
          }
          counter = 2;
          isPrime = true;
          
          while (counter < currentRefPoint && isPrime) {
            while (listOfMultiples[counter] < primeCandidate) {
              listOfMultiples[counter] = listOfMultiples[counter] + 2 * listOfPrimes[counter];
            }
            if (listOfMultiples[counter] == primeCandidate) {
              isPrime = false;
            }
            counter++;
          }
        } while (!isPrime) 
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

					 

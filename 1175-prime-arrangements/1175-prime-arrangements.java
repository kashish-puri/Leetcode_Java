class Solution {

    int mod = 1000000007;
    int N = 101;
    int[] prime = new int[N];

    public void sieve() {
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;

        for (int i = 2; i * i < N; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j < N; j += i) {
                    prime[j] = 0;
                }
            }
        }
    }

    public int numPrimeArrangements(int n) {

        sieve();

        int primeCount = 0;

        for (int i = 2; i <= n; i++) {
            if (prime[i] == 1) {
                primeCount++;
            }
        }

        int nonPrime = n - primeCount;

        long primeFact = 1;
        for (int i = 1; i <= primeCount; i++) {
            primeFact = (primeFact * i) % mod;
        }

        long nonPrimeFact = 1;
        for (int i = 1; i <= nonPrime; i++) {
            nonPrimeFact = (nonPrimeFact * i) % mod;
        }

        return (int) ((primeFact * nonPrimeFact) % mod);
    }
}
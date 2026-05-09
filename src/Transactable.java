public interface Transactable {
    void deposit(double amount) throws InvalidAmountException;
    void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException;

    class InvalidAmountException extends Exception {
        public InvalidAmountException(String e) {
            super(e);

        }
    }

    class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String e) {
            super(e);
        }
    }
}

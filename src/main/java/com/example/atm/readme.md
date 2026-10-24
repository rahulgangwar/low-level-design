# ATM LLD

## Functional Requirements
Support the following workflow
1. Insert the ATM card
2. Authenticate PIN
3. Check balance
4. Enter cash to withdraw
5. Withdraw if balance is sufficient else Decline 
6. Eject the ATM card

## Core Entities
1. ATM
    - insertCard
    - enterPin
    - checkBalance
    - withdraw
    - ejectCard
2. ATMState 
    - insertCard
    - enterPin
    - checkBalance
    - withdraw
    - ejectCard
3. IdleState : 
   - insertCard
4. CardInsertedState
   - enterPin
5. AuthenticatedState
   - checkBalance
   - withdraw
3. BankService
   - credit
   - debit

## Sample Output of execution
```text
Card inserted. Please enter PIN.
PIN is authenticated
Balance: 1000
Trying to debit: 100
Amount received:100. Balance:900
Card Ejected
```


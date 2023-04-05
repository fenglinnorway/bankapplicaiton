Feature: Bank Account Management

As a bank customer
I want to manage my bank account and perform various transactions
So that I can send, receive money and track my account activity securely and easily

Scenario: Successful money transfer between two accounts
Given valid account details and positive funds available
When account-id AB1234567890 sends 10 to account-id DE1234567890
Then account-id AB1234567890 account should be debited with 10
And account-id DE1234567890 account should be credited with 10

# Scenario: Transfer to an invalid account
# Given invalid receiver account details and positive funds available
# When account-id AB1234567890 sends 10 to account-id 999
# Then system should reject the transfer and report invalid account details

# Scenario: Transfer with insufficient funds
# Given valid account details and no funds available
# When account-id AB1234567890 sends 10 to account-id 222
# Then system should reject the transfer with error Insufficient funds available

# Scenario: Check account balance with valid account details
# Given valid account details
# When I call a service to check my account balance
# Then system should be able to report my current balance

# Scenario: Retrieve mini statement with valid account details
# Given valid account details
# When I call mini statement service
# Then system should be able to show me last 20 transactions

# Scenario: Check account balance with invalid account details
# Given invalid account details
# When I call a service to check my account balance with account-id AB1234567890
# Then system should return error saying invalid account number

# Scenario: Retrieve mini statement with invalid account details
# Given invalid account details
# When I call mini statement service with account-id AB1234567890
# Then system should return error saying invalid account number
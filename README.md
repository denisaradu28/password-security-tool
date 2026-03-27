# password-security-tool
A simple Java CLI application that evaluates password strength and generates secure SHA-256 hashes.

---

## Project Overview

This project is a command-line tool that helps users:
- check the strength of a password based on common security criteria
- generate a SHA-256 hash of a password
- receive feedback on how to improve password security

The goal of this project is to demonstrate basic cybersecurity concepts such as password validation and hashing.

---

## Features

-  Password strength evaluation (Weak / Medium / Strong)
-  Detailed feedback for improving password security
-  SHA-256 hashing for secure password storage
-  Interactive command-line interface (CLI)

---

## Password Strength Criteria

The application checks if the password contains:

- Minimum 8 characters
- Uppercase letters
- Lowercase letters
- Digits
- Special characters
- Bonus score for length ≥ 12 characters

---

## Hashing

The application uses **SHA-256** to hash passwords:

- Converts passwords into a secure fixed-length string
- Ensures sensitive data is not stored in plain text

---

## Technologies Used

- Java
- CLI (Command Line Interface)
- `MessageDigest` (for SHA-256 hashing)

---

## Project Structure

```text
password-security-tool/
├── src/
│   └── PasswordTool.java
├── README.md
```

## How to Run

1. Compile the program
```bash
javac src/PasswordTool.java
```
2. Run the application
```bash 
java -cp src PasswordTool
```

## Example Usage
```bash
Password Strength and Hashing Tool 

1. Check password strength
2. Hash a password
3. Check strength and hash password
0. Exit

Choose an option: 3
Enter password: Parola123!

Password strength: Strong
- Your password meets the main security criteria.
SHA-256 hash: 1b1e6b...
```

## Concepts Learned
- Password security and validation
- Cryptographic hashing (SHA-256)
- Java string processing
- Input handling with Scanner
- CLI application design
- Clean code and modular structure

## Future Improvements
- Add salting for stronger hashing
- Detect common weak passwords (e.g., "123456", "password")
- Save hashed passwords to a file
- Add graphical interface (Swing / JavaFX) 

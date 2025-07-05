# JAVA-PROGRAMMING-TASK

*COMPANY*: CODTECH IT SOLUTIONS PVT. LTD  
*NAME*: PREM ANANDRAO SAWANT  
*INTERN ID*: CT04DH1720  
*DOMAIN*: JAVA PROGRAMMING  
*DURATION*: 4 WEEKS (5th July 2025 to 5th August 2025)  
*MENTOR*: NEELA SANTHOSH


📌 Task 1: File Handling – TodoListManager Application
📝 Description of the Task:
This task involved building a console-based To-Do List Manager in Java using the file handling mechanism. The goal was to create a lightweight personal task tracker that allows users to:

View all tasks

Add new tasks

Mark tasks as completed

All data persistence is handled via a simple text file (todo.txt) stored locally. The application simulates a very basic yet effective version of a productivity tool using core Java features.

💡 What I Learned:
This task helped me significantly improve my understanding of:

Java I/O Streams like FileReader, BufferedReader, FileWriter, and BufferedWriter

RandomAccessFile to check the last character for newline handling

Working with Lists, Strings, and Regex in Java

How to implement simple CLI-based applications

Structuring methods and splitting concerns cleanly using functions

Additionally, I improved my error handling, user input validation, and the ability to maintain clean logic for real-world features like marking items completed.

🛠 Technologies Used:
Java (JDK 8 or above)

File I/O (java.io)

Collections Framework (ArrayList)

Exception Handling

Scanner class for user interaction

🔍 Features Implemented:
Persistent Task Storage: All tasks are stored in a plain text file (todo.txt)

Add Task: Users can enter any task which gets added to the file

View Tasks: Displays the current list with index numbers

Mark as Completed: Replaces [ ] with [x] to show task status

Input Validation: Prevents errors like invalid selections or malformed input

Dynamic File Creation: Creates todo.txt if not present

🧠 Code Explanation:
The application begins with a continuous loop in the main() method offering the user four choices:

View tasks

Add tasks

Mark tasks as completed

Exit

Each choice calls its own method:

viewTasks() reads the file and prints the tasks with line numbers.

addTask() appends a task to the file. It also checks if the previous task ended with a newline using RandomAccessFile to prevent formatting issues.

markTaskCompleted() updates a specific line in the file by replacing [ ] with [x]. It uses regex to ensure the update happens only once.

File reading and writing are handled with BufferedReader and BufferedWriter for efficiency and stability.

Error handling is in place for scenarios like:

No file found

Invalid input

Number format exceptions

Empty task list

All methods are modular, which ensures that the logic is readable, maintainable, and scalable.

⚠️ Challenges Faced:
One of the trickiest parts was ensuring that tasks appended to the file always appear on a new line. I used RandomAccessFile to check whether the last character of the file was a newline, which is not commonly handled in beginner-level file programs.

Another challenge was maintaining the integrity of data while marking a task as completed. Instead of rewriting the file line-by-line manually, I opted to load tasks into a list, modify it in memory, and then rewrite the entire file.

🚀 How to Run the Code:
Open any Java IDE (e.g., IntelliJ, Eclipse, or VS Code).

Create a file named TodoListManager.java and paste the code.

Compile and run the program.

A file named todo.txt will be created in the working directory if it doesn't exist.

Follow the on-screen menu to interact.

📦 Sample Output:
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/a64d2fa7-d1a4-446e-aa26-27e864244b2d" />
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/71a04e02-6b01-4f98-a2ba-cf912bdf82e1" />

Example task view:



Implement GUI using Java Swing or JavaFX

Enable deletion of tasks

Use JSON or database for structured storage

✅ Conclusion:
This task was a hands-on introduction to Java file handling, which is a core skill in backend and system-level programming. It strengthened my ability to work with file streams, manage user interaction, and structure a real-world mini-project with best practices. This small but functional project helped bridge theory and real implementation.

I now feel more confident in using Java to build console apps and manage persistent data.

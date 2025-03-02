import java.util.Scanner;

public class Chatbot {

    //SHIVAM YADAV CHATBOT
    public static String getResponse(String userInput) {
      
        userInput = userInput.toLowerCase();

        if (userInput.contains("hi") || userInput.contains("hello")) {
            return "Hello! How can I help you today?";
        } else if (userInput.contains("how are you")) {
            return "I'm just a chatbot, but I'm doing fine, thanks for asking!";
        } else if (userInput.contains("bye")) {
            return "Goodbye! Have a great day!";
        } else if (userInput.contains("your name")) {
            return "I am a simple AI chatbot created in Java.";
        } else if (userInput.contains("help")) {
            return "I can assist you with basic conversations. Just ask me about my name or how I'm doing!";
        } else {
            return "Sorry, I didn't understand that. Can you ask something else?";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chatbot: Hello, I am your friendly chatbot! Type 'bye' to exit.");
        String userInput;

       
        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine(); 
            if (userInput.toLowerCase().equals("bye")) {
                System.out.println("Chatbot: " + getResponse(userInput));
                break;
            }

           
            String response = getResponse(userInput);
            System.out.println("Chatbot: " + response);
        }

        scanner.close();
    }
}

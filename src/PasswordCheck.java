import java.util.Scanner;

public class PasswordCheck {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter a password\nIt must be between 8-16 characters and meet three of these of these requirements:\n-Lowercase letters\n-Uppercase letters\n-Numbers\n -Any of these special characters: ~!@#$%^&*()-=+_");
        String pass = scnr.nextLine(); //Gets the password from the user

        Boolean num = false; //Establishes boolean variables to track the four possible conditions the password must meet
        Boolean lower = false;
        Boolean upper = false;
        Boolean special = false;
        
        if(pass.length() >= 8 && pass.length() <= 16){ //Checks if the password meets the length requirement
            int reqs = 0; //Establishes a variable to track the requirements met
            char[] letters = new char[pass.length()]; //Creates an array the length of the password string
            for (int i = 0; i < pass.length(); i++){ //Separates each letter into an individual char in an array
                letters[i] = pass.charAt(i);
            }

            for(int i = 0; i < letters.length; i++){ //Loops through the array 
                if(Character.isDigit(letters[i])){ //Checks if the current character is a number and changes num to true if yes
                    num = true;
                    continue;
                }
                if(Character.isLetter(letters[i])){ //Checks if the current character is a letter and begins further checks if yes
                    if(Character.isUpperCase(letters[i])){ //Checks if the letter is uppercase, if yes then upper is set to true
                        upper = true;
                        continue;
                    }
                    if(Character.isLowerCase(letters[i])){ //Checks if the letter is lowercase, if yes then lower is set to true
                        lower = true;
                        continue;
                    }
                continue;
                }
            } //If statement checks if the password string contains any of the possible special characters
            if(pass.contains("~") || pass.contains("!") || pass.contains("@") || pass.contains("#") || pass.contains("$") || pass.contains("%") || pass.contains("^") || pass.contains("&") || pass.contains("*") || pass.contains("(") || pass.contains(")") || pass.contains("-") || pass.contains("=") || pass.contains("+") || pass.contains("_")){
                special = true;
            }

            if(special == true){ //A series of if statements that add to the requirement counter if they were triggered
                reqs++;
            }
            if(num == true){
                reqs++;
            }
            if(upper == true){
                reqs++;
            }
            if(lower == true){
                reqs++;
            }

            if(reqs >= 3){ //If three out of the four requirements were triggered, the user gets a message letting them know their password meets the requirements
                System.out.println("Your password meets the requirements!");
            }else{ //If else, a message is printed showing the user which requirements they met and which they missed
                System.out.println("You don't meet at least three of the requirements:\nNumber: " + num + "\nUppercase: " + upper + "\nLowercase: " + lower + "\nSpecial character: " + special);
            }

        }else{ //Prints a warning to the user is the length requirement is not meant
            System.out.println("Your password is not between 8-16 characters long!");
        }
    }
}

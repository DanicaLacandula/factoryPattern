package factoryPattern;

import java.util.Scanner;

public class Clinic {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            // Menu
            System.out.println("\n=== Pet Clinic Menu ===");
            System.out.println("[1] Dog");
            System.out.println("[2] Cat");
            System.out.println("[3] Exit");
            System.out.print("Choose your pet number: ");
            choice = input.nextInt();

            if (choice == 3) {
                System.out.println("Exiting the clinic. Goodbye!");
                break;
            }

            PetRecord petFile = new PetRecord();
            Pet pet;

            switch (choice) {
                case 1:
                    pet = new Dog();
                    petFile.setPetId("D01");
                    petFile.setPetName("Bantay");
                    petFile.setPet(pet);
                    ((Dog) pet).setBreed("German Shepherd");
                    break;
                case 2:
                    pet = new Cat();
                    petFile.setPetId("C01");
                    petFile.setPetName("Muning");
                    petFile.setPet(pet);
                    ((Cat) pet).setNoOfLives(9);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue; // Go back to the menu
            }

            // Display pet details
            System.out.println("\n--- Pet Details ---");
            System.out.println("Pet ID: " + petFile.getPetId());
            System.out.println("Pet Name: " + petFile.getPetName());
            System.out.println("Pet Kind: " + petFile.getPet().getClass().getSimpleName());
            System.out.println("Communication Sound: " + petFile.getPet().makeSound());
            System.out.println("Play Mode: " + petFile.getPet().play());

            // Display extra info depending on pet type
            if (petFile.getPet() instanceof Dog) {
                System.out.println("Breed: " + ((Dog) petFile.getPet()).getBreed());
            } else if (petFile.getPet() instanceof Cat) {
                System.out.println("Number of Lives: " + ((Cat) petFile.getPet()).getNoOfLives());
            }

        } while (choice != 3);

        input.close();
    }
}

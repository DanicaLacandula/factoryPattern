package factoryPattern;

import java.util.Scanner;

public class Clinic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
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
            Pet pet = null;

            switch (choice) {
                case 1 -> {
                    pet = new Dog();
                    petFile.setPetId("D01");
                    petFile.setPetName("Bantay");
                    petFile.setPet(pet);
                    ((Dog) pet).setBreed("German Shepherd");
                }
                case 2 -> {
                    pet = new Cat();
                    petFile.setPetId("C01");
                    petFile.setPetName("Muning");
                    petFile.setPet(pet);
                    ((Cat) pet).setNoOfLives(9);
                }
                default -> {
                    System.out.println("Invalid choice! Please try again.");
                    continue;
                }
            }

            System.out.println("\n--- Pet Details ---");
            System.out.printf("Pet ID: %s%n", petFile.getPetId());
            System.out.printf("Pet Name: %s%n", petFile.getPetName());
            System.out.printf("Pet Kind: %s%n", petFile.getPet().getClass().getSimpleName());
            System.out.printf("Communication Sound: %s%n", petFile.getPet().makeSound());
            System.out.printf("Play Mode: %s%n", petFile.getPet().play());

            if (pet instanceof Dog dog) {
                System.out.printf("Breed: %s%n", dog.getBreed());
            } else if (pet instanceof Cat cat) {
                System.out.printf("Number of Lives: %d%n", cat.getNoOfLives());
            }
        }

        input.close();
    }
}

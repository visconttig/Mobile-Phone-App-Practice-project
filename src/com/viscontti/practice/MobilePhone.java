package com.viscontti.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    ArrayList<Contacts>  arrayContact = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void printOptions(){
        int selectedOption;
        do {
                System.out.println("\n\nOPTIONS: \n0 - Quit\n1 - Print list of contacts" +
                    "\n2 - Add new contact\n3 - Update\n4 - Remove\n5 - Search");
            System.out.println("Enter an option: ");
            selectedOption = scanner.nextInt();

            switch (selectedOption){
                case 0:
                    System.out.println("***EXIT***");
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchContact();
                    break;
            }
        } while (selectedOption != 0);
    }

    public void addContact(){
        try {
        //    scanner = new Scanner(System.in);
            cleanScanner();
            System.out.println("Write the name: ");
            String name = scanner.nextLine();
            System.out.println("Write the number: ");
            int number = scanner.nextInt();
            arrayContact.add(new Contacts(name, number));


        } catch (Exception e){
           System.err.println( "EXCEPTION:" + e.getMessage());
        }

    }

    public void printContacts(){
        if (arrayContact.size() > 0){
            System.out.println("\nSaved contacts: ");
            for (int i = 0 ; i <= arrayContact.size() -1; i++){
                System.out.println("\n***********");
                System.out.println("Name: " + arrayContact.get(i).getName());
                System.out.println("Number: " + arrayContact.get(i).getNumber());
            }

            System.out.println("\n");
        } else {
            System.out.println("\nThere aren't records.");
        }

    }

    public void searchContact(){
        try {
            cleanScanner();
            System.out.println("Write the name to look for: ");
            String name = scanner.nextLine();
            int j = searchInternal(name);
            if (j != -1){
                System.out.println("\nResult:\nName: " +
                        arrayContact.get(j).getName() +
                        "\nNumber: " + arrayContact.get(j).getNumber());
            } else {
                System.out.println("\nThe contact does not exist.");
            }
        }catch (Exception e){
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }

    public boolean deleteContact(){  // returns true if contact was deleted.
        cleanScanner();
        System.out.println("\nWrite the name of the contact to delete: ");
        String name = scanner.nextLine();
        int index = searchInternal(name);
        if (index != -1){
            System.out.println("\nDeleted contact: " + arrayContact.get(index).getName());
            arrayContact.remove(index);
            return true;
        } else {
            System.out.println("\nThe contact does not exist - No contacts were deleted.");
            return false;
        }
    }

    public boolean updateContact(){    // return true if the contact was updated.
        boolean updated;
        cleanScanner();
        System.out.println("\nWrite the name of the contact to update: ");
        String name = scanner.nextLine();
        int position = searchInternal(name);
        if (position != -1){
            System.out.println("\nWrite '1' to update the name" +
                    " and '2' to update the number: ");
            int selectedOption = scanner.nextInt();
            switch (selectedOption){
                case 1:
                    cleanScanner();
                    System.out.println("\nWrite the new name: ");
                    String newName = scanner.nextLine();
                    arrayContact.get(position).setName(newName);
                    System.out.println("\nContact updated.\nName: " + arrayContact.get(position).getName()
                            + " - Number: " + arrayContact.get(position).getNumber());
                    break;
                case 2:
                    System.out.println("\nWrite the new number: ");
                    int newNumber = scanner.nextInt();
                    arrayContact.get(position).setNumber(newNumber);
                    System.out.println("\nContact updated.\nName: " + arrayContact.get(position).getName()
                            + " - Number: " + arrayContact.get(position).getNumber());
                    break;
            }

            updated = true;
        } else {
            System.out.println("\nThe contact " + name + " does not exist in the records.");
            updated = false;
        }

        return updated;
    }

    private int searchInternal(String name){
        int position = -1;
        for (Contacts c : arrayContact){
            if (c.getName().equals(name)){
                position = arrayContact.indexOf(c);
            }
        }
        return position;
    }

    private void cleanScanner(){
        scanner.nextLine();
    }


}

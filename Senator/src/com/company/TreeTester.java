package com.company;

import java.util.Scanner;

public class TreeTester
{
    public static void main ( String [] args )
    {
        TreeTester order = new TreeTester();
        order.mainMenu();
    }

    public void mainMenu ()
    {
        BinarySearchTree bst = new BinarySearchTree();

        String choice;
        Scanner console = new Scanner(System.in);

        System.out.println("\n\n");
        do
        {
            System.out.println("\nBinary Search Tree algorithm menu\n");
            System.out.println("(1) Read data from file");
            System.out.println("(2) Print list ordered by name");
            System.out.println("(3) Search list");
            System.out.println("(4) Delete from list");
            System.out.println("(5) Clear entire list");
            System.out.println("(6) Count nodes in list");
            System.out.println("(Q) Quit\n");
            do
            {
                System.out.print("Choice ---> ");
                choice = console.nextLine() + " ";
                System.out.println();
            }
            while((choice.charAt(0) < '1' || choice.charAt(0) > '6') &&
                    (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q'));

            if ('1' <= choice.charAt(0) && choice.charAt(0) <= '6')
            {
                switch (choice.charAt(0))
                {
                    case '1' :
                        bst.loadData(Prompt.getString("What's the file name?"));
                        break;
                    case '2' :
                        System.out.println();
                        System.out.println("The list printed in order by year\n");
                        testPrintList(bst);
                        System.out.println();
                        break;
                    case '3' :
                        testFind(bst);
                        break;
                    case '4' :
                        testDelete(bst);
                        break;
                    case '5' :
                        bst.clear();
                        break;
                    case '6' :
                        System.out.println("Number of nodes = " + bst.size());
                        System.out.println();
                        break;
                }
            }
        }
        while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
    }

    public void testDelete(BinarySearchTree list){
        boolean quit = false;
        while(!quit){
            String name = Prompt.getString("Enter a Senator's name to delete (Q to quit): ");
            if(!name.equalsIgnoreCase("q")){
                boolean isDeleted = list.deleteSenator(name);
                if(isDeleted){
                    System.out.print("\n"+ name + " was deleted.\n\n");
                } else{
                    System.out.print("\n" + name + " could not be found, so was not deleted.\n\n");
                }
            } else {
                quit = true;
            }
        }
    }

    public void testFind(BinarySearchTree list){
        boolean quit = false;
        while(!quit){
            String name = Prompt.getString("Enter a Senator's name to be searched (Q to quit): ");
            if(!name.equalsIgnoreCase("q")){
                Object senator = list.findSenator(name);
                if(senator != null){
                    System.out.print("\n" + (Senator)senator + "\n\n");
                } else{
                    System.out.print("\n" + name + " could not be found.\n\n");
                }
            } else {
                quit = true;
            }
        }
    }

    void testPrintList(BinarySearchTree bst){
        bst.printList(bst.getFirst());
    }
}


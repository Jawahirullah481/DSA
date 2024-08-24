import datastructure.linkedlist.dsa.DLL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.

            DLL list = new DLL();
            list.addFirst(3);
            list.addFirst(2);
            list.addFirst(8);
            list.addFirst(17);
            list.addLast(99);
            list.add(65, 8);
            list.display();
            System.out.println();
            list.displayReverse();
    }
}
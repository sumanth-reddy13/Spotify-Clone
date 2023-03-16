import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // created a Album object 1.
        Album album1 = new Album("Rocks", "Thaman");
        album1.addSongToAlbum(new Song("Boss", 3.4));
        album1.addSongToAlbum(new Song("King", 3.56));
        album1.addSongToAlbum(new Song("cat", 4.5));

        // created a Album object 2
        Album album2 = new Album("Shakes", "DSP");
        album2.addSongToAlbum(new Song("meow", 5.3));
        album2.addSongToAlbum(new Song("fasak", 3.90));
        album2.addSongToAlbum(new Song("jimpak", 4.30));

        // A playList to store my favorite songs from various albums.
        LinkedList<Song> myPlayList = new LinkedList<>();

        album1.addSongToPlayList(1, myPlayList);
        album1.addSongToPlayList("King", myPlayList);
        album2.addSongToPlayList(3, myPlayList);
        album2.addSongToPlayList("meow", myPlayList);

        play(myPlayList);
    }

    public static void play(LinkedList<Song> myPlayList) {
        ListIterator<Song> itr = myPlayList.listIterator();
        Scanner sc = new Scanner(System.in);
        boolean isForward = false;

        if (myPlayList.size() > 0) {
            System.out.print("Currently playing : ");
            System.out.println(itr.next());
            isForward = true;
        }
        else {
            System.out.println("Your playList is empty. Add some songs to it.");
            return;
        }

        printMenu();
        boolean quit = false;

        while (!quit) {
            System.out.println("Select your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (isForward == false) {
                        itr.next();
                        isForward = true;
                    }
                    if (itr.hasNext()) {
                        System.out.println("Currently Playing " + itr.next());

                    }
                    else {
                        System.out.println("You are at the end");
                        isForward = false;
                    }
                    break;
                case 2:
                    if (isForward == true) {
                        itr.previous();
                        isForward = false;
                    }
                    if (itr.hasPrevious() ) {
                        System.out.println("Currently Playing " + itr.previous());
                    }
                    else {
                        System.out.println("You are at the start");
                        isForward = true;
                    }
                    break;
                case 3:
                    if(isForward == true) {
                        if (itr.hasPrevious()) {
                            System.out.println("Currently playing " + itr.previous());
                            isForward = false;
                        }
                    }
                    else {
                        if (itr.hasNext()) {
                            System.out.println("Currently playing " + itr.next());
                            isForward = true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                 /*
                      previousIndex: This method returns the index of the element that would be returned on calling the previous() method.
                      nextIndex: This method returns the index of the element that would be returned on calling the next() method.
                      remove: This method removes the last element from the list that was returned on calling next() or previous() method element from.
                 */
                case 5:
                    if (isForward == true) {
                        if (itr.previousIndex() > 0) {
                            itr.remove();
                        }
                        else {
                            System.out.println("You are at the start");
                        }
                    }
                    else {
                        if (itr.nextIndex() < myPlayList.size()) {
                            itr.remove();
                        }
                        else {
                            System.out.println("You are at the end");
                        }
                    }
                    break;
                case 6:
                    for (Song s : myPlayList) {
                        System.out.println(s);
                    }
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }

    }

    public static void printMenu() {
        System.out.println("1 : play the next song");
        System.out.println("2 : play the previous song");
        System.out.println("3 : Repeat the current song");
        System.out.println("4 : Show Main Menu");
        System.out.println("5 : Delete current song");
        System.out.println("6 : show the playlist");
        System.out.println("7 : Exit");
    }
}

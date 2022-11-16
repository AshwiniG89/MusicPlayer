package MucicPlayer;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums=new ArrayList<>();

    public static void main(String[] args){

        Album album=new Album("English","Maroon5");

        album.addSong("Memories",3.09);
        album.addSong("Maps",3.29);
        album.addSong("Girls Like You",3.05);
        album.addSong("Animals",3.15);
        album.addSong("One More Night",2.49);
        album.addSong("DayLight",3.19);
        album.addSong("Cold",3.54);
        album.addSong("Wait",3.11);
        album.addSong("What Love Do",3.20);
        albums.add(album);

        album=new Album("Kannada","Sanjeev Hegde");

        album.addSong("Kudi Notada",3.09);
        album.addSong("Marali Mansagide",3.29);
        album.addSong("Marethu Hoyithe",3.05);
        album.addSong("Soul of DIA",3.15);
        album.addSong("Hrudayake Hedarike",2.49);
        album.addSong("Shakunthale Sikkalu",3.19);
        album.addSong("Gatiya Heladu",3.54);
        album.addSong("Yava Kaviyu",3.11);
        album.addSong("Maadeva",3.20);
        albums.add(album);

        LinkedList<Songs> playList_1=new LinkedList<>();
        // we have only two albums and with 0 based indexing..

        albums.get(0).addToPlayList("Memories",playList_1);
        albums.get(0).addToPlayList("What Love Do",playList_1);
        albums.get(1).addToPlayList("Hrudayake Hedarike",playList_1);
        albums.get(1).addToPlayList("Soul of DIA",playList_1);
        albums.get(1).addToPlayList("Yava Kaviyu",playList_1);
        albums.get(0).addToPlayList("Cold",playList_1);
        albums.get(0).addToPlayList("Maps",playList_1);

        play(playList_1);
    }
    private static void play(LinkedList<Songs> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Songs> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("Playlist is Empty");
        } else {
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {

                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now Playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached end, restart");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("Beginning from start");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at Start");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now Playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We reached end, Restart");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size()>0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now Playing " + listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious())
                                System.out.println("Now Playing " + listIterator.previous().toString());
                            }
                        }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available Options\n press");
        System.out.println("0 - to quit\n"+
                "1-To Play Next Song\n"+
                "2-To Play Previous Song\n"+
                "3-To Repeat Current Song\n"+
                "4-To Play PlayList\n"+
                "5-To Print all Available Options\n"+
                "6-To Delete Current Song\n");
        //System.out.println();
        System.out.print("Choose Your Choice: ");
    }
    private static void printList(LinkedList<Songs> playList){
        Iterator<Songs> iterator=playList.iterator();
        System.out.println();
        System.out.println("************ PlayList ***********");
        System.out.println("---------------------------------");

        while ((iterator.hasNext())){
            System.out.println(iterator.next());
        }
        System.out.println("---------------------------------");
    }
}

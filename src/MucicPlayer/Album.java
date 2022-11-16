package MucicPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Songs> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Songs>();
    }
    public Album(){

    }
   public Songs findSong(String title){
        for(Songs checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }
    public boolean addSong(String title,double duration){
        if(findSong(title)==null){
            songs.add(new Songs(title,duration));
            //System.out.println(title+"Added to PlayList");
            return true;
        }else{
           // System.out.println(title+"Song is exist in PlayList");
            return false;
        }
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Songs> playList){
        int index=trackNumber-1;
        if(index>0 && index<=this.songs.size()){
            playList.add(this.songs.get(index));
            return  true;
        }
       // System.out.println("This trackNumber is not exist"+trackNumber);
        return false;
    }
    public boolean addToPlayList(String title,LinkedList<Songs> playList){
        for(Songs checkedSong : this.songs){
            if(checkedSong.getTitle().equals(title)){
                playList.add(checkedSong);
                return  true;
            }
        }
        System.out.println(title+"No such Song in this PlayList");
        return false;
    }
}

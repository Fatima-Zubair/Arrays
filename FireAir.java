import java.util.Scanner; 
class Operations{
    Scanner sc=new Scanner(System.in);
    String songs[];
    int size;
    Operations(String[] songs, int size){
        this.size=size;
        this.songs=songs;
    }
    void displaySong(){
    System.out.print("Songs are: ");
         for (String s : songs) {
            System.out.print(s+" ");
         }
         System.out.println();
    }
    void addSong(int n, String song){
       String[] songs1=new String[songs.length+1];
       if(n<0 || n>songs.length){
        System.out.println("Invalid index");
       }else{
       for(int i=0;i<songs.length+1; i++){
        if(i<n){
         songs1[i]=songs[i];
        }
        else if(i==n){
            songs1[i]=song;
        }
        else{
            songs1[i]=songs[i-1];
        }
       }
        songs=songs1;
        System.out.println("Song added successfully...!");
   }
    }
    void deleteSong(int n){
       
       String[] songs1=new String[songs.length-1];
       if(n<0 || n>=songs.length){
        System.out.println("Invalid index");
       }else{
       for(int i=0;i<songs.length-1; i++){
        if(i<n){
         songs1[i]=songs[i];
        }
        else{
            songs1[i]=songs[i+1];
        }
       }
        songs=songs1;
         System.out.println("Song deleted successfully...!");
   }
    }
    int searchSong(String song){
        int index=-1;
        for(int i=0;i<songs.length;i++){
            if(songs[i].equalsIgnoreCase(song)){
                index=i;
            }
        }
        return index;
    }
    void updateSong(int index, String song){

      if(index<0 || index>=songs.length){
        System.out.println("Invalid index");
      }
     else {
        songs[index] = song;
         System.out.println("Song updated successfully...!");
    }
    }
    void user_Interface(){
         int choice;
      do{
        System.out.println("Select what you want to do with your songs list");
        System.out.println("1: Display songs");
        System.out.println("2: Add song");
        System.out.println("3: Delete song");
        System.out.println("4: Search song");
        System.out.println("5: Update song");
        System.out.println("6: Exit");
        System.out.println("\n Enter your choice: ");
         choice=sc.nextInt();
        switch(choice){
            case 1:{displaySong();
                 break;
            }
            case 2:{System.out.println("Enter index of new song to be inserted:");
                 int n=sc.nextInt();
                 System.out.println("Enter name song to be added: ");
                 String song=sc.next();
                 addSong(n,song);
                 break;
            }
            case 3:{ System.out.println("Enter index of song to be deleted:");
                 int n=sc.nextInt();
                 deleteSong(n);
                 break;
            }
            case 4:{ System.out.println("Enter name of song which you want to search: ");
                 String song=sc.next();
                 int index=searchSong(song);
                 if(index!=-1){
              System.out.println("Song found at index "+index);
              
            }
            else{ System.out.println("Song not found ");
            }
            break;
            }
            case 5:{System.out.println("Enter index of song to be updated:");
                 int n=sc.nextInt();
                 System.out.println("Enter new name of song ");
                 String song=sc.next();
                 updateSong(n, song);
                 break;
            }
            case 6:{ System.out.println("Exited successfully");
                 System.exit(0);
                break;
            }
            default:{System.out.println("Invalid choice \nTry Again...");
                break;
            }
        }
    }while(choice!=6);
    }
}
public class FireAir {
    public static void main(String[] args) {
       System.out.println("   WELCOME TO FIRE AIR MUSIC APP    ");
       Scanner sc=new Scanner(System.in);
       System.out.println("\nEnter no of songs for your music list:" );
        int size=sc.nextInt();
        String songs[]=new String[size];
        System.out.println("Enter name of songs: ");
        for(int i=0; i<size; i++){
              songs[i]=sc.next();
        }
        Operations o1=new Operations(songs,size);
       o1.user_Interface();
    }
}

import java.util.ArrayList; // Import ArrayList for dynamic list storage
import java.util.Comparator; // Import Comparator for sorting

public class Playlist {
    private String name; // Name of the playlist
    private ArrayList<Song> songs; // List to store songs in the playlist

    // Constructor to initialize the playlist with a name
    public Playlist(String name) {
        this.name = name; // Set the playlist name
        this.songs = new ArrayList<>(); // Initialize the list of songs
    }

    // Getter for the playlist name
    public String getName() {
        return name;
    }

    // Method to add a song to the playlist
    public void addSong(Song song) {
        songs.add(song); // Add the song to the list
        System.out.println("Song added: " + song.getDetails()); // Notify the user
    }

    // Method to display all songs in the playlist
    public void displaySongs() {
        if (songs.isEmpty()) { // Check if the playlist is empty
            System.out.println("Your playlist is empty."); // Notify the user
            return; // Exit the method
        }
        System.out.println("Songs in playlist \"" + name + "\":"); // Print playlist name
        for (Song song : songs) { // Loop through each song
            System.out.println(song); // Print the song details
        }
    }

    // Method to check if a specific song exists in the playlist
    public boolean containsSong(Song song) {
        return songs.contains(song); // Return true if the song exists
    }

    // Method to filter songs by a specific artist
    public void filterByArtist(String artistName) {
        System.out.println("Songs by " + artistName + ":"); // Print the artist name
        for (Song song : songs) { // Loop through the songs
            if (song.getArtist().getName_artist().equalsIgnoreCase(artistName)) { // Check if artist matches
                System.out.println(song); // Print the song details
            }
        }
    }

    // Method to sort songs alphabetically by name
    public void sortSongs() {
        songs.sort(Comparator.comparing(Song::getName_song, String.CASE_INSENSITIVE_ORDER)); // Sort songs
        System.out.println("Songs sorted alphabetically."); // Notify the user
    }

    // Override toString method to provide details about the playlist
    @Override
    public String toString() {
        return "Playlist{name='" + name + "', songs=" + songs.size() + "}"; // Return playlist details
    }

    // Override equals method to compare playlists by name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // If the same object, return true
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class match
        Playlist playlist = (Playlist) obj; // Cast to Playlist
        return name.equalsIgnoreCase(playlist.name); // Compare names case-insensitively
    }

    // Override hashCode method for hash-based collections
    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode(); // Return hash code based on name
    }
}

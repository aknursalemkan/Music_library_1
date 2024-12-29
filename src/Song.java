public class Song {
    private String name_song; // Name of the song
    private Artist artist; // Artist of the song

    // Constructor to initialize the song with a name and artist
    public Song(String name_song, Artist artist) {
        this.name_song = name_song; // Set the song name
        this.artist = artist; // Set the artist
    }

    // Getter for the song name
    public String getName_song() {
        return name_song;
    }

    // Setter to update the song name
    public void setName_song(String name_song) {
        this.name_song = name_song;
    }

    // Getter for the artist
    public Artist getArtist() {
        return artist;
    }

    // Setter to update the artist
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    // Method to get details about the song
    public String getDetails() {
        return "Song: " + name_song + ", Artist: " + artist.getName_artist(); // Return song details
    }

    // Override toString method to display song details
    @Override
    public String toString() {
        return "Song: " + name_song + " by " + artist.getName_artist(); // Return song details
    }

    // Override equals method to compare songs by name and artist
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // If the same object, return true
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class match
        Song song = (Song) obj; // Cast to Song
        return name_song.equalsIgnoreCase(song.name_song) && artist.equals(song.artist); // Compare name and artist
    }

    // Override hashCode method for hash-based collections
    @Override
    public int hashCode() {
        return name_song.toLowerCase().hashCode() + artist.hashCode(); // Combine name and artist hash codes
    }
}

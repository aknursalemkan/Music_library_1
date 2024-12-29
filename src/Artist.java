public class Artist {
    private String name_artist; // Name of the artist

    // Constructor to initialize the artist with a name
    public Artist(String name_artist) {
        this.name_artist = name_artist; // Set the artist name
    }

    // Getter for the artist name
    public String getName_artist() {
        return name_artist;
    }

    // Setter to update the artist name
    public void setName_artist(String name_artist) {
        this.name_artist = name_artist;
    }

    // Override toString method to display artist details
    @Override
    public String toString() {
        return "Artist{name='" + name_artist + "'}"; // Return artist details
    }

    // Override equals method to compare artists by name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // If the same object, return true
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class match
        Artist artist = (Artist) obj; // Cast to Artist
        return name_artist.equalsIgnoreCase(artist.name_artist); // Compare names case-insensitively
    }

    // Override hashCode method for hash-based collections
    @Override
    public int hashCode() {
        return name_artist.toLowerCase().hashCode(); // Return hash code based on name
    }
}

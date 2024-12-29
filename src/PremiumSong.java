public class PremiumSong extends Song {
    private double price; // Price of the premium song

    // Constructor to initialize the premium song with name, artist, and price
    public PremiumSong(String name_song, Artist artist, double price) {
        super(name_song, artist); // Call the parent class constructor
        this.price = price; // Set the price
    }

    // Getter for the price
    public double getPrice() {
        return price;
    }

    // Override getDetails to include price information
    @Override
    public String getDetails() {
        return super.getDetails() + ", Price: $" + price; // Append price to details
    }

    // Override toString method to display premium song details
    @Override
    public String toString() {
        return "Premium Song: " + getName_song() + " by " + getArtist().getName_artist() + " (Price: $" + price + ")";
    }
}

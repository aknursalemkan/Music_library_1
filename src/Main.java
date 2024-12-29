import java.util.Scanner; // Import Scanner for user input

public class Main {
    // ANSI codes for text colors
    public static final String RESET = "\u001B[0m"; // Reset to default color
    public static final String RED = "\u001B[31m"; // Red color
    public static final String GREEN = "\u001B[32m"; // Green color
    public static final String YELLOW = "\u001B[33m"; // Yellow color
    public static final String BLUE = "\u001B[34m"; // Blue color
    public static final String CYAN = "\u001B[36m"; // Cyan color
    public static final String MAGENTA = "\u001B[35m"; // Magenta color

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner for input

        System.out.println(CYAN + "Hello! Welcome to my Music Library program!" + RESET); // Greeting
        System.out.println(YELLOW + "First, you should create a playlist." + RESET); // Prompt to create playlist
        System.out.println("Please enter the " + GREEN + "name of your playlist" + RESET + ": ");

        String playlistName = scanner.nextLine(); // Read playlist name
        Playlist playlist = new Playlist(playlistName); // Create playlist

        while (true) { // Infinite loop for menu
            // Display menu options
            System.out.println(BLUE + "\nNow you have the following options:" + RESET);
            System.out.println(MAGENTA + "1. Add a song to your playlist" + RESET);
            System.out.println(MAGENTA + "2. View playlist that you created" + RESET);
            System.out.println(MAGENTA + "3. Check if a song exists in the playlist" + RESET);
            System.out.println(MAGENTA + "4. Filter songs by artist" + RESET);
            System.out.println(MAGENTA + "5. Sort songs alphabetically" + RESET);
            System.out.println(MAGENTA + "6. Add a premium song to your playlist" + RESET);
            System.out.println(MAGENTA + "7. Exit the program" + RESET);

            System.out.print(BLUE + "Choose an option: " + RESET); // Ask for user input
            String choice = scanner.nextLine(); // Read user choice

            // Handle menu options
            switch (choice) {
                case "1": // Add a song
                    System.out.print(CYAN + "Enter the song name: " + RESET);
                    String songTitle = scanner.nextLine(); // Read song name
                    System.out.print(CYAN + "Enter the artist name: " + RESET);
                    String artistName = scanner.nextLine(); // Read artist name
                    Artist artist = new Artist(artistName); // Create artist
                    Song song = new Song(songTitle, artist); // Create song
                    playlist.addSong(song); // Add song to playlist
                    System.out.println(GREEN + "Added: " + song.getDetails() + RESET); // Confirmation
                    break;

                case "2": // View playlist
                    playlist.displaySongs(); // Display all songs
                    break;

                case "3": // Check if a song exists
                    System.out.print(CYAN + "Enter the song name to check: " + RESET);
                    String checkSongName = scanner.nextLine(); // Read song name
                    System.out.print(CYAN + "Enter the artist name to check: " + RESET);
                    String checkArtistName = scanner.nextLine(); // Read artist name
                    Artist checkArtist = new Artist(checkArtistName); // Create artist
                    Song checkSong = new Song(checkSongName, checkArtist); // Create song
                    if (playlist.containsSong(checkSong)) { // Check if song exists
                        System.out.println(YELLOW + "Song already exists" + RESET);
                    } else {
                        System.out.println(RED + "The song does not exist in the playlist." + RESET);
                    }
                    break;

                case "4": // Filter songs by artist
                    System.out.print(CYAN + "Enter artist name to filter songs: " + RESET);
                    String artistFilter = scanner.nextLine(); // Read artist name
                    playlist.filterByArtist(artistFilter); // Filter songs
                    break;

                case "5": // Sort songs alphabetically
                    playlist.sortSongs(); // Sort songs
                    playlist.displaySongs(); // Display sorted songs
                    break;

                case "6": // Add a premium song
                    System.out.print(CYAN + "Enter premium song name: " + RESET);
                    String premiumSongName = scanner.nextLine(); // Read song name
                    System.out.print(CYAN + "Enter artist name: " + RESET);
                    String premiumArtistName = scanner.nextLine(); // Read artist name
                    double price = -1; // Initialize price
                    while (true) { // Validate price input
                        System.out.print(CYAN + "Enter price: " + RESET);
                        String priceInput = scanner.nextLine(); // Read price
                        try {
                            price = Double.parseDouble(priceInput); // Parse price
                            if (price < 0) { // Check for negative price
                                System.out.println(RED + "Price cannot be negative. Please enter a valid positive number." + RESET);
                            } else {
                                break; // Exit loop if valid
                            }
                        } catch (NumberFormatException e) { // Handle invalid input
                            System.out.println(RED + "Invalid input! Please enter a valid number for the price." + RESET);
                        }
                    }
                    Artist premiumArtist = new Artist(premiumArtistName); // Create artist
                    PremiumSong premiumSong = new PremiumSong(premiumSongName, premiumArtist, price); // Create premium song
                    playlist.addSong(premiumSong); // Add premium song to playlist
                    System.out.println(GREEN + "Added premium song: " + premiumSong.getDetails() + RESET); // Confirmation
                    break;

                case "7": // Exit the program
                    System.out.println(BLUE + "Exiting the Music Streaming Library. Thank you for using! Goodbye!" + RESET);
                    scanner.close(); // Close Scanner
                    return; // Exit the program

                default: // Invalid option
                    System.out.println(RED + "There's no such option. Try again." + RESET);
            }
        }
    }
}

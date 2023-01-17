public class Song {
    private String title;         // my variables are private. This is to implement encapsulation [data hiding]
    private double duration;

    // created a constructor to assign values to title and duration
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return getTitle() + ". Duration is " + getDuration();
    }
    // Below methods are getters and setters which get values and assigns values to my private variables.

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Counter class that allows you to display a numerical score on screen.
 * 
 * The Counter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the Counter then you
 * can adjust its score.  Here's an example of a world class that
 * displays a counter with the number of act cycles that have occurred:
 * 
 * <pre>
 * class CountingWorld
 * {
 *     private Counter actCounter;
 *     
 *     public CountingWorld()
 *     {
 *         super(600, 400, 1);
 *         actCounter = new Counter("Act Cycles: ");
 *         addObject(actCounter, 100, 100);
 *     }
 *     
 *     public void act()
 *     {
 *         actCounter.setscore(actCounter.getscore() + 1);
 *     }
 * }
 * </pre>
 * 
 * @author Neil Brown and Michael Kölling 
 * @version 1.0
 */
public final class Counter extends UI
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    public int value = 0;
    public int target = 0;
    private String prefix;
    public static boolean goldcollect = false; 

    public Counter()
    {
        this(new String());
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public Counter(String prefix)
    {
        background = getImage();  // get image from class
        value = 5;
        target = 5;
        this.prefix = prefix;
        updateImage();
    }

    /**
     * Animate the display to count up (or down) to the current target score.
     */

    public void act() 
    {

        if (value < target) {
            value++;
            updateImage();
        }
        if (value > target) {
            value--;
            updateImage();
        }
    }

    /**
     * Add a new score to the current counter score.
     */
    public void addScore(int score)
    {
        target += score;
    }

    /**
     * Return the current counter score.
     */
    public int getscore()
    {
        return target;
    }

    /**
     * Set a new counter score.  This will not animate the counter.
     */
    public void setscore(int newscore)
    {
        target = newscore;
        value = newscore;
        updateImage();
    }

    /**
     * Sets a text prefix that should be displayed before
     * the counter score (e.g. "Score: ").
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }

    /**
     * Update the image on screen to show the current score.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.WHITE, transparent);

        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }

        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
            (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }

}

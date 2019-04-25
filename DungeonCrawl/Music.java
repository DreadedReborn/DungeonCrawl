import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Invisible, intangible class that controls music.
 * 
 * @author PC
 * @version Shop Update
 */
public class Music extends UI
{
    //====================================================================================================

    //Music.
    public GreenfootSound musicloop = new GreenfootSound("crowdhammer.mp3");
    public Boolean musicToggle = true;

    public Boolean musicStarted = false;

    /**
     * Act - do whatever the Music wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWorld();
        //checkToggle();
    }   

    /**
     * Toggles music muting.
     */
    public void checkToggle()
    {
        //String keypressed = Greenfoot.getKey();
        // if (keypressed != null)
        // {
        // if (keypressed.equals("m"))
        // {
        if (musicToggle){
            musicToggle = false;
            StopMusic();
        }
        else {
            musicToggle = true;
        }
        // }
        // }
    }

    /**
     * Checks what world the class is in.
     * For example, if in DeathWorld, stop music and run the DeathWorld music method.
     */
    private void checkWorld()
    {
        ActiveWorld currentWorld = (ActiveWorld)getWorld();
        if (currentWorld instanceof TestWorld)
        {
            if (!musicStarted){
                startWorldMusic();
            }
            else {
                WorldMusic();
            }
        }
        else if (currentWorld instanceof EndWorld)
        {
            WinWorldMusic();
        }
        else if (currentWorld instanceof DeathWorld)
        {
            DeathWorldMusic();
        }
        else if (currentWorld instanceof StartWorld)
        {
            //StartLevelMusic();
        }
    }

    /**
     * Stops currently playing music.
     */
    private void StopMusic()
    {
        musicloop.stop();
        //musicStarted = false;
    }

    /**
     * Plays unique start-screen music.
     */
    private void StartLevelMusic()
    {
        if (musicToggle){
            musicloop.playLoop();
            musicloop.setVolume(35);
            musicStarted = true;
        }
    }

    /**
     * Starts off the normal world music.
     */
    private void startWorldMusic()
    {
        if (musicToggle){
            musicloop.stop();
            musicloop.playLoop();
            musicloop.setVolume(40);
            musicStarted = true;
        }
    }

    /**
     * Loops normal world music.
     */
    private void WorldMusic()
    {
        if (!musicloop.isPlaying() )
        {
            if (musicToggle)
            {
                musicloop.playLoop();
            }
        }
    }

    /**
     * Plays death sound, ends normal music.
     */
    private void DeathWorldMusic()
    {
        musicloop.stop();
        Greenfoot.playSound("lose.mp3");
    }

    /**
     * Plays win sound, ends normal music.
     */
    private void WinWorldMusic()
    {
        musicloop.stop();
        Greenfoot.playSound("win.mp3");
    }

    /**
     * Fades the music in from being muted.
     * Unfinished.
     */
    private void muteFadeIn()
    {
        //int timer = 0;
        // while (timer == 0;
    }

    /**
     * Fades the music out after a mute request is made.
     * Unfinished.
     */
    private void muteFadeOut()
    {

    }

}

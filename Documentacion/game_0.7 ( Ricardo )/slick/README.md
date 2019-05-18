# Setting Up Slick2D With Eclipse IDE

## Library setup

    In the main menu, go to Window/Preferences.
    Go to Java/Build Path/User Libraries.
    Click New…
    Type Slick2d or anything you want to the field User library name then click OK.
    Click Add External JARs…, go to slick folder (where you extracted slick.zip) and add these '.jar' (all of them are in the 'lib' folder) :
        jinput.jar
        lwjgl.jar
        lwjgl_util.jar
        slick.jar

## Setting Up a Project to use Slick2D

    In a new Java project:
        Right-Click your project node, choose Properties or go to Project->Properties.
        Select Java Build Path.
        Select Libraries tab.
        Click Add Library…, select User Library, choose your Slick2D library.
        Right-Click your project node, choose Run As->Run Configurations.
        Create new configuration or edit your project's run configuration.
        Select Argument tab, on VM arguments put:

-Djava.library.path=<path to where you extracted slick.zip>


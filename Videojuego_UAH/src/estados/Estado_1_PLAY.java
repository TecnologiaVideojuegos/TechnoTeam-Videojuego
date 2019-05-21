package estados;

import java.awt.Font;
import personaje.Evento;
import principal.Estado_Juego;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Image;
import org.newdawn.slick.TrueTypeFont;
import modelos.Frase;

public class Estado_1_PLAY extends BasicGameState {

    public static boolean needToMapUpdate = false;

    public static Estado_Juego gameStatus;

    private Evento event;
    private int i = 1;

    private Image ventanaDialogo, avatarDialogo;
    private static final int POSICIONAVATARX = 30;
    private static final int POSICIONAVATARY = 600;

    public static boolean dialogo = false;
    public static boolean pelea = false;
    private TrueTypeFont personaje, frase;
    private Font tipo_letra_dialogo = new Font("Arial Black", Font.PLAIN, 15);

    public Estado_1_PLAY() {
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        gameStatus = new Estado_Juego();
        event = new Evento(Estado_Juego.sprite);
        ventanaDialogo = new Image("graphic/dialogo/cajaTexto.png");

        personaje = new TrueTypeFont(tipo_letra_dialogo, true);
        frase = new TrueTypeFont(tipo_letra_dialogo, true);

    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {

        Input input = container.getInput();
        int xPos = Mouse.getX();
        int yPos = Mouse.getY();

        event.update(container, sbg, delta, gameStatus, input, xPos, yPos);

        if (needToMapUpdate) {
            updateGameStatus(container);
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        if (!Estado_Juego.music.playing()) {
            Estado_Juego.music.play();
        }
        Input input = container.getInput();
        try {
            gameStatus.map = new TiledMap("graphic/map/" + Integer.toString(Estado_Juego.levelID) + ".tmx");
            gameStatus.map.render(0, 0, 0);
            gameStatus.updateEntityFieldList(gameStatus.map);
        } catch (SlickException e) {
            System.out.println("Error en updateGameStatus playState");
        }
        Estado_Juego.sprite.avatar.draw(Estado_Juego.pos_x_hero, Estado_Juego.pos_y_hero);
        if (Estado_Juego.enemys.get(Estado_Juego.levelID) != null && !Estado_Juego.enemys.get(Estado_Juego.levelID).isMuerto()) {
            Estado_Juego.enemys.get(Estado_Juego.levelID).getSprite().avatar.draw(Estado_Juego.enemys.get(Estado_Juego.levelID).getX_pos(), Estado_Juego.enemys.get(Estado_Juego.levelID).getY_pos());
        }
        if (lucha_dragon() == false) {
            renderDialogo(input, sbg);
        } else if (lucha_dragon() == true) {
            renderDialogoDragon(input, sbg);
        }

    }

    public void updateGameStatus(GameContainer container) {
        needToMapUpdate = false;
        gameStatus.updatePortalMapList(gameStatus.portalMapList);
    }
    
    @Override

    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
        Estado_Juego.music.stop();
    }

    private boolean lucha_dragon() {
        if (Estado_Juego.enemys.get(400).isMuerto() && Estado_Juego.enemys.get(401).isMuerto() && Estado_Juego.enemys.get(403).isMuerto() && Estado_Juego.enemys.get(404).isMuerto() && Estado_Juego.levelID == 402) {
            return true;
        }
        return false;
    }

    private void renderDialogoDragon(Input input, StateBasedGame sbg) throws SlickException {
        Frase f = Estado_Juego.dialogo.get((Estado_Juego.levelID * 10) + i);
        if (dialogo && Estado_Juego.dialogo.get((Estado_Juego.levelID * 10) + i) != null) {
            this.ventanaDialogo.draw(0, 620, 1);

            if (f.getPersonaje().equalsIgnoreCase("Hero")) {
                avatarDialogo = new Image("graphic/dialogo/" + Estado_Juego.hero.getIdHero() + ".png");
                personaje.drawString(160, 625, Estado_Juego.hero.getHeroName());
            } else {
                avatarDialogo = new Image("graphic/dialogo/" + f.getIdPersonaje() + ".png");
                personaje.drawString(160, 625, f.getPersonaje());
            }
            this.avatarDialogo.draw(POSICIONAVATARX, POSICIONAVATARY, 1);
            frase.drawString(160, 645, f.getFrase());
            if (input.isKeyPressed(Input.KEY_SPACE)) {
                i++;
            }
        } else if (Estado_Juego.dialogo.get((Estado_Juego.levelID * 10) + i) == null && !Estado_Juego.enemys.get(Estado_Juego.levelID).isMuerto()) {
            dialogo = false;
            sbg.enterState(7);

        }
    }

    private void renderDialogo(Input input, StateBasedGame sbg) throws SlickException {
        Frase f = Estado_Juego.dialogo.get((Estado_Juego.levelID * 10) + i);
        if (dialogo && Estado_Juego.dialogo.get((Estado_Juego.levelID * 10) + i) != null) {
            this.ventanaDialogo.draw(0, 620, 1);

            if (Estado_Juego.levelID != 402) {
                if (f.getPersonaje().equalsIgnoreCase("Hero")) {
                    avatarDialogo = new Image("graphic/dialogo/" + Estado_Juego.hero.getIdHero() + ".png");
                    personaje.drawString(160, 625, Estado_Juego.hero.getHeroName());
                } else {
                    avatarDialogo = new Image("graphic/dialogo/" + f.getIdPersonaje() + ".png");
                    personaje.drawString(160, 625, f.getPersonaje());
                }
                this.avatarDialogo.draw(POSICIONAVATARX, POSICIONAVATARY, 1);
                frase.drawString(160, 645, f.getFrase());
            } else if (Estado_Juego.levelID == 402) {
                frase.drawString(160, 645, "DERROTA A TODOS LOS ENEMIGOS Y PODRÁS LUCHAR CON EL DRAGÓN");
            }

            if (input.isKeyPressed(Input.KEY_SPACE)) {
                i++;
            }
        } else if (Estado_Juego.dialogo.get((Estado_Juego.levelID * 10) + i) == null && !Estado_Juego.enemys.get(Estado_Juego.levelID).isMuerto()) {
            dialogo = false;
            sbg.enterState(7);

        }
        if (Estado_Juego.huir || Estado_Juego.ganar) {
            i = 1;
            Estado_Juego.huir = false;
            Estado_Juego.ganar = false;
        }
    }
}

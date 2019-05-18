package estados;

import principal.GameStatus;
import principal.SpriteHero;
import utils.Fonts;
import modelos.Hero;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import personaje.Ataque;

public class CrearProtagonista extends BasicGameState {

    Image fondo;
    Image fondoCrearProtagonista;
    String mouse;

    private static String avatarName = "";
    public Ataque ataque1;
    public Ataque ataque2;
    public Ataque ataque3;

    Image[] avatar = new Image[3];

    int actualImage;

    int contador = 0;
    int posicion = 0;

    Color colorTexto = Color.white;
    Color opcionSeleccionada = Color.orange;

    Color ctab[] = {colorTexto, colorTexto, colorTexto};

    public CrearProtagonista() {
    }

    @Override
    public int getID() {
        return 14;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        fondo = new Image("graphic/menu/backgroundMainMenu.jpg");
        fondoCrearProtagonista = new Image("graphic/menu/CreateNewHeroBg.png");
        mouse = "";

        avatar[0] = new Image("graphic/heroSprite/avatar1.png").getSubImage(0, 0, 55, 64);
        avatar[1] = new Image("graphic/heroSprite/avatar2.png").getSubImage(0, 0, 55, 64);

        GameStatus.hero = new Hero();

        actualImage = 0;
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        mouse = "x= " + xpos + " y=" + ypos;
        for (int j = 0; j < ctab.length; j++) {
            ctab[j] = colorTexto;
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            sbg.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
        if (input.isKeyPressed(Input.KEY_BACK)) {
            if (avatarName.length() > 0) {
                avatarName = avatarName.substring(0, avatarName.length() - 1);
            }
        }
        if (avatarName.length() < 7) {

            if (input.isKeyPressed(Input.KEY_A)) {
                avatarName += "A";
            } else if (input.isKeyPressed(Input.KEY_B)) {
                avatarName += "B";
            } else if (input.isKeyPressed(Input.KEY_C)) {
                avatarName += "C";
            } else if (input.isKeyPressed(Input.KEY_D)) {
                avatarName += "D";
            } else if (input.isKeyPressed(Input.KEY_E)) {
                avatarName += "E";
            } else if (input.isKeyPressed(Input.KEY_F)) {
                avatarName += "F";
            } else if (input.isKeyPressed(Input.KEY_G)) {
                avatarName += "G";
            } else if (input.isKeyPressed(Input.KEY_H)) {
                avatarName += "H";
            } else if (input.isKeyPressed(Input.KEY_I)) {
                avatarName += "I";
            } else if (input.isKeyPressed(Input.KEY_J)) {
                avatarName += "J";
            } else if (input.isKeyPressed(Input.KEY_K)) {
                avatarName += "K";
            } else if (input.isKeyPressed(Input.KEY_L)) {
                avatarName += "L";
            } else if (input.isKeyPressed(Input.KEY_M)) {
                avatarName += "M";
            } else if (input.isKeyPressed(Input.KEY_N)) {
                avatarName += "N";
            } else if (input.isKeyPressed(Input.KEY_O)) {
                avatarName += "O";
            } else if (input.isKeyPressed(Input.KEY_P)) {
                avatarName += "P";
            } else if (input.isKeyPressed(Input.KEY_R)) {
                avatarName += "R";
            } else if (input.isKeyPressed(Input.KEY_S)) {
                avatarName += "S";
            } else if (input.isKeyPressed(Input.KEY_T)) {
                avatarName += "T";
            } else if (input.isKeyPressed(Input.KEY_U)) {
                avatarName += "U";
            } else if (input.isKeyPressed(Input.KEY_W)) {
                avatarName += "W";
            } else if (input.isKeyPressed(Input.KEY_X)) {
                avatarName += "X";
            } else if (input.isKeyPressed(Input.KEY_Y)) {
                avatarName += "Y";
            } else if (input.isKeyPressed(Input.KEY_Z)) {
                avatarName += "Z";
            }
        }

        //str - BUTTON
        if (GameStatus.hero.fuerza > 1) {
            if ((xpos > 610 && xpos < 640) && (ypos > 425 && ypos < 455)) {
                if (input.isMousePressed(0)) {
                    GameStatus.hero.fuerza--;
                    GameStatus.hero.levelPoints++;
                }
            }
        }
        //agi - BUTTON
        if (GameStatus.hero.resistencia > 1) {
            if ((xpos > 610 && xpos < 640) && (ypos > 375 && ypos < 405)) {
                if (input.isMousePressed(0)) {
                    GameStatus.hero.resistencia--;
                    GameStatus.hero.levelPoints++;
                }
            }
        }
        //int - BUTTON
        if (GameStatus.hero.magia > 1) {
            if ((xpos > 610 && xpos < 640) && (ypos > 325 && ypos < 355)) {
                if (input.isMousePressed(0)) {
                    GameStatus.hero.magia--;
                    GameStatus.hero.levelPoints++;
                }
            }
        }

        if (GameStatus.hero.levelPoints > 0) {
            //str + BUTTON
            if ((xpos > 650 && xpos < 675) && (ypos > 425 && ypos < 455)) {
                if (input.isMousePressed(0)) {
                    GameStatus.hero.fuerza++;
                    GameStatus.hero.levelPoints--;
                }
            }
            //agi + BUTTON
            if ((xpos > 650 && xpos < 675) && (ypos > 375 && ypos < 405)) {
                if (input.isMousePressed(0)) {
                    GameStatus.hero.resistencia++;
                    GameStatus.hero.levelPoints--;
                }
            }
            //int + BUTTON
            if ((xpos > 650 && xpos < 675) && (ypos > 325 && ypos < 355)) {
                if (input.isMousePressed(0)) {
                    GameStatus.hero.magia++;
                    GameStatus.hero.levelPoints--;
                }
            }
        }

        //NEXT BUTTON
        if ((xpos > 722 && xpos < 889) && (ypos > 305 && ypos < 342)) {
            ctab[2] = opcionSeleccionada;
            if (input.isMousePressed(0)) {
                switch (actualImage) {
                    case 0:
                        actualImage = 1;
                        break;
                    case 1:
                        actualImage = 0;
                        break;
                }
            }
        }
        //BACK BUTTON
        if ((xpos > 457 && xpos < 606) && (ypos > 220 && ypos < 263)) {
            ctab[1] = opcionSeleccionada;
            if (input.isMousePressed(0)) {
                principal.GameStatus.hero = new Hero();
                sbg.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

                if (input.isMouseButtonDown(0)) {
                    ctab[1] = Color.gray;
                }
            }
        }
        //START BUTTON

        if ((xpos > 664 && xpos < 813) && (ypos > 220 && ypos < 263)) {
            ctab[0] = opcionSeleccionada;
            if (input.isMousePressed(0) && !avatarName.equalsIgnoreCase("")) {
                Play.gameStatus = new GameStatus();
                GameStatus.spriteNumber = (actualImage + 1);
                GameStatus.sprite = new SpriteHero();
                GameStatus.hero.heroName = avatarName;
                if(actualImage==0){
                    ataque1 = new Ataque(35, 30, "Pianazo1", "Lanzará un piano para causar un daño leve", 10);
                    ataque2 = new Ataque(55, 10, "Metrica Exacta1", "Regañará al enemigo por no llevar el ritmo acorde e inflingirá daño por humillación", 20);
                    ataque3 = new Ataque(75, 5, "Peluco Victoriano1", "Lanzará su tremenda peluca para destrozar los sueños capilares del enemigo, causando un daño LETAL!!!", 40);
                }else if(actualImage==1){
                    ataque1 = new Ataque(35, 30, "Pianazo2", "Lanzará un piano para causar un daño leve", 10);
                    ataque2 = new Ataque(55, 10, "Metrica Exacta2", "Regañará al enemigo por no llevar el ritmo acorde e inflingirá daño por humillación", 20);
                    ataque3 = new Ataque(75, 5, "Peluco Victoriano2", "Lanzará su tremenda peluca para destrozar los sueños capilares del enemigo, causando un daño LETAL!!!", 40);  
                }
                GameStatus.hero.getAtaques().add(ataque1);
                GameStatus.hero.getAtaques().add(ataque2);
                GameStatus.hero.getAtaques().add(ataque3);
                sbg.enterState(20, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            }
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        fondo.draw(0, 0);
        fondoCrearProtagonista.draw(0, 0);

        avatar[actualImage].draw(750, 230, 2.0f);

        Fonts.print18().drawString(10, 10, mouse);
        Fonts.print46().drawString(385, 60, "CREA TU PERSONAJE");
        Fonts.print28().drawString(415, 140, "NOMBRE:");
        Fonts.print28().drawString(610, 140, avatarName);

        switch (avatarName.length()) {
            case 0:
                posicion = 600;
                break;
            case 1:
                posicion = 620;
                break;
            case 2:
                posicion = 640;
                break;
            case 3:
                posicion = 660;
                break;
            case 4:
                posicion = 680;
                break;
            case 5:
                posicion = 700;
                break;
            case 6:
                posicion = 720;
                break;
            case 7:
                posicion = 740;
                break;
            case 8:
                posicion = 760;
                break;
        }

        Fonts.print18().drawString(410, 269, "Fuerza");
        Fonts.print18().drawString(410, 319, "Resistencia");
        Fonts.print18().drawString(410, 368, "Magia");

        Fonts.print18().drawString(576, 270, String.valueOf(GameStatus.hero.fuerza));
        Fonts.print18().drawString(576, 319, String.valueOf(GameStatus.hero.resistencia));
        Fonts.print18().drawString(576, 367, String.valueOf(GameStatus.hero.magia));

        Fonts.print18().drawString(440, 210, "PUNTOS");
        Fonts.print18().drawString(508, 470, "VOLVER", ctab[1]);
        Fonts.print18().drawString(709, 470, "EMPEZAR", ctab[0]);
        Fonts.print18().drawString(760, 390, "SIGUENTE", ctab[2]);

        Fonts.print18().drawString(625, 210, String.valueOf(GameStatus.hero.levelPoints));
    }
}

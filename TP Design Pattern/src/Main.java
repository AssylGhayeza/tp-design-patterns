import javax.swing.text.html.HTMLDocument;
import java.util.Random;

interface State {
    void attack();
    void move();
    void heal();
    void calm();
    String showState();

}

class NormalState implements State {
    public void attack(){
        System.out.println("Character is attacking");
    }
    public void move(){
        System.out.println("Character is moving ");
    }
    public void calm(){
        System.out.println("Character is already calm");
    }

    public void heal(){
        System.out.println("Character is not poisoned");
    }
    public String showState(){
        return "is in Normal State";
    }

}
class EnragedState implements State {
    public void attack(){
        System.out.println("Character is attacking with rage");
    }
    public void move(){
        System.out.println("Character is moving ");
    }
    public void heal(){
        System.out.println("Character is not poisoned");
    }
    public void calm(){
        System.out.println("Character has calmed down");
    }
    public String showState(){
        return "is in Enraged State";
    }
}
class PoisonedState implements State {
    public void attack(){
        System.out.println("Character Cannot attack because it is poisoned");
    }
    public void move(){
        System.out.println("Character cannot move because it is poisoned ");
    }
    public void calm(){
        System.out.println("Character is already calm");
    }
    public void heal(){
        System.out.println("Character has healed from poison");
    }
    public String showState(){
        return "is Poisoned";
    }
}
class Character {
    String name;
    State state;
    //add attribute state figure out how to use the interface state
    public Character(){
        this.name="New Character";
        this.state = new NormalState() ;
    }

    public Character(String name){
        this.name = name;
        this.state = new NormalState();
    }
    public void getCharacterStatus(){
        System.out.println(this.name + " " +this.state.showState());
    }
    public State getState(){
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void attackCharacter(Character target){

        Random rng = new Random();
        int generatedNumber;
        generatedNumber=rng.nextInt(100);
        if (generatedNumber < 30) {
            this.setState(new EnragedState());
            System.out.println("Your Character became enraged");
        } else if (generatedNumber >=30 && generatedNumber < 60) {
            target.setState(new EnragedState());
            System.out.println("Opponent became enraged");
        }
        else {
            System.out.println("No one became enraged but attack executed successfully");
        }

    }
}
public class Main {
    public static void main(String[] args) {

        System.out.println("Get ready for the next Battle");
        Character Jin = new Character("Jin Kazama");
        Jin.getCharacterStatus();
        Character crash_bandicoot = new Character("Crash bandicoot");
        crash_bandicoot.getCharacterStatus();
        System.out.println("Round 1, FIGHT!");
        Jin.attackCharacter(crash_bandicoot);
        crash_bandicoot.getCharacterStatus();
        Jin.getCharacterStatus();
        System.out.println("Round 2, FIGHT!");
        Jin.attackCharacter(crash_bandicoot);
        crash_bandicoot.getCharacterStatus();

        Jin.getCharacterStatus();


    }
}
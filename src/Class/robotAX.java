package Class;

/**
 * Třída pro vytvoření objektu robotAX s jeho parametry
 */
public class robotAX extends Player {
private String dialogue;
private String dialogue1;
private String dialogue1question;
private String count;
private String answer;
private String dialogue2;
private String ending;

    public String getDialogue() {
        return dialogue;
    }
    public String getCount() {
        return count;
    }
    public String getDialogue1() {
        return dialogue1;
    }
    public String getDialogue1question() {
        return dialogue1question;
    }
    public String getAnswer() {
        return answer;
    }
    public String getDialogue2() {
        return dialogue2;
    }
    public String getEnding() {
        return ending;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public void setDialogue1(String dialogue1) {
        this.dialogue1 = dialogue1;
    }

    public void setDialogue1question(String dialogue1question) {
        this.dialogue1question = dialogue1question;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setDialogue2(String dialogue2) {
        this.dialogue2 = dialogue2;
    }

    public void setEnding(String ending) {
        this.ending = ending;
    }
}
